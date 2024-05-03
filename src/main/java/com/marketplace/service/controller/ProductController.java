package com.marketplace.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.marketplace.service.service.ProductService;
import com.marketplace.service.entity.Product;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Вывод всех товаров.
    @GetMapping("/")
    public String findAll(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    // Просмотр товара.
    @GetMapping("/product-open/{id}")
    public String findById(@PathVariable int id, Model model) {
        Product products = productService.findById(id);
        model.addAttribute("product", products);
        return "product-open";
    }

    // Переход на форму добавления продукта.
    @GetMapping("/product-create")
    public String createProductForm(Product product) {
        return "product-create";
    }

    // Создание продукта.
    @PostMapping("/product-create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    // Переход на форму обновления продукта.
    @GetMapping("/product-update/{id}")
    public String updateProductForm(Product product) {
        return "product-update";
    }

    // Обновление продукта.
    @PostMapping("/product-update")
    public String updateProduct(Product product, int id) {
        productService.updateById(product, id);
        return "redirect:/";
    }

    // Удаление продукта.
    @GetMapping("/product-delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
        return "redirect:/";
    }

}