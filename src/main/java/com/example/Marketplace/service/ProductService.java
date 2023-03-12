package com.example.Marketplace.service;


import com.example.Marketplace.entity.Product;
import com.example.Marketplace.repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.productRepository.saveAll(List.of(
                new Product("a", "a", "aaaaaaaaa", 100, "s", "s", "Male", "a", 10),
                new Product("b", "b", "bbbbbbbbb", 200, "s", "b", "Female", "a", 0),
                new Product("a", "a", "aaaaaaaaa", 100, "s", "Children's clothing", "male", "a", 10)
        ));
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public List<Product> getWomensClothing(){
        List<Product> products = productRepository.findAll();
        return products.stream().
                filter(x -> x.getGender().
                equals("Female")).
                collect(Collectors.toList());
    }
    public List<Product> getMensClothing(){
        List<Product> products = productRepository.findAll();
        return products.stream().
                filter(x -> x.getGender().
                        equals("Male")).
                collect(Collectors.toList());
    }
    public List<Product> getChildrensClothing(){
        List<Product> products = productRepository.findAll();
        return products.stream().
                filter(x -> x.getStyle().
                        equals("Children's clothing")).
                collect(Collectors.toList());
    }
    public List<Product> getSaleProducts(){
        List<Product> products =productRepository.findAll();
        return products.stream().
                filter(x -> x.getSale()>0).
                collect(Collectors.toList());
    }
}
