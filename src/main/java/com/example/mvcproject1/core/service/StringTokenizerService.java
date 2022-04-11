package com.example.mvcproject1.core.service;

import com.example.mvcproject1.dataAccsess.PricesDao;
import com.example.mvcproject1.model.Prices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class StringTokenizerService {

    private ReadXmlFileService readXmlFileService;
   // private PriceService priceService;
    private PricesDao pricesDao;

    @Autowired
    public StringTokenizerService(ReadXmlFileService readXmlFileService, PricesDao pricesDao) {
        this.readXmlFileService = readXmlFileService;
       // this.priceService=priceService;
        this.pricesDao=pricesDao;
    }


    public List<String> separate() {

        List<Prices> pricesList =new ArrayList<>();
        Prices pricess = new Prices();
        ArrayList<String> prices = new ArrayList<String>();
        //ArrayList<String> pricesOut =new ArrayList<String>();
        for (int j = 0; j < 10; j++) {


            String priceXml = this.readXmlFileService.xmlReader().getProduct().get(j).getPrices();
            StringTokenizer tokenizer = new StringTokenizer(priceXml, ",");

            while (tokenizer.hasMoreTokens()) {

                prices.add(tokenizer.nextToken());

            }

            String datesXml = this.readXmlFileService.xmlReader().getProduct().get(j).getDates();
            StringTokenizer tokenizer2 = new StringTokenizer(datesXml, ",");

            while (tokenizer2.hasMoreTokens()) {

                prices.add(tokenizer2.nextToken());

            }
        }
        System.out.println(prices);
/*
            for (int i = 0; i < prices.size(); i += 6) {
                    pricess.setPrice1(prices.get(i));
                    pricess.setPrice2(prices.get(i + 1));
                    pricess.setPrice3(prices.get(i + 2));
                    pricess.setDate1(prices.get (i + 3));
                    pricess.setDate2(prices.get (i + 4));
                    pricess.setDate3(prices.get (i + 5));
                    pricesList.add(pricess);
                    //System.out.println(pricesList);
            }

        System.out.println(pricesList);
*/

        return prices;
    }
}
