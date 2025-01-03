package com.example.demo.InheritanceDemo.mapperSuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mps_ta")
public class TA extends User {
    private int no_Session;
    private float avgRating;
}
