package javathoughts.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javathoughts.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductWebController {

    @Autowired
    ProductController productController;
    @GetMapping("/")
    public String getAllProducts(Model model){
        List<Product> prodcutList = productController.getAllProduct();
        model.addAttribute("products", prodcutList);
        return "list_products";
    }
    @GetMapping("/new_product")
    public String addProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }
    @PostMapping(value="/save_new")
    public String saveNewProduct(@ModelAttribute("product") Product product){
        productController.addProduct(product);
        return "redirect:/";
    }
    @GetMapping("/update_product/{Id}")
    public String editForm(@PathVariable(name="Id") Long id, Model model){
        model.addAttribute("product", productController.getProduct(id));
        return "update_product";
    }
    @PostMapping(value="/save_update")
    public String saveUpdateProduct(@ModelAttribute("product") Product product){
        productController.updateProduct(product.getId(), product);
        return "redirect:/";
    }
    @GetMapping("/delete_product/{Id}")
    public String deleteProduct(@PathVariable("Id") Long id, Model model){
        model.addAttribute("product", productController.getProduct(id));
        return "delete_product";
    }
    @PostMapping("/save_delete")
    public String saveDeleteProduct(@ModelAttribute("product") Product product){
        productController.deleteProduct(product.getId());
        return "redirect:/";
    }
}
