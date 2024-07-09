package com.scaler.demo.fakeapi.repository;

import com.scaler.demo.fakeapi.model.Category;
import com.scaler.demo.fakeapi.model.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CategoryRepositoryTest {
    private final ICategoryRepository iCategoryRepository;

    @Autowired
    public CategoryRepositoryTest(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    @Test
    @Transactional
    public void testQueries() {
        Optional<Category> categoryOptional = iCategoryRepository.findById(2L);
        if (categoryOptional.isPresent()) {
            List<Product> products = categoryOptional.get().getProducts();
            for (Product p : products) {
                System.out.println(p.getName() + " ");
            }
        }
    }
}
