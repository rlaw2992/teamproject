package dip.clever.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dip.clever.model.Category;

@Mapper
public interface CategoryMapper {
	public List<Category> selectCategoryList();
	
	public Category selectCategory(int categoryNo);
	
	public void insertCategory(String categoryName);
}