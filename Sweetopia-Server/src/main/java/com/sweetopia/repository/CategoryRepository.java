package com.sweetopia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweetopia.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
	public Optional<Category>  findByCategoryName(String categoryName);

}
