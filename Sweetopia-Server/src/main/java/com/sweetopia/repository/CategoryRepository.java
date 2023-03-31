package com.sweetopia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweetopia.entity.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
	public Optional<Category> findByCategoryName(String categoryName);

}
