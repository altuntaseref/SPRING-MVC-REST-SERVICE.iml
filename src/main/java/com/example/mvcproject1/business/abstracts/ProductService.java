package com.example.mvcproject1.business.abstracts;

import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.model.Prices;
import com.example.mvcproject1.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> addAll();

    DataResult<List<Product>> findByCategory(String category);

    List<Prices> add();

    List<Product> getAll();

    void get(String brand);
}
