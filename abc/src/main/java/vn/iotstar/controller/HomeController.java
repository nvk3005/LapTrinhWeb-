package vn.iotstar.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.model.UserModel;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/home", "/trang-chu" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (session != null) {
			UserModel acc = (UserModel) session.getAttribute("account");

			if (acc != null) {
				out.println("Xin chào " + acc.getUserName());
			} else {
				out.println("Chưa đăng nhập!");
			}
		} else {
			out.println("Chưa có session!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
