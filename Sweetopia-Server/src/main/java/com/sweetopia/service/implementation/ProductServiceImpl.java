package com.sweetopia.service.implementation;

import com.sweetopia.entity.Product;
import com.sweetopia.repository.ProductRepository;
import com.sweetopia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }

    @Override
    public Product getProductById(Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
