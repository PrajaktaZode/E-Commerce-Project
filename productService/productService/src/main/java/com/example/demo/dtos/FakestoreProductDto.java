package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakestoreProductDto {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

}
