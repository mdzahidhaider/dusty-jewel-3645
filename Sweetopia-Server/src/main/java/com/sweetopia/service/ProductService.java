package com.sweetopia.service;

import com.sweetopia.entity.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(Long productId);
    public Product getProductById(Long productId);
    public List<Product> getAllProducts();
}
