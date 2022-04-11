package com.example.mvcproject1.services.concretes;

import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.core.utilities.results.SuccsessDataResult;
import com.example.mvcproject1.dataAccsess.ProductsDao;
import com.example.mvcproject1.model.Product;
import com.example.mvcproject1.services.abstacts.GetBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBrandManager implements GetBrandService {

    private ProductsDao productsDao;
    @Autowired
    public GetBrandManager(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    @Override
    public DataResult<List<Product>> findByBrand(String brand) {

        return new SuccsessDataResult<List<Product>>
                (this.productsDao.findByBrand(brand),"Data listelendi");

    }
}
