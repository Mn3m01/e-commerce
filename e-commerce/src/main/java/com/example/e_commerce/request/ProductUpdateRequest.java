package com.example.e_commerce.request;

import com.example.e_commerce.model.Category;
import lombok.Data;

@Data
public class ProductUpdateRequest {
    private Long id;
    private String name;
    private String brand;
    private Double price;
    private Integer inventory;
    private String description;
    private Category category;
}
