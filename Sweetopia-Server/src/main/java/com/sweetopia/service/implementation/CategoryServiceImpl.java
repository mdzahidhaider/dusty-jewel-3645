package com.sweetopia.service.implementation;

import java.util.List;
import java.util.Optional;

import com.sweetopia.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetopia.entity.Category;
import com.sweetopia.entity.Product;
import com.sweetopia.exception.CategoryException;
import com.sweetopia.repository.CategoryRepository;
import com.sweetopia.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
    private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Override
	public Category addCategory(Category c) throws CategoryException {
		// TODO Auto-generated method stub
		if(c.getCategoryId() != null) {
			Optional<Category> cat = categoryRepository.findById(c.getCategoryId());
			Optional<Category> cat1 = categoryRepository.findByCategoryName(c.getCategoryName());
			if(cat.isPresent()) {
				throw new CategoryException("category is already present with the given id");
			}
			if(cat1.isPresent()) {
				throw new CategoryException("category is already present with the given name");
			}
		}
		
		 return categoryRepository.save(c);
		
		
	}

	@Override
	public Category updateCategory(Category c) throws CategoryException {
		System.out.println(c);
		Category category=null;
		if(c.getCategoryId() != null) {
			Optional<Category> cat = categoryRepository.findById(c.getCategoryId());

			if(cat.isEmpty()) {
				throw new CategoryException("category is not present with the given id");
			}
			category=cat.get();

		}
		category.setCategoryName(c.getCategoryName());
		category.setCategoryImage(c.getCategoryImage());

		 return categoryRepository.save(c);
		
	}

	@Override
	public Category cancelCategory(Long categoryId) throws CategoryException {
		Optional<Category> c = categoryRepository.findById(categoryId);
		if(c.isEmpty()) {
			throw new CategoryException("Category not found");
		}

		categoryRepository.delete(c.get());
		return c.get();
	}

	@Override
	public List<Category> showAllCategory() throws CategoryException {
		// TODO Auto-generated method stub
		List<Category> list = categoryRepository.findAll();
		if(list.size()==0) {
			throw new CategoryException("Category not found");
		}
		return list;
	}

	@Override
	public double calculateTotalCost(Long categoryId) throws CategoryException {
		Optional<Category> cat = categoryRepository.findById(categoryId);
		if(cat.isEmpty()) 
			throw new CategoryException("category not found");
	    List<Product> list = cat.get().getProducts();
	    double cost = 0.0;
	    
	    for(Product p : list) {
	    	cost += p.getPrice();
	    }
		return cost;
	}

	@Override
	public Category getCategory(Long categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		Optional<Category> cat = categoryRepository.findById(categoryId);
		if(cat.isEmpty()) 
			throw new CategoryException("Category not found");
		
		return cat.get();
	}

	@Override
	public List<Product> getProductsOfCategory(Long categoryId) throws CategoryException {
		Category category=getCategory(categoryId);

		List<Product> products = productRepository.findByCategoryId(categoryId);

		if(products.isEmpty())throw new CategoryException("No products in the given category");
		return products;
	}


}