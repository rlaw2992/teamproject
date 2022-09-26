package dip.clever.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dip.clever.model.Category;

@Service
public interface CategoryService {
	public List<Category> selectCategoryList();
	
	public Category selectCategory(Category category);
	
	public void insertCategory(Category category);
}