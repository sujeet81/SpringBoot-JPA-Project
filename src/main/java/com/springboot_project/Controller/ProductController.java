package com.springboot_project.Controller;

import com.springboot_project.Entity.Product;
import com.springboot_project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @GetMapping
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @GetMapping("/name/{name}")
    public  Product getProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @GetMapping("/type/{productType}")
    public Product getProductByType(@PathVariable String productType){
        return service.getProductByType(productType);
    }

    @GetMapping("/price/{price}/type/{productType}")
    public List<Product> getProductWihPriceAndType(@PathVariable double price,@PathVariable String productType){
        return service.getProductWihPriceAndType(price,productType);
    }

    @GetMapping("/price/{price}")
    public List<Product> getProductByPrice(@PathVariable double price){
        return service.getProductByPrice(price);
    }

    @PutMapping("/{id}")
    public Product updateProduct( @PathVariable int id, @RequestBody Product productRequest){
        return service.updateProduct(id,productRequest);
    }

    @DeleteMapping("/{id}")
    public long deleteProduct(@PathVariable int id){

        return service.deleteProduct(id);
    }

    //Operator
    @PostMapping("/search")
    public List<Product> getProductsByMultiplePriceValue(@RequestBody List<Double> prices) {
        return service.getProductsByMultiplePriceValue(prices);
    }

    @GetMapping("/min/{minPrice}/max/{maxPrice}")
    public List<Product> getProductsWithinPriceRange( @PathVariable double minPrice, @PathVariable double maxPrice){
        return service.getProductsWithinPriceRange(minPrice,maxPrice);
    }

   @GetMapping("/high/{prices}")
    public List<Product> getProductsWithHigherPrice(@PathVariable double prices){
        return service.getProductsWithHigherPrice(prices);
    }

    @GetMapping("/less/{prices}")
    public List<Product> getProductWithLessPrice(@PathVariable double prices){
        return service.getProductWithLessPrice(prices);
    }

    @GetMapping("/like/{name}")
    public List<Product> getProductsWithLike(@PathVariable String name){
        return service.getProductsWithLike(name);
    }

    //Sorting
    @GetMapping("/sort/{fieldName}")
    public List<Product> getProductsWithSorting(@PathVariable String fieldName){
        return service.getProductsWithSorting(fieldName);
    }

    //Paginations
    @GetMapping("/page/{offset}/{limit}")
    public Page<Product> getProductsWithPageResponse(@PathVariable int offset, @PathVariable int limit){
        return service.getProductsWithPageResponse(offset,limit);
    }

    // Sorting And Paginations
    @GetMapping("/pageAndSorting/{fieldName}/{offset}/{limit}")

    public Page<Product> getProductsWithSortingAndPaginations(@PathVariable String fieldName,@PathVariable int offset, @PathVariable int limit){
        return service.getProductsWithSortingAndPaginations(fieldName,offset,limit);
    }
}
