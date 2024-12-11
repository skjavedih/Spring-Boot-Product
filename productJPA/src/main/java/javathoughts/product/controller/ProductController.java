package javathoughts.product.controller;

import javathoughts.product.exception.ProductNotFoundException;
import javathoughts.product.model.Product;
import javathoughts.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }
    @GetMapping("/products/{Id}")
    public Product getProduct(@PathVariable("Id") Long id){
        return productService.getProduct(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }
    @PutMapping("/products/{Id}")
    public void updateProduct(@PathVariable("Id") Long id, @RequestBody Product product){
        productService.updateProduct(id, product);
    }
    @DeleteMapping("/products/{Id}")
    public void deleteProduct(@PathVariable("Id") Long id){
        productService.deleteProduct(id);
    }
}
