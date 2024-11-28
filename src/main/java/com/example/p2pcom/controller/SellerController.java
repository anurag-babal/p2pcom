package com.example.p2pcom.controller;

import com.example.p2pcom.dto.ProductCreateDto;
import com.example.p2pcom.dto.ProductResponseDto;
import com.example.p2pcom.mapper.ProductMapper;
import com.example.p2pcom.model.Product;
import com.example.p2pcom.service.SellerService;
import com.example.p2pcom.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seller")
public class SellerController {
    private final SellerService sellerService;
    private final ProductService productService;
    private final ProductMapper productMapper;

    public SellerController(
            ProductService productService,
            SellerService sellerService,
            ProductMapper productMapper
    ) {
        this.productService = productService;
        this.sellerService = sellerService;
        this.productMapper = productMapper;
    }

    @PostMapping("/add-product")
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductCreateDto productCreateDto) {
        Product product = productMapper.toProduct(productCreateDto);
        product =  productService.addProduct(product);
        sellerService.listProduct(product);
        return ResponseEntity.ok(productMapper.toProductResponseDto(product));
    }
}
