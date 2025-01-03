package com.example.demo.services;

import com.example.demo.dtos.FakestoreProductDto;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class FakeProductService implements ProductService {
    private RestTemplate restTemplate;

    FakeProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductbyId(Long id) {
        FakestoreProductDto fakestoreProductDto
                = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakestoreProductDto.class);
        return convertToProduct(fakestoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        //Get the products from 3rd party
        FakestoreProductDto[] fakestoreProductDtoList =
                restTemplate.getForObject("https://fakestoreapi.com/products", FakestoreProductDto[].class);
        //convert result
        List<Product> products = new ArrayList<>();
        for (FakestoreProductDto fakestoreProductDto: fakestoreProductDtoList){
            products.add(convertToProduct(fakestoreProductDto));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    /*@Override
    public Product updateProduct(Long id,Product product) {
        FakestoreProductDto fakestoreProductDto = convertProductToDTO(product);
        fakestoreProductDto = restTemplate.patchForObject("https://fakestoreapi.com/products/"+ id,
                fakestoreProductDto, FakestoreProductDto.class);
        return convertToProduct(fakestoreProductDto);
    }*/

    /*private FakestoreProductDto convertProductToDTO(Product product) {
    }*/

    private Product convertToProduct(FakestoreProductDto dto) {
        if (dto == null) {
            return null;
        }

        // Create and populate the Category object
        Category category = new Category();
        category.setId(0L); // Set the id for the Category (assuming categoryId is passed to the function)
        category.setTitle(dto.getCategory());

        // Create and populate the Product object
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setCategory(category);
        product.setDescription(dto.getDescription());

        return product;
    }

    /*public FakestoreProductDto convertProductToDTO(Product product) {
        if (product == null) {
            return null;
        }

        FakestoreProductDto fakestoreProductDto = new FakestoreProductDto();
        fakestoreProductDto.setId(product.getId());
        fakestoreProductDto.setTitle(product.getTitle());
        fakestoreProductDto.setDescription(product.getDescription());
        fakestoreProductDto.setPrice(product.getPrice());
        fakestoreProductDto.setCategory(product.getCategory() != null ? product.getCategory().getName() : null);

        return fakestoreProductDto;
    }*/
}
