package com.scaler.demo.fakeapi.controller;

import com.scaler.demo.fakeapi.model.Product;
import com.scaler.demo.fakeapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService iProductService;

    @Autowired
    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        ResponseEntity<?> response;
        Product savedProduct = iProductService.addProduct(product);
        response = ResponseEntity.status(HttpStatus.OK).body(savedProduct);
        return response;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getProduct(@PathVariable("name") String name) {
        ResponseEntity<?> response;
        Optional<Product> product = iProductService.getProduct(name);
        if (product.isEmpty())
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            response = ResponseEntity.status(HttpStatus.OK).body(product);
        return response;
    }
}
