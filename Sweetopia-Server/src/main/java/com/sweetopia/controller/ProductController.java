package com.sweetopia.controller;

import com.sweetopia.entity.Product;
import com.sweetopia.exception.ProductException;
import com.sweetopia.repository.ProductRepository;
import com.sweetopia.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Product addProduct(@Valid @RequestBody Product product) throws ProductException {
        Product p1=productService.addProduct(product);
        return p1;
    }

}
