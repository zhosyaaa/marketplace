package com.example.Marketplace.controller;

import com.example.Marketplace.entity.Product;
import com.example.Marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "NewProduct";
    }
    @PostMapping("/newProduct")
    public String addProduct(@RequestBody Product product, Model model){
//        model.addAttribute("product", new Product());
        productService.getProductRepository().save(product);
        return "redirect:/main";
    }
    @GetMapping("/{id}")
    public String getProductById(@PathVariable long id){
        return "";
    }
//
//    public String WomensClothing(Model model){
//        Iterable<Product> products = productService.get().findAll();
//        return "WomensClothing";
//    }
}
