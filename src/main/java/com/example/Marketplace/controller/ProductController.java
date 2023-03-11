package com.example.Marketplace.controller;

import com.example.Marketplace.entity.Product;
import com.example.Marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "NewProduct";
    }
    @PostMapping("/add")
    public Iterable<Product> addProduct(@RequestBody Product product){
        return productService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }


    @GetMapping("/womensC")
    public List<Product> getWomensClothing(Model model){
        return productService.getWomensClothing();
    }
    @GetMapping("/mensC")
    public Iterable<Product> getMensClothing(Model model){
        return productService.getMensClothing();
    }
    @GetMapping("/childresC")
    public Iterable<Product> getChildrensClothing(Model model){
        return productService.getChildrensClothing();
    }

    @GetMapping("/sale")
    public List<Product> getSaleProducts(){
        return productService.getSaleProducts();
    }
//    @PostMapping("/search")
//    public List<Product> search(@RequestBody Product product){
//
//        return
//    }
    @GetMapping("/search")
    public String search(Model model){
        model.addAttribute("product", new Product());
        return "";
    }
}
