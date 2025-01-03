package com.example.demo.repositories;

import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// extends - To make aware that it is a JPA Repo
public interface ProductRepo extends JpaRepository<Product,Long> {

    // When we try to find product by id, it can return null. It we do some operation with null, it can throw null pointer exception.
    // Optional enforces a compile time check. It will check if product is not null, then only do the operation.
    Optional<Product> findById (Long id);

    Product save(Product product); //create+update

    void delete (Product product);
}
