package com.telran.repository;

import com.telran.dto.ProductSearchDto;
import com.telran.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductSearchRepositoryImpl implements ProductSearchRepository {

    //SQL                                   JPQL
    //                                      Java Persistence Query language
    //Table                                 Entity
    //select ID from table                  select e.id from Entity e

    @Autowired
    private EntityManager entityManager;



    @Override
    public List<Product> search(ProductSearchDto productSearchDto) {

        StringBuilder query = new StringBuilder();
        query.append("select p from Product p where 1 = 1 ");

        Map<String, Object> parameters = new HashMap<>();

        if (productSearchDto.getProductName() != null) {
            query.append(" and p.productName like :productName ");
            parameters.put("productName", "%" + productSearchDto.getProductName() + "%");
        }


        if (productSearchDto.getPriceMin() != null ) {
            query.append(" and p.price >= :priceMin ");
            parameters.put("priceMin", productSearchDto.getPriceMin());
        }

        if (productSearchDto.getPriceMax() != null) {
            query.append(" and p.price <= :priceMax ");
            parameters.put("priceMax", productSearchDto.getPriceMax());
        }

        TypedQuery<Product> jpqlQuery = entityManager.createQuery(query.toString(), Product.class);

        parameters.entrySet()
                .forEach(x -> jpqlQuery.setParameter(x.getKey(), x.getValue()));

        System.out.println(query.toString());
        return jpqlQuery
                .getResultList(); //List list
    }
}
