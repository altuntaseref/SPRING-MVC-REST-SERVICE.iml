package com.example.mvcproject1.business.concretes;

import com.example.mvcproject1.business.abstracts.PriceService;
import com.example.mvcproject1.core.service.ReadXmlFileService;
import com.example.mvcproject1.core.service.StringTokenizerService;
import com.example.mvcproject1.core.utilities.results.DataResult;
import com.example.mvcproject1.core.utilities.results.Result;
import com.example.mvcproject1.core.utilities.results.SuccsessDataResult;
import com.example.mvcproject1.core.utilities.results.SuccsessResult;
import com.example.mvcproject1.dataAccsess.PricesDao;
import com.example.mvcproject1.model.Prices;
import com.example.mvcproject1.model.dtos.ProductWithPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PriceManager implements PriceService {

    private PricesDao pricesDao;
    private ReadXmlFileService readXmlFileService;
    private StringTokenizerService stringTokenizerService;
    @Autowired
    public PriceManager(PricesDao pricesDao, ReadXmlFileService readXmlFileService,StringTokenizerService stringTokenizerService) {
        this.pricesDao = pricesDao;
        this.readXmlFileService = readXmlFileService;
        this.stringTokenizerService=stringTokenizerService;

    }

    @Override
    public Result add(Prices prices) {
        // List<Prices> pricesList = this.stringTokenizerService.separate();
        //new SuccsessDataResult<Prices>(this.pricesDao.save(pricesList),"msg");
        this.pricesDao.save(prices);





        return  new SuccsessResult("KAYIT YAPILDI");
    }

    @Override
    public List<Prices> getAll() {
        return this.pricesDao.findAll() ;
    }

    @Override
    public DataResult<List<Prices>> addAll() {

        List<String> pricesDateList = this.stringTokenizerService.separate(); //new ArrayList<>();

        List<Prices> priceList = new ArrayList<>();
        for(int i=0; i<pricesDateList.size();i+=6){
            Prices prices = new Prices();
            prices.setPrice1(pricesDateList.get(i));
            prices.setPrice2(pricesDateList.get(i+1));
            prices.setPrice3(pricesDateList.get(i+2));
            prices.setDate1(pricesDateList.get(i+3));
            prices.setDate2(pricesDateList.get(i+4));
            prices.setDate3(pricesDateList.get(i+5));
            priceList.add(prices);
        }



        for(int j=0;j<priceList.size();j++){

            this.pricesDao.save(priceList.get(j));

        }


        return null;
    }

    @Override
    public DataResult<List<ProductWithPriceDto>> getProductWithPriceDetails() {
        return new SuccsessDataResult<List<ProductWithPriceDto>>
                (this.pricesDao.getProdcutWithCategoryDetails(),"data listelendi");
    }

    @Override
    public DataResult<List<ProductWithPriceDto>> findByTitleAndPrice1AndDate1(String title, String price1, String date1) {
        return new SuccsessDataResult<List<ProductWithPriceDto>>(this.pricesDao.findByTitleAndPrice1AndDate1(title,price1,date1));
    }
}
