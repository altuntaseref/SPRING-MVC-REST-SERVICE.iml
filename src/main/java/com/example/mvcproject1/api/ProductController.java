package com.example.mvcproject1.api;

import com.example.mvcproject1.business.abstracts.ProductService;

import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.core.utilities.results.SuccsessDataResult;
import com.example.mvcproject1.model.Product;
import com.example.mvcproject1.services.abstacts.GetBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class ProductController {



    private ProductService productService;
    private GetBrandService getBrandService;

    @Autowired
    public ProductController(ProductService productService,GetBrandService getBrandService) {
       this.productService = productService;
       this.getBrandService=getBrandService;
    }




    @GetMapping("/add")
    public DataResult<List<Product>> add(){

        return new SuccsessDataResult<List<Product>>(this.productService.addAll(),"Data kaydedildi");

    }


    @GetMapping("/getByCategory")
    public DataResult<List<Product>>  findByCategory(@RequestParam(required=false,name="category") String category){

        return this.productService.findByCategory(category);

    }
    @GetMapping("/products")
    public List<Product> products(){

        return this.productService.getAll();

    }

    @GetMapping("/get")
    public DataResult<List<Product>> get(@RequestParam(required=false,name="brand") String brand){
       return this.getBrandService.findByBrand(brand);
    }



}
