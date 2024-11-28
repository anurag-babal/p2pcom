package com.example.p2pcom.data;

import com.example.p2pcom.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductRepository {
    ArrayList<Product> products = new ArrayList<>();

    public Product addProduct(Product product) {
        product.setId(products.size() + 1);
        products.add(product);
        return product;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product getProductById(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
