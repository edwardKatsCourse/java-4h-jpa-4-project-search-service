package com.telran.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ProductCategoryConverter implements AttributeConverter<ProductCategory, Integer> {

    //product_category = null
    @Override
    public Integer convertToDatabaseColumn(ProductCategory productCategory) {
        return productCategory == null ? null : productCategory.getId();
    }

    @Override
    public ProductCategory convertToEntityAttribute(Integer integer) {
        return integer == null ? null : ProductCategory.getById(integer);
    }
}
