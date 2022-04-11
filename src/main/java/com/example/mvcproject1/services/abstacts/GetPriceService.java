package com.example.mvcproject1.services.abstacts;

import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.model.Prices;

import java.util.List;

public interface GetPriceService {

   DataResult<List<Prices>> findByPrice1IsLessThanEqual(String price1);
   DataResult<List<Prices>> findByPrice1Between(String minPrice, String maxPrice);
   DataResult<List<Prices>> findByPrice1GreaterThanEqual(String price);


}
