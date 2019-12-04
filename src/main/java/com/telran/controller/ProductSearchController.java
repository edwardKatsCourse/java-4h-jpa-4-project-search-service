package com.telran.controller;

import com.telran.dto.ProductDto;
import com.telran.dto.ProductSearchDto;
import com.telran.repository.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductSearchController {

    //product name
    //price min - price max
    //category...
    //new products

    //GET - спрашиваем
    //POST - сохраняем/создаем
    //PUT - обновляем
    //DELETE - удаляем

    @Autowired
    private ProductSearchRepository productSearchRepository;

    @PostMapping("/search")
    public List<ProductDto> searchProducts(@RequestBody ProductSearchDto productSearchDto) {
        return productSearchRepository.search(productSearchDto) //List<Product>
                .stream()
                .map(x -> ProductDto.builder()
                        .createdDate(x.getCreatedDate().toLocalDate())
                        .price(x.getPrice())
                        .productName(x.getProductName())
                        .id(x.getId())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
