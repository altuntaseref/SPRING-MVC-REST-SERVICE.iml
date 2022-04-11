package com.example.mvcproject1.api;

import com.example.mvcproject1.business.abstracts.PriceService;
import com.example.mvcproject1.business.abstracts.ProductService;
import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.model.Prices;
import com.example.mvcproject1.model.Product;
import com.example.mvcproject1.model.dtos.ProductWithPriceDto;
import com.example.mvcproject1.services.abstacts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/filterController")
public class FilterController {

    private PriceService priceService;
    private ProductService productService;
    private GetPriceService getPriceService;
    private GetDateService getDateService;
    private GetBrandService getBrandService;
    private GetCategoryService getCategoryService;
    private GetUrlService getUrlService;
    @Autowired
    public FilterController(PriceService priceService, ProductService productService,
                            GetPriceService getPriceService, GetDateService getDateService,
                            GetBrandService getBrandService, GetCategoryService getCategoryService,
                            GetUrlService getUrlService) {
        this.priceService = priceService;
        this.productService = productService;
        this.getPriceService = getPriceService;
        this.getDateService = getDateService;
        this.getBrandService = getBrandService;
        this.getCategoryService = getCategoryService;
        this.getUrlService = getUrlService;}

        @GetMapping("/dateFilter")
        public DataResult<List<Prices>> getDateFilter
        (@RequestParam(required=false,name="startDate") String startDate,
                @RequestParam(required=false,name="endDate") String endDate){

            return this.getDateService.findByDate1Between(startDate, endDate);

        }

        @GetMapping("/priceFilterLessThan")
        public DataResult<List<Prices>> getPriceFilter
        (@RequestParam(required=false,name="price1") String price1){

            return this.getPriceService.findByPrice1IsLessThanEqual(price1);

        }
        @GetMapping("/priceFilterBetween")
        public DataResult<List<Prices>> findByPrice1Between
        (@RequestParam(required=false,name="minPrice") String minPrice,
                @RequestParam(required=false,name="maxPrice") String maxPrice){
            return this.getPriceService.findByPrice1Between(minPrice,maxPrice);
        }

        @GetMapping("/priceFilterGreaterThan")
        public DataResult<List<Prices>> findByPrice1GreaterThanEqual
        (@RequestParam(required=false,name="price") String price){
            return this.getPriceService.findByPrice1GreaterThanEqual(price);
        }


        @GetMapping("/brandFilter")
        public DataResult<List<Product>> get(@RequestParam(required=false,name="brand") String brand){
            return this.getBrandService.findByBrand(brand);
         }

        @GetMapping("/categoryFilter")
        public DataResult<List<Product>> findByCategory(@RequestParam(required=false,name="category") String category){
            return this.getCategoryService.findByCategory(category);
        }

        @GetMapping("/urlFilter")
        public DataResult<List<Product>> findByUrl(@RequestParam(required=false,name="url") String url){
            return this.getUrlService.findByUrl(url);
        }

        @GetMapping("/getProductWithPriceDetails")
        public DataResult<List<ProductWithPriceDto>> getProductWithPriceDetails(){

            return this.priceService.getProductWithPriceDetails();
        }


    @GetMapping("/findByTitleAndPrice1AndDate1")
     public DataResult<List<ProductWithPriceDto>> findByTitleAndPrice1AndDate1
             (@RequestParam(required=false,name="title") String title,
              @RequestParam(required=false,name="price1") String price1,
              @RequestParam(required=false,name="date1")String date1){
        return this.priceService.findByTitleAndPrice1AndDate1(title,price1,date1);

     }


}
