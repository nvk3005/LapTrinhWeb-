package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.iotstar.model.UserModel;
import vn.iotstar.services.UserServices;
import vn.iotstar.services.impl.UserServicesImpl;
import vn.iotstar.utils.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet(urlPatterns = { "/profile" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_FILENAME = "default.file";
	UserServices userServices = new UserServicesImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
	}

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return DEFAULT_FILENAME;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		UserModel account = (UserModel) session.getAttribute("account");

		String fullName = request.getParameter("fullname");
		String phone = request.getParameter("phone");

		String uploadPath = File.separator + Constant.DIR;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();
		try {
			String fileName = "";
			for (Part part : request.getParts()) {
				fileName = getFileName(part);
				part.write(uploadPath + File.separator + fileName);
			}
			account.setFullName(fullName);
			account.setPhone(phone);
			account.setAvatar(fileName);
			session.setAttribute("account", account);
			userServices.update(account.getId(), fullName, phone, fileName);
			request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
			response.sendRedirect(request.getContextPath() + "/profile");
		} catch (FileNotFoundException fne) {
			request.setAttribute("message", "There was an error: " + fne.getMessage());
			request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
		}
	}
}
