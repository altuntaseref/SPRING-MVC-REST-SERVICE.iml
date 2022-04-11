package com.example.mvcproject1.business.abstracts;

import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.core.utilities.results.Result;
import com.example.mvcproject1.model.Prices;
import com.example.mvcproject1.model.dtos.ProductWithPriceDto;

import java.util.List;

public interface PriceService {

    Result add(Prices prices);
    List<Prices> getAll();
    DataResult<List<Prices>> addAll();
    DataResult<List<ProductWithPriceDto>> getProductWithPriceDetails();
    DataResult<List<ProductWithPriceDto>> findByTitleAndPrice1AndDate1(String title,String price1,String date1);


   // Prices add(Prices prices);
}
