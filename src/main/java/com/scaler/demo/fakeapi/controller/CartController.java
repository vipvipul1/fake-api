package com.scaler.demo.fakeapi.controller;

import com.scaler.demo.fakeapi.dto.CartDTO;
import com.scaler.demo.fakeapi.exception.GenericFakeApiException;
import com.scaler.demo.fakeapi.exception.cart.CartApiException;
import com.scaler.demo.fakeapi.service.CartService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController extends BaseController {
    private final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCarts() {
        ResponseEntity<?> response;
        try {
            List<CartDTO> carts = cartService.getAllCarts();
            response = ResponseEntity.status(HttpStatus.OK).body(carts);
        } catch (CartApiException e) {
            LOGGER.error("Error in CartController :: getAllCarts :: {}", e.getMessage(), e);
            String errorMessage = ExceptionUtils.getRootCauseMessage(e);
            response = getResponse(e.getHttpStatus(), e, errorMessage, "Get All Carts API Failed");
        } catch (Exception e) {
            LOGGER.error("Error in CartController :: getAllCarts :: {}", e.getMessage(), e);
            String errorMessage = ExceptionUtils.getRootCauseMessage(e);
            response = getResponse(e, errorMessage, "Get All Carts Failed");
        }
        return response;
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<?> getSingleCart(@PathVariable("cartId") String cartId) {
        ResponseEntity<?> response;
        try {
            CartDTO cart = cartService.getSingleCart(cartId);
            response = ResponseEntity.status(HttpStatus.OK).body(cart);
        } catch (CartApiException e) {
            LOGGER.error("Error in CartController :: getSingleCart :: {}", e.getMessage(), e);
            String errorMessage = ExceptionUtils.getRootCauseMessage(e);
            response = getResponse(e.getHttpStatus(), e, errorMessage, "Get Single Cart API Failed");
        } catch (Exception e) {
            LOGGER.error("Error in CartController :: getSingleCart :: {}", e.getMessage(), e);
            String errorMessage = ExceptionUtils.getRootCauseMessage(e);
            response = getResponse(e, errorMessage, "Get Single Cart Failed");
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<?> addToCart(@RequestBody CartDTO cartDTORequest) {
        ResponseEntity<?> response;
        try {
            CartDTO cartDTOResponse = cartService.addToCart(cartDTORequest);
            response = ResponseEntity.status(HttpStatus.OK).body(cartDTOResponse);
        } catch (CartApiException e) {
            LOGGER.error("Error in CartController :: addToCart :: {}", e.getMessage(), e);
            String errorMessage = ExceptionUtils.getRootCauseMessage(e);
            response = getResponse(e.getHttpStatus(), e, errorMessage, "Add To Cart API Failed");
        } catch (Exception e) {
            LOGGER.error("Error in CartController :: addToCart :: {}", e.getMessage(), e);
            String errorMessage = ExceptionUtils.getRootCauseMessage(e);
            response = getResponse(e, errorMessage, "Add To Cart Failed");
        }
        return response;
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<?> updateCart(@PathVariable("cartId") String cartId, @RequestBody CartDTO cartDTORequest) {
        ResponseEntity<?> response;
        try {
            CartDTO cartDTOResponse = cartService.updateCart(cartId, cartDTORequest);
            response = ResponseEntity.status(HttpStatus.OK).body(cartDTOResponse);
        } catch (CartApiException e) {
            LOGGER.error("Error in CartController :: updateCart :: {}", e.getMessage(), e);
            String errorMessage = ExceptionUtils.getRootCauseMessage(e);
            response = getResponse(e.getHttpStatus(), e, errorMessage, "Update Cart API Failed");
        } catch (Exception e) {
            LOGGER.error("Error in CartController :: updateCart :: {}", e.getMessage(), e);
            String errorMessage = ExceptionUtils.getRootCauseMessage(e);
            response = getResponse(e, errorMessage, "Update Cart Failed");
        }
        return response;
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable("cartId") String cartId) {
        ResponseEntity<?> response;
        try {
            CartDTO cartDTO = cartService.deleteCart(cartId);
            response = ResponseEntity.status(HttpStatus.OK).body(cartDTO);
        } catch (CartApiException e) {
            LOGGER.error("Error in CartController :: deleteCart :: {}", e.getMessage(), e);
            String errorMessage = ExceptionUtils.getRootCauseMessage(e);
            response = getResponse(e.getHttpStatus(), e, errorMessage, "Delete Cart API Failed");
        } catch (Exception e) {
            LOGGER.error("Error in CartController :: deleteCart :: {}", e.getMessage(), e);
            String errorMessage = ExceptionUtils.getRootCauseMessage(e);
            response = getResponse(e, errorMessage, "Delete Cart Failed");
        }
        return response;
    }
}
