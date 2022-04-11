package com.example.mvcproject1.api;

import com.example.mvcproject1.business.abstracts.PriceService;
import com.example.mvcproject1.core.service.StringTokenizerService;
import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.core.utilities.results.SuccsessResult;
import com.example.mvcproject1.model.Prices;
import com.example.mvcproject1.model.Product;
import com.example.mvcproject1.services.abstacts.GetDateService;
import com.example.mvcproject1.services.abstacts.GetPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/priceController")
public class PriceController {

    private PriceService priceService;
    private StringTokenizerService tokenizerService;
    private GetDateService getDateService;
    private GetPriceService getPriceService;


    @Autowired
    public PriceController(PriceService priceService, StringTokenizerService tokenizerService,
                           GetDateService getDateService,GetPriceService getPriceService) {
        this.priceService = priceService;
        this.tokenizerService = tokenizerService;
        this.getDateService=getDateService;
        this.getPriceService=getPriceService;
    }


    @GetMapping("/add")
    public SuccsessResult add() {
         //this.tokenizerService.separate();
        this.priceService.addAll();
        return new SuccsessResult("basarili");
    }


    @GetMapping("/getAll")
    public List<Prices> getAll() {

        return this.priceService.getAll();
    }


    @GetMapping("/dateFilter")
    public DataResult<List<Prices>> getDateFilter2
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


}