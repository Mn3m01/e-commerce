package com.example.e_commerce.service.product;

import com.example.e_commerce.model.Product;
import com.example.e_commerce.request.AddProductRequest;

import java.util.List;

public interface IPruductService {
    Product addProduct(AddProductRequest product);
    void removeProductById(Long id);
    void updateProductById(Product product,Long productId);
    Product getProductById(Long id);
    List<Product> getProductByName(String name);
    List<Product> getAllProducts();
    List<Product> getAllProductsByCategoryName(String category);
    List<Product> getAllProductsByBrand(String brand);
    List<Product> getProductsByCategoryNameAndBrand(String category,String brand);
    List<Product> getProductsByBrandAndName(String brand,String name);
    Long countProductsByBrandAndName(String brand,String name);



}
