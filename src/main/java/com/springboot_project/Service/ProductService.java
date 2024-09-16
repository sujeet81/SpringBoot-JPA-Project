package com.springboot_project.Service;

import com.springboot_project.Entity.Product;
import com.springboot_project.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).get();
    }
    public  Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public Product getProductByType(String productType){
        return productRepository.findByProductType(productType);
    }

    public List<Product> getProductWihPriceAndType(double price, String productType){
        return productRepository.findByPriceAndProductType(price,productType);
    }

    public List<Product> getProductByPrice(double price){
        return productRepository.getProductByPrice(price);
    }

    public Product updateProduct(int id , Product productRequest){
      Product existingProduct  =  productRepository.findById(id).get();
      existingProduct.setName(productRequest.getName());
      existingProduct.setPrice(productRequest.getPrice());
      existingProduct.setDescription(productRequest.getDescription());
      existingProduct.setProductType(productRequest.getProductType());
      return productRepository.save(existingProduct);
    }

    public long deleteProduct(int id){
        productRepository.deleteById(id);
        return productRepository.count();
    }

    public List<Product> getProductsByMultiplePriceValue(List<Double> prices) {
        return productRepository.findByPriceIn(prices);
    }

    public List<Product> getProductsWithinPriceRange(double minPrice, double maxPrice){
        return productRepository.findByPriceBetween(minPrice,maxPrice);
    }

    public List<Product> getProductsWithHigherPrice(double prices){
        return productRepository.findByPriceGreaterThan(prices);
    }

    public List<Product> getProductWithLessPrice(double prices){
        return productRepository.findByPriceLessThan(prices);
    }

    public List<Product> getProductsWithLike(String name){
        return productRepository.findByNameIgnoreCaseContaining(name);
    }

    //Sorting
    public List<Product> getProductsWithSorting(String fieldName){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,fieldName));
    }

    //Paginations
    public Page<Product> getProductsWithPageResponse(int offset, int limit){
        return productRepository.findAll(PageRequest.of(offset,limit));
    }

    // Sorting And Paginations
    public Page<Product> getProductsWithSortingAndPaginations(String fieldName,int offset, int limit){
        return productRepository.findAll(PageRequest.of(offset,limit).withSort(Sort.by(fieldName)));
    }
}
