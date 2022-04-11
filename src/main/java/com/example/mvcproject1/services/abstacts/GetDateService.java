package com.example.mvcproject1.services.abstacts;

import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.model.Prices;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface GetDateService {

    DataResult<List<Prices>> findAllByDate1LessThanEqualAndDate2GreaterThanEqual(String Date1,String Date2);
    DataResult<List<Prices>> findByDate1Between(String startDate, String endDate);



}
