package com.example.mvcproject1.services.abstacts;

import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.model.Product;

import java.util.List;

public interface GetCategoryService {

    DataResult<List<Product>> findByCategory(String category);

}
