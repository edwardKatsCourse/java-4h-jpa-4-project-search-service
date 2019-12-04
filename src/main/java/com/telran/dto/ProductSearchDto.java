package com.telran.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSearchDto {

    private String productName;
    private Double priceMin;
    private Double priceMax;
    private String category;
    private LocalDate createdFrom;
    private LocalDate createdTo;
}
