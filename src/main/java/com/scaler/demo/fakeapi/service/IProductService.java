package com.scaler.demo.fakeapi.service;

import com.scaler.demo.fakeapi.model.Product;

import java.util.Optional;

public interface IProductService {
    Product addProduct(Product product);

    Optional<Product> getProduct(String name);
}
