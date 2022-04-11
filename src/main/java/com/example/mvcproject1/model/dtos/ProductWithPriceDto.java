package com.example.mvcproject1.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithPriceDto {

    private int id;
    private String category;
    private String title;
    private String brand;
    private String price1;
    private String date1;

}
