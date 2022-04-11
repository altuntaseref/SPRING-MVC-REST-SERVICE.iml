package com.example.mvcproject1.services.concretes;

import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.core.utilities.results.SuccsessDataResult;
import com.example.mvcproject1.dataAccsess.PricesDao;
import com.example.mvcproject1.model.Prices;
import com.example.mvcproject1.services.abstacts.GetDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GetDateManager implements GetDateService {

    private PricesDao pricesDao;
    @Autowired
    public GetDateManager(PricesDao pricesDao) {
        this.pricesDao = pricesDao;
    }


    @Override
    public DataResult<List<Prices>> findAllByDate1LessThanEqualAndDate2GreaterThanEqual(String Date1, String Date2) {
        return new SuccsessDataResult<List<Prices>>
                (this.pricesDao.findAllByDate1LessThanEqualAndDate2GreaterThanEqual(Date1,Date2)
                ,"Data Listelendi");
    }

    @Override
    public DataResult<List<Prices>> findByDate1Between(String startDate, String endDate) {
        return new SuccsessDataResult<List<Prices>>
                (this.pricesDao.findByDate1Between(startDate,endDate)
                        ,"Data Listelendi");
    }
}
