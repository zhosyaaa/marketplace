package com.example.Marketplace.repository;

import com.example.Marketplace.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
  //  Optional<Product> findWomensClothing();
}
