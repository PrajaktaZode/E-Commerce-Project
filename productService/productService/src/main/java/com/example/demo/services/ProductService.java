package com.example.demo.services;

import com.example.demo.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

public interface ProductService {
    Product getProductbyId(Long id);
    List<Product> getAllProducts();
   // Product updateProduct(Long id,Product product);
    Product createProduct(Product product);




}
