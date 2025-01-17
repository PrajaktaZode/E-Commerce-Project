package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    //private long id;
    private String title;
    private double price;
    @ManyToOne
    @JoinColumn
    private Category category;
    private String description;

}
