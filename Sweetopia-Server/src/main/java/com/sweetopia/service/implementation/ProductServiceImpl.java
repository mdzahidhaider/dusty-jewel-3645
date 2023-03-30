package com.sweetopia.service.implementation;

import com.sweetopia.entity.Category;
import com.sweetopia.entity.Product;
import com.sweetopia.exception.ProductException;
import com.sweetopia.repository.ProductRepository;
//import com.sweetopia.repository.CategoryRepository;
import com.sweetopia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
//    @Autowired
//    private CategoryRepository categoryRepository;


    @Override
    public Product addProduct(Product product) throws ProductException {
        if(product.getProductId()!=null){
            Long id=product.getProductId();
            if(productRepository.findById(id).isPresent())throw new ProductException("Product already present");
        }
//        Optional<Category> category=categoryRepository.findByCategoryName(product.getCategory().getCategoryName());
//        if(category.isPresent())product.setCategory(category.get());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) throws ProductException {
        if(product.getProductId()!=null){
            Long id=product.getProductId();
            if(productRepository.findById(id).isEmpty())throw new ProductException("Product not found");
            return productRepository.save(product);
        }else{
            throw new ProductException("No product id found");
        }

    }

    @Override
    public Product deleteProduct(Long productId) throws ProductException {
        Optional<Product> product=productRepository.findById(productId);
        if(product.isEmpty())throw new ProductException("Product not found with id: "+productId);
        Product p1=product.get();
        p1.setCategory(null);
        productRepository.delete(p1);
        return product.get();
    }

    @Override
    public Product getProductById(Long productId) throws ProductException {
        Optional<Product> product=productRepository.findById(productId);
        if(product.isEmpty())throw new ProductException("Product not found with id: "+productId);
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() throws ProductException {
        List<Product> list=productRepository.findAll();
        if(list.isEmpty())throw new ProductException("No product in the database");
        return list;
    }

    @Override
    public List<Product> getAllPagedProducts(Pageable pagable) throws ProductException {
        Page<Product> list = productRepository.findAll(pagable);
        List<Product> list1=list.stream().toList();
        if(list1.isEmpty())throw new ProductException("No product found");
        return list1;
    }
}
