package com.example.firestore.Sample_CRUD_firestore.controller;

import com.example.firestore.Sample_CRUD_firestore.entity.Product;
import com.example.firestore.Sample_CRUD_firestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public String save(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return productService.productSave(product);
    }

    @GetMapping("/products/{name}")
    public Product get(@PathVariable String name) throws ExecutionException, InterruptedException {
        return productService.getProduct(name);
    }

    @PutMapping("/products")
    public String update(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return productService.productUpdate(product);
    }

    @DeleteMapping("/products/{name}")
    public String delete(@PathVariable String name) throws ExecutionException, InterruptedException {
        return productService.productDelete(name);
    }
}
