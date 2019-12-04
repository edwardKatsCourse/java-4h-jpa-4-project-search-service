package com.telran.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum ProductCategory {

    ELECTRONIC(1),
    CLOTHES(2),
    HOME_SUPPLIES(3)
    ;

    private Integer id;

    // Читабельная версия enum -> цифра

    //                                         12
    public static ProductCategory getById(Integer id) {
        if (id == null) {
            return null;
        }

//        for (ProductCategory category : ProductCategory.values()) {
//            //ELECTRONIC - 1
//            //CLOTHES - 2
//            //HOME_SUPPLIES - 3
//            if (category.getId().equals(id)) {
//                return category;
//            }
//        }
//        return null;

        return Arrays.stream(ProductCategory.values())
                .filter(x -> x.getId().equals(id))
                .findFirst() //я ожидаю тут только ОДИН результат
                .orElse(null);
    }
}
