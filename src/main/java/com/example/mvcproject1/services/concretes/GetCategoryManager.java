package com.example.mvcproject1.services.concretes;

import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.core.utilities.results.SuccsessDataResult;
import com.example.mvcproject1.dataAccsess.ProductsDao;
import com.example.mvcproject1.model.Product;
import com.example.mvcproject1.services.abstacts.GetCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCategoryManager implements GetCategoryService {

    private ProductsDao productsDao;
    @Autowired
    public GetCategoryManager(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }


    @Override
    public DataResult<List<Product>> findByCategory(String category) {
        return new SuccsessDataResult<List<Product>>
                (this.productsDao.findByCategory(category),"Kategoriye göre listelendi") ;
    }
}
