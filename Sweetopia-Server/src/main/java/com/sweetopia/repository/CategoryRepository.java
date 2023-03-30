package com.sweetopia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweetopia.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
	public Category findByCategoryName(String categoryName);

}
