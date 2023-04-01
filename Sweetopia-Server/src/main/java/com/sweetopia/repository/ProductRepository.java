package com.sweetopia.repository;

import com.sweetopia.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAll(Pageable pageable);

    @Query("Select p from Product p where p.category.categoryId=?1")
    public List<Product> findByCategoryId(Long categoryId);


    public List<Product> findByNameLike(String productName);
}
