package com.example.mvcproject1.services.abstacts;

import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.model.Product;

import java.util.List;

public interface GetBrandService {

    DataResult<List<Product>> findByBrand(String brand);

}
