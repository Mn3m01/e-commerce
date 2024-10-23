package com.example.e_commerce.repository;

import com.example.e_commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByName(String name);

    List<Product> findByCategoryName(String categoryName);

    List<Product> findByBrand(String brand);

    List<Product> findByCategoryNameAndBrand(String categoryName, String brand);

    List<Product> findByBrandAndName(String brand, String name);

    Long countProductsByBrandAndName(String brand, String name);
}
