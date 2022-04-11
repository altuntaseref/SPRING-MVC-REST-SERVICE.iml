package com.example.mvcproject1.dataAccsess;


import com.example.mvcproject1.model.Prices;
import com.example.mvcproject1.model.dtos.ProductWithPriceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PricesDao extends JpaRepository<Prices,Integer> {

    List<Prices> findAllByDate1LessThanEqualAndDate2GreaterThanEqual(String Date1,String Date2);
    List<Prices> findByDate1Between(String startDate, String endDate);
    List<Prices> findByPrice1IsLessThanEqual(String price1);
    List<Prices> findByPrice1Between(String minPrice, String maxPrice);
    List<Prices> findByPrice1GreaterThanEqual(String price);


    @Query("SELECT new com.example.mvcproject1.model.dtos.ProductWithPriceDto" +
            "(pr.id,p.category,p.title, p.brand, pr.price1,pr.date1) FROM Product p Inner Join p.prices2 pr")
    List<ProductWithPriceDto> getProdcutWithCategoryDetails();

    @Query("SELECT new com.example.mvcproject1.model.dtos.ProductWithPriceDto" +
            "(pr.id,p.category,p.title, p.brand, pr.price1,pr.date1) FROM Product p Inner Join p.prices2 pr")
    List<ProductWithPriceDto> findByTitleAndPrice1AndDate1(String title,String price1,String date1);
}
