package com.scaler.demo.fakeapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
    private long productId;
    private int quantity;
}
