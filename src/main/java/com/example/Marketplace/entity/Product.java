package com.example.Marketplace.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title" , nullable = false)
    private String title;
    @Column(name = "color" , nullable = false)
    private String color;
    @Column(name = "description" , nullable = false)
    private String description;
    @Column(name = "price" , nullable = false)
    private double price;
    @Column(name = "sizes" , nullable = false)
    private String sizes;
    @Column(name = "style" , nullable = false)
    private String style;
    @Column(name = "gender" , nullable = false)
    private String gender;
    @Column(name = "composition" , nullable = false)
    private String composition;
    @Column(name = "sale")
    private double sale;

    public Product(String title, String color, String description, double price, String sizes, String style, String gender, String composition, double sale) {
        this.title = title;
        this.color = color;
        this.description = description;
        this.price = price;
        this.sizes = sizes;
        this.style = style;
        this.gender = gender;
        this.composition = composition;
        this.sale = sale;
    }
}
