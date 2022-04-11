package com.example.mvcproject1.dataAccsess;

import com.example.mvcproject1.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsDao extends JpaRepository<Product,Integer> {

    List<Product> findByBrand(String brand);
    List<Product> findByUrl(String url);
    List<Product> findByCategory(String category);
}
