package controller;

import entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ICategoryService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    @Autowired
    private ICategoryService categoryService;

    // Hiển thị danh sách categories
    @GetMapping("")
    public String listCategories(Model model) {
        List<CategoryEntity> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/categories/list";
    }

    // Form thêm mới
    @GetMapping("/add")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new CategoryEntity());
        return "admin/categories/form"; // view form.html
    }

    // Lưu hoặc cập nhật
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@ModelAttribute("category") CategoryEntity category) {
        categoryService.save(category);
        return "redirect:/admin/categories"; // quay lại danh sách
    }

    // Sửa theo id
    @GetMapping("/edit/{categoryId}")
    public String editCategory(@PathVariable("categoryId") Long id, Model model) {
        Optional<CategoryEntity> opt = categoryService.findById(id);
        if (opt.isPresent()) {
            model.addAttribute("category", opt.get());
            return "admin/categories/form";
        }
        return "redirect:/admin/categories";
    }

    // Xóa theo id
    @GetMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") Long id) {
        categoryService.deleteById(id);
        return "redirect:/admin/categories";
    }

    // Tìm kiếm theo tên
    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<CategoryEntity> results = categoryService.findByNameContaining(keyword);
        model.addAttribute("categories", results);
        model.addAttribute("keyword", keyword);
        return "admin/categories/list";
    }

    // Tìm kiếm + phân trang
    @GetMapping("/searchpaginated")
    public String searchPaginated(@RequestParam(value = "keyword", required = false) String keyword,
                                  @RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "5") int size,
                                  Model model) {
        Page<CategoryEntity> resultPage;
        if (keyword != null && !keyword.isEmpty()) {
            resultPage = categoryService.findByNameContaining(keyword, PageRequest.of(page, size));
        } else {
            resultPage = categoryService.findAll(PageRequest.of(page, size));
        }

        model.addAttribute("categories", resultPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", resultPage.getTotalPages());
        model.addAttribute("keyword", keyword);

        return "admin/categories/list";
    }
}
