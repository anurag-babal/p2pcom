package com.example.p2pcom.service;

import com.example.p2pcom.data.ProductRepository;
import com.example.p2pcom.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    public void getProductById(long id) {
        Product product = productRepository.getProductById(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found");
        }
    }
}
