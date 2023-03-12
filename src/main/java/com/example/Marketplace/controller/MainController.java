package com.example.Marketplace.controller;

import com.example.Marketplace.entity.Product;
import com.example.Marketplace.repository.ProductRepository;
import com.example.Marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller()
@RequestMapping("/main")
public class MainController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("product", productService.findAll());
        return "MainPage";
    }
}
