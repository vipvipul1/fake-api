package com.scaler.demo.fakeapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    @Value("${fake.store.api}")
    private String FAKE_STORE_API_BASE_URL;

    public String getBaseUrl() {
        return FAKE_STORE_API_BASE_URL;
    }
}
