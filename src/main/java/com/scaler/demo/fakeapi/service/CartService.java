package com.scaler.demo.fakeapi.service;

import com.scaler.demo.fakeapi.dto.CartDTO;
import com.scaler.demo.fakeapi.exception.cart.CartApiException;

import java.util.List;

public interface CartService {
    List<CartDTO> getAllCarts() throws CartApiException;

    CartDTO getSingleCart(String cartId) throws CartApiException;

    CartDTO addToCart(CartDTO cartDTORequest) throws CartApiException;

    CartDTO updateCart(String cartId, CartDTO cartDTORequest) throws CartApiException;

    CartDTO deleteCart(String cartId) throws CartApiException;
}
