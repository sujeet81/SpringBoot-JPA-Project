package com.springboot_project.Repository;

import com.springboot_project.Entity.Product;
import org.hibernate.mapping.Selectable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);


    Product findByProductType(String productType);


    List<Product> findByPriceAndProductType(double price, String productType);

  //  @Query(value = "Select * from Product where price = ?1",nativeQuery = true)// native Query
    //@Query("from Product p where p.price = price")
    @Query("from Product p where p.price = ?1")  //jpQuery
    List<Product> getProductByPrice(double price);


    //prefix + field + Operator
    List<Product> findByPriceIn(List<Double> prices);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findByPriceGreaterThan(double prices);

    List<Product> findByPriceLessThan(double prices);


    List<Product> findByNameIgnoreCaseContaining(String name);
}
