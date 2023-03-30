package com.sweetopia.service;

import java.util.List;

import com.sweetopia.entity.Category;
import com.sweetopia.exception.CategoryException;

public interface CategoryService {
	
	public Category addCategory(Category category) throws CategoryException;
	public Category updateCategory(Category category) throws CategoryException;
	public Category cancelCategory(Long categoryId) throws CategoryException;
	public List<Category> showAllCategory() throws CategoryException;
	public double calculateTotalCost(Long categoryId) throws CategoryException;
	public Category getCategory(Long categoryId) throws CategoryException;
 
}
