package com.example.demo.repositories;

import com.example.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//To make aware that it is a JPARepo, implement it.
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
