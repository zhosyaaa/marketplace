package com.example.Marketplace.controller;

import com.example.Marketplace.entity.Product;
import com.example.Marketplace.repository.ProductRepository;
import com.example.Marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/main")
public class MainController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public String mainPage(Model model) {
        Iterable<Product> products = productService.getProductRepository().findAll();
        model.addAttribute("products", products);
        return "MainPage";
    }
}
