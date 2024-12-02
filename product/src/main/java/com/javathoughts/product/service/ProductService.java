package com.javathoughts.product.service;

import com.javathoughts.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>(Arrays.asList(new Product("P01", "CPU", "Electronics"),
            new Product("P02", "Book", "School"),
            new Product("P03", "Table", "Household"),
            new Product("P04", "T-Shirt", "Cloths"),
            new Product("P05", "Mobile", "Electronics")));

    public List<Product> getAllProducts(){
        return products;
    }
    public Product getProduct(String id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public void updateProduct(String id, Product product){
        for(int i = 0; i < products.size(); i++){
            Product p = products.get(i);
            if(p.getId().equals(id)){
                products.set(i, product);
                return;
            }
        }
    }

    public void deleteProduct(String id){
        products.removeIf(p -> p.getId().equals(id));
    }
}
