package com.example.Marketplace.controller;

import com.example.Marketplace.entity.Product;
import com.example.Marketplace.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
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
    public String addProduct(@RequestBody Product product){
        productService.getProductRepository().save(product);
        return "redirect:/MainPage";
    }
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }


    @GetMapping("/womensC")
    public String getWomensClothing(Model model){
        model.addAttribute("product", productService.getWomensClothing());
        model.addAttribute("title", "Women's clothing");
        return "Category";
    }
    @GetMapping("/mensC")
    public String getMensClothing(Model model){
        model.addAttribute("product", productService.getMensClothing());
        model.addAttribute("title", "Men's clothing");
        return "Category";
    }
    @GetMapping("/childresC")
    public String getChildrensClothing(Model model){
        model.addAttribute("product", productService.getChildrensClothing());
        model.addAttribute("title", "Children's clothing");
        return "Category";
    }

    @GetMapping("/sale")
    public String getSaleProducts(Model model){
        model.addAttribute("product", productService.getWomensClothing());
        model.addAttribute("title", "Sale%");
        return "Category";
    }
//    @PostMapping("/search")
//    public List<Product> search(@RequestBody Product product){
//
//        return
//    }
//    @GetMapping("/search")
//    public String search(Model model){
//        model.addAttribute("product", new Product());
//        return "";
//    }
}
