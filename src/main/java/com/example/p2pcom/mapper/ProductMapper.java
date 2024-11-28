package com.example.p2pcom.mapper;

import com.example.p2pcom.dto.ProductCreateDto;
import com.example.p2pcom.dto.ProductResponseDto;
import com.example.p2pcom.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponseDto toProductResponseDto(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice()
        );
    }

    public Product toProduct(ProductCreateDto productCreateDto) {
        Product product = new Product();
        product.setName(productCreateDto.name());
        product.setCategory(productCreateDto.category());
        product.setPrice(productCreateDto.price());
        return product;
    }
}
