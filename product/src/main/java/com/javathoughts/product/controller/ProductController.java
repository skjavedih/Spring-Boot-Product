package com.javathoughts.product.controller;

import com.javathoughts.product.model.Product;
import com.javathoughts.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }
    @GetMapping("/products/{Id}")
    public Product getProduct(@PathVariable("Id") String id){
        return productService.getProduct(id);
    }
    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }
    @PostMapping("/products/{Id}")
    public void updateProduct(@PathVariable("Id") String id, @RequestBody Product product){
        productService.updateProduct(id, product);
    }
    @DeleteMapping("/products/{Id}")
    public void deleteProduct(@PathVariable("Id") String id){
        productService.deleteProduct(id);
    }
}
