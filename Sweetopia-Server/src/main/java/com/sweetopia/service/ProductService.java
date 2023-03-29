package com.sweetopia.service;

import com.sweetopia.entity.Product;
import com.sweetopia.exception.ProductException;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product) throws ProductException;
    public Product updateProduct(Product product)throws ProductException;
    public Product deleteProduct(Long productId)throws ProductException;
    public Product getProductById(Long productId)throws ProductException;
    public List<Product> getAllProducts()throws ProductException;
}
