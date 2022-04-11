package com.example.mvcproject1.business.concretes;

import com.example.mvcproject1.business.abstracts.ProductService;
import com.example.mvcproject1.core.service.ReadXmlFileService;
import com.example.mvcproject1.core.service.StringTokenizerService;
import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.core.utilities.results.SuccsessDataResult;
import com.example.mvcproject1.dataAccsess.ProductsDao;
import com.example.mvcproject1.model.Prices;
import com.example.mvcproject1.services.abstacts.GetBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mvcproject1.model.Product;
import java.util.List;
@Service
public class ProductManager  implements ProductService {

    private ProductsDao productsDao;
    private ReadXmlFileService readXmlFileService;
    private StringTokenizerService stringTokenizerService;
    private GetBrandService getBrandService;
    @Autowired
    public ProductManager(ProductsDao productsDao, StringTokenizerService stringTokenizerService, ReadXmlFileService readXmlFileService, GetBrandService getBrandService) {
        this.productsDao = productsDao;
        this.stringTokenizerService = stringTokenizerService;
        this.readXmlFileService = readXmlFileService;
        this.getBrandService=getBrandService;
    }

    @Override
    public List<Product> addAll() {

      List<Product> productList =this.readXmlFileService.xmlReader().getProduct();

        for(int i = 0; i< productList.size(); i++)
        {

            this.productsDao.save(productList.get(i));

          }

       return null;
    }



    @Override
    public DataResult<List<Product> > findByCategory(String category) {


        return new SuccsessDataResult<List<Product>>(this.productsDao.findByCategory(category),"Data Listelendi");
    }

    @Override
    public List<Prices> add() {


        return null;
    }

    @Override
    public void get(String brand) {
        this.getBrandService.findByBrand( brand);
    }

    @Override
    public List<Product> getAll() {

        return this.productsDao.findAll();
    }


}
