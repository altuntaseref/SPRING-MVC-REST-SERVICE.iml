package com.example.mvcproject1.services.concretes;

import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.core.utilities.results.SuccsessDataResult;
import com.example.mvcproject1.dataAccsess.ProductsDao;
import com.example.mvcproject1.model.Product;
import com.example.mvcproject1.services.abstacts.GetUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUrlManager implements GetUrlService {

    private  ProductsDao productsDao;
    @Autowired
    public GetUrlManager(com.example.mvcproject1.dataAccsess.ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    @Override
    public DataResult<List<Product>> findByUrl(String url) {
        return new SuccsessDataResult<List<Product>>(this.productsDao.findByUrl(url));
    }
}
