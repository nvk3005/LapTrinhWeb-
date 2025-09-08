package vn.iotstar.controller;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;
import vn.iotstar.utils.Constant;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import java.io.File;

/**
 * Servlet implementation class CategoryEditController
 */
@WebServlet(urlPatterns = { "/category/edit" })
public class CategoryEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryEditController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		CategoryModel category = cateService.get(Integer.parseInt(id));
		request.setAttribute("category", category);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/editcategory.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoryModel category = new CategoryModel();
		DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
		JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
		upload.setHeaderCharset(Charset.forName("UTF-8"));
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (item.getFieldName().equals("id")) {
                    category.setCateid(Integer.parseInt(item.getString()));
                }
                else if (item.getFieldName().equals("name")) {
                    category.setCatename(item.getString());
                }
                else if (item.getFieldName().equals("icon")) {
                    if (item.getSize() > 0) {
                        String originalFileName = item.getName();
                        int index = originalFileName.lastIndexOf(".");
                        String ext = originalFileName.substring(index + 1);
                        String fileName = System.currentTimeMillis() + "." + ext;
                        File file = new File(Constant.DIR + "/category/" + fileName);
                        item.write(file.toPath());
                        category.setIcon("category/"+fileName);
                    }
                    else {
                        category.setIcon(null);
                    }
                }
            }

            cateService.edit(category);
            response.sendRedirect(request.getContextPath() + "/category/list");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
}
