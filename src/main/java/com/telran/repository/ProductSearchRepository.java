package com.telran.repository;

import com.telran.dto.ProductSearchDto;
import com.telran.entity.Product;

import java.util.List;

public interface ProductSearchRepository {

    List<Product> search(ProductSearchDto productSearchDto);
}
