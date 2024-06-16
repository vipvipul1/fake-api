package com.scaler.demo.fakeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class CartDTO {
    private long id;
    private int userId;
    private LocalDate date;
    private List<ProductDTO> products;
}
