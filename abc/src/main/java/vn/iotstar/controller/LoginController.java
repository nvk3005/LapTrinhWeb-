package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import vn.iotstar.model.UserModel;
import vn.iotstar.services.UserServices;
import vn.iotstar.services.impl.UserServicesImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login" })
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public static final String SESSION_USERNAME = "username";
    public static final String COOKIE_REMEMBER = "username";

    public LoginController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Gọi trang login.jsp thay vì in text ra
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        boolean isRememberMe = "on".equals(remember);

        String alertMsg = "";

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
            return;
        }

        UserServices service = new UserServicesImpl();
        UserModel user = service.login(username, password);

        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("account", user);

            if (isRememberMe) {
                saveRememberMe(response, username);
            }

            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            alertMsg = "Tài khoản hoặc mật khẩu không đúng";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
    }

    private void saveRememberMe(HttpServletResponse response, String username) {
        Cookie cookie = new Cookie(COOKIE_REMEMBER, username);
        cookie.setMaxAge(30 * 60); 
        response.addCookie(cookie);
    }
}
