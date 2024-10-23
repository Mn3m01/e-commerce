package com.example.e_commerce.service.product;

import com.example.e_commerce.model.Category;
import com.example.e_commerce.model.Product;
import com.example.e_commerce.repository.CategoryRepository;
import com.example.e_commerce.repository.ProductRepository;
import com.example.e_commerce.request.AddProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PruductService implements IPruductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public Product addProduct(AddProductRequest request) {
      Category category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName())).
              orElseGet(() ->{
                  Category newCategory = new Category(request.getCategory().getName());
                  return  categoryRepository.save(newCategory);});
      request.setCategory(category);
      return productRepository.save(createProduct(request,category));
    }

    private Product createProduct(AddProductRequest request,Category category) {
        return new Product(
                request.getName(),
                request.getBrand(),
                request.getPrice(),
                request.getInventory(),
                request.getDescription(),
                category
        );
    }


    @Override
    public void removeProductById(Long id) {
    productRepository.findById(id).ifPresentOrElse
            (productRepository::delete,()-> new  IllegalStateException("Product Not Found"));
    }

    @Override
    public void updateProductById(Product product, Long productId) {
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new IllegalStateException("Product not found"));
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsByCategoryName(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    @Override
    public List<Product> getAllProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByCategoryNameAndBrand(String categoryName, String brand) {
        return productRepository.findByCategoryNameAndBrand(categoryName, brand);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand,name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return productRepository.countProductsByBrandAndName(brand, name);
    }
}
