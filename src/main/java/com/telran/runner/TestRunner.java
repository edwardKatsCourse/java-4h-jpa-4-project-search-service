package com.telran.runner;


import com.telran.entity.Product;
import com.telran.entity.ProductCategory;
import com.telran.entity.Test;
import com.telran.repository.ProductRepository;
import com.telran.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Test test = Test.builder()
        .namama("abc")
        .build();

        testRepository.save(test);

        List<Product> products = Arrays.asList(
                Product.builder()
                .productCategory(ProductCategory.ELECTRONIC)
                .productName("Headphones")
                .price(100.00)
                .build(),

                Product.builder()
                .productCategory(ProductCategory.HOME_SUPPLIES)
                .productName("Hot Pot")
                .price(20.)
                .build(),

                Product.builder()
                .productCategory(ProductCategory.CLOTHES)
                .productName("Men Jeans")
                .price(50.00)
                .build(),

                Product.builder()
                .productCategory(ProductCategory.CLOTHES)
                .productName("Women Jeans")
                .price(50.0)
                .build()
                );

        productRepository.saveAll(products);
    }
}
