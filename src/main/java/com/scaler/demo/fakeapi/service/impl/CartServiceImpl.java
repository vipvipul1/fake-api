package com.scaler.demo.fakeapi.service.impl;

import com.scaler.demo.fakeapi.config.ApiConfig;
import com.scaler.demo.fakeapi.dto.CartDTO;
import com.scaler.demo.fakeapi.exception.cart.CartApiException;
import com.scaler.demo.fakeapi.service.ICartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    private final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

    private final String CART_API_ENDPOINT;

    private final RestTemplate restTemplate;

    @Autowired
    public CartServiceImpl(ApiConfig apiConfig, RestTemplate restTemplate) {
        this.CART_API_ENDPOINT = apiConfig.getBaseUrl() + "/carts";
        this.restTemplate = restTemplate;
    }

    public List<CartDTO> getAllCarts() throws CartApiException {
        List<CartDTO> carts;
        try {
            ResponseEntity<List<CartDTO>> responseEntity = restTemplate.exchange(CART_API_ENDPOINT, HttpMethod.GET,
                    null, new ParameterizedTypeReference<>() {});
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                carts = responseEntity.getBody();
            } else {
                StringBuilder errorMessage = new StringBuilder();
                errorMessage.append("Error in getting all carts from Fake Store API: ")
                        .append(CART_API_ENDPOINT)
                        .append(". Response: ")
                        .append(HttpStatus.valueOf(responseEntity.getStatusCode().value()).name())
                        .append(". Error: There is a downtime. Please try later!");
                LOGGER.error("Error in CartServiceImpl :: getAllCarts :: {}", errorMessage);
                throw new CartApiException(errorMessage.toString(), HttpStatus.valueOf(responseEntity.getStatusCode().value()));
            }
        } catch (Exception e) {
            LOGGER.error("Error in CartServiceImpl :: getAllCarts :: {}", e.getMessage());
            throw e;
        }
        return carts;
    }

    @Override
    public CartDTO getSingleCart(String cartId) throws CartApiException {
        CartDTO cartDTO;
        String GET_SINGLE_CART_API_ENDPOINT = CART_API_ENDPOINT + "/" + cartId;
        try {
            ResponseEntity<CartDTO> responseEntity = restTemplate.exchange(GET_SINGLE_CART_API_ENDPOINT, HttpMethod.GET, null, CartDTO.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                cartDTO = responseEntity.getBody();
            } else {
                StringBuilder errorMessage = new StringBuilder();
                errorMessage.append("Error in getting single cart with Cart Id ")
                        .append(cartId)
                        .append(" from Fake Store API: ")
                        .append(GET_SINGLE_CART_API_ENDPOINT)
                        .append(". Response: ")
                        .append(HttpStatus.valueOf(responseEntity.getStatusCode().value()).name())
                        .append(". Error: There is a downtime. Please try later!");
                LOGGER.error("Error in CartServiceImpl :: getSingleCart :: {}", errorMessage);
                throw new CartApiException(errorMessage.toString(), HttpStatus.valueOf(responseEntity.getStatusCode().value()));
            }
        } catch (Exception e) {
            LOGGER.error("Error in CartServiceImpl :: getSingleCart :: {}", e.getMessage());
            throw e;
        }
        return cartDTO;
    }

    @Override
    public CartDTO addToCart(CartDTO cartDTORequest) throws CartApiException {
        CartDTO cartDTOResponse;
        try {
            HttpEntity<CartDTO> requestEntity = new HttpEntity<>(cartDTORequest);
            ResponseEntity<CartDTO> responseEntity = restTemplate.exchange(CART_API_ENDPOINT, HttpMethod.POST, requestEntity, CartDTO.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                cartDTOResponse = responseEntity.getBody();
            } else {
                StringBuilder errorMessage = new StringBuilder();
                errorMessage.append("Error in saving cart at Fake Store API: ")
                        .append(CART_API_ENDPOINT)
                        .append(". Response: ")
                        .append(HttpStatus.valueOf(responseEntity.getStatusCode().value()).name())
                        .append(". Error: There is a downtime. Please try later!");
                LOGGER.error("Error in CartServiceImpl :: addToCart :: {}", errorMessage);
                throw new CartApiException(errorMessage.toString(), HttpStatus.valueOf(responseEntity.getStatusCode().value()));
            }
        } catch (Exception e) {
            LOGGER.error("Error in CartServiceImpl :: addToCart :: {}", e.getMessage());
            throw e;
        }
        return cartDTOResponse;
    }

    @Override
    public CartDTO updateCart(String cartId, CartDTO cartDTORequest) throws CartApiException {
        CartDTO cartDTOResponse;
        String UPDATE_CART_API_ENDPOINT = CART_API_ENDPOINT + "/" + cartId;
        try {
            HttpEntity<CartDTO> requestEntity = new HttpEntity<>(cartDTORequest);
            ResponseEntity<CartDTO> responseEntity = restTemplate.exchange(UPDATE_CART_API_ENDPOINT, HttpMethod.PUT, requestEntity, CartDTO.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                cartDTOResponse = responseEntity.getBody();
            } else {
                StringBuilder errorMessage = new StringBuilder();
                errorMessage.append("Error in updating cart with Cart Id ")
                        .append(cartId)
                        .append(" at Fake Store API: ")
                        .append(UPDATE_CART_API_ENDPOINT)
                        .append(". Response: ")
                        .append(HttpStatus.valueOf(responseEntity.getStatusCode().value()).name())
                        .append(". Error: There is a downtime. Please try later!");
                LOGGER.error("Error in CartServiceImpl :: updateCart :: {}", errorMessage);
                throw new CartApiException(errorMessage.toString(), HttpStatus.valueOf(responseEntity.getStatusCode().value()));
            }
        } catch (Exception e) {
            LOGGER.error("Error in CartServiceImpl :: updateCart :: {}", e.getMessage());
            throw e;
        }
        return cartDTOResponse;
    }

    @Override
    public CartDTO deleteCart(String cartId) throws CartApiException {
        CartDTO cartDTO;
        String DELETE_CART_API_ENDPOINT = CART_API_ENDPOINT + "/" + cartId;
        try {
            ResponseEntity<CartDTO> responseEntity = restTemplate.exchange(DELETE_CART_API_ENDPOINT, HttpMethod.DELETE, null, CartDTO.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                cartDTO = responseEntity.getBody();
            } else {
                StringBuilder errorMessage = new StringBuilder();
                errorMessage.append("Error in deleting cart with Cart Id ")
                        .append(cartId)
                        .append(" at Fake Store API: ")
                        .append(DELETE_CART_API_ENDPOINT)
                        .append(". Response: ")
                        .append(HttpStatus.valueOf(responseEntity.getStatusCode().value()).name())
                        .append(". Error: There is a downtime. Please try later!");
                LOGGER.error("Error in CartServiceImpl :: deleteCart :: {}", errorMessage);
                throw new CartApiException(errorMessage.toString(), HttpStatus.valueOf(responseEntity.getStatusCode().value()));
            }
        } catch (Exception e) {
            LOGGER.error("Error in CartServiceImpl :: deleteCart :: {}", e.getMessage());
            throw e;
        }
        return cartDTO;
    }
}
