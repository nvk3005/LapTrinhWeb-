package vn.iotstar.services;

import java.util.List;

import vn.iotstar.model.CategoryModel;

public interface CategoryService {
	void insert(CategoryModel category);
	void edit(CategoryModel category);
	void delete(int id);
	CategoryModel get(int id);
	CategoryModel get(String name);
	List<CategoryModel> getAll();
	List<CategoryModel> search(String keyword);
}
