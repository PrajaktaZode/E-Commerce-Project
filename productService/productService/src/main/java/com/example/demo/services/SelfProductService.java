package com.example.demo.services;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepo;
import com.example.demo.repositories.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class SelfProductService implements ProductService {
    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductbyId(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }


    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId() == null){
            Category savedCategory = categoryRepo.save(category);
            product.setCategory(savedCategory);
        }
        // if we had title
        // categoryRepo.findByTitle(product.getCategory().getTitle())

        Product savedProduct = productRepo.save(product);

        return savedProduct;
    }
}
