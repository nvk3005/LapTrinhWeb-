package controller;

import hien.project.entity.Category;
import hien.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// Hiển thị danh sách (phân trang)
	@GetMapping
	public String listCategories(Model model, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Page<Category> categories = categoryService.findAll(PageRequest.of(page, size));
		model.addAttribute("categories", categories);
		return "categories/list"; // trỏ tới file JSP: /WEB-INF/views/categories/list.jsp
	}

	// Tìm kiếm
	@GetMapping("/search")
	public String searchCategory(Model model, @RequestParam String keyword, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Page<Category> categories = categoryService.findByCategoryNameContaining(keyword, PageRequest.of(page, size));
		model.addAttribute("categories", categories);
		model.addAttribute("keyword", keyword);
		return "categories/list";
	}

	// Hiển thị form thêm mới
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("category", new Category());
		return "categories/add";
	}

	// Xử lý thêm mới
	@PostMapping("/add")
	public String addCategory(@ModelAttribute("category") Category category) {
		categoryService.save(category);
		return "redirect:/categories";
	}

	// Sửa
	@PostMapping("/edit/{id}")
	public String updateCategory(@PathVariable("id") Integer id, @ModelAttribute("category") Category categoryForm) {
		// Lấy category gốc từ DB
		Category category = categoryService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));

		// Cập nhật field cần sửa từ form
		category.setCategoryName(categoryForm.getCategoryName());
		category.setImages(categoryForm.getImages());

		// Lưu lại
		categoryService.save(category);

		return "redirect:/categories";
	}

	// Xóa
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable("id") Integer id) {
		categoryService.deleteById(id);
		return "redirect:/categories";
	}
}
