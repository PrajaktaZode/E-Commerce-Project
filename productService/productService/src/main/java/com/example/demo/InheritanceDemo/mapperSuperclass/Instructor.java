package com.example.demo.InheritanceDemo.mapperSuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mps_it")
public class Instructor extends User{
    private String specialisation;
}
