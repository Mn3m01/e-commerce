package com.example.e_commerce.request;

import com.example.e_commerce.model.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class AddProductRequest {
    private Long id;
    private String name;
    private String brand;
    private Double price;
    private Integer inventory;
    private String description;
    private Category category;

}
