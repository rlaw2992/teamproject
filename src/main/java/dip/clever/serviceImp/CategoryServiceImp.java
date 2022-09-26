package dip.clever.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dip.clever.mapper.CategoryMapper;
import dip.clever.model.Category;
import dip.clever.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{
	@Autowired
	private CategoryMapper categoryMapper;
	
	//카테고리 목록 반환
	@Override
	public List<Category> selectCategoryList() {
		return categoryMapper.selectCategoryList();		
	}

	@Override
	public Category selectCategory(Category category) {
		return categoryMapper.selectCategory(category.getCategoryNo());
	}

	@Override
	public void insertCategory(Category category) {
		categoryMapper.insertCategory(category.getCategoryName());
	}
}
