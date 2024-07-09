package com.scaler.demo.fakeapi.service.impl;

import com.scaler.demo.fakeapi.model.Category;
import com.scaler.demo.fakeapi.model.Product;
import com.scaler.demo.fakeapi.repository.ICategoryRepository;
import com.scaler.demo.fakeapi.repository.IProductRepository;
import com.scaler.demo.fakeapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    private final IProductRepository iProductRepository;
    private final ICategoryRepository iCategoryRepository;

    @Autowired
    public ProductServiceImpl(IProductRepository iProductRepository, ICategoryRepository iCategoryRepository) {
        this.iProductRepository = iProductRepository;
        this.iCategoryRepository = iCategoryRepository;
    }

    @Override
    @Transactional
    public Product addProduct(Product product) {
        Optional<Category> categoryOptional = iCategoryRepository.findByName(product.getCategory().getName());
        if (categoryOptional.isEmpty()) {
            product.setCategory(iCategoryRepository.save(product.getCategory()));
        } else {
            product.setCategory(categoryOptional.get());
        }
        return iProductRepository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> getProduct(String name) {
        return iProductRepository.findByName(name);
    }
}
