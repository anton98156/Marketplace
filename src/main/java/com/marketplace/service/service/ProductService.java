package com.marketplace.service.service;

import org.springframework.stereotype.Service;
import com.marketplace.service.entity.Product;
import com.marketplace.service.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Реализация методов репозитория.

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

    public void updateById(Product product, int id) {
        productRepository.updateById(product, id);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

}
