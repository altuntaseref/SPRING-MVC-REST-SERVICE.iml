package com.example.mvcproject1.services.concretes;

import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.core.utilities.results.SuccsessDataResult;
import com.example.mvcproject1.dataAccsess.PricesDao;
import com.example.mvcproject1.model.Prices;
import com.example.mvcproject1.services.abstacts.GetPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPriceManager implements GetPriceService {

    private PricesDao pricesDao;
    @Autowired
    public GetPriceManager(PricesDao pricesDao) {
        this.pricesDao = pricesDao;
    }


    @Override
    public DataResult<List<Prices>> findByPrice1IsLessThanEqual(String price1) {
        return new SuccsessDataResult<List<Prices>>
                (this.pricesDao.findByPrice1IsLessThanEqual(price1),"Girilen değerden düşük olan fiyatlar listelendi.");
    }

    @Override
    public DataResult<List<Prices>> findByPrice1Between(String minPrice, String maxPrice) {
        return new SuccsessDataResult<List<Prices>>
                (this.pricesDao.findByPrice1Between(minPrice,maxPrice),"Min-max fiyatlar listelendi.");
    }

    @Override
    public DataResult<List<Prices>> findByPrice1GreaterThanEqual(String price) {
        return  new SuccsessDataResult<List<Prices>>
                (this.pricesDao.findByPrice1GreaterThanEqual(price),"Girilen değerden yüksek olan fiyatlar listelendi.");
    }
}
