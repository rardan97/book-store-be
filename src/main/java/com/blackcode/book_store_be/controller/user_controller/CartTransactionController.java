package com.blackcode.book_store_be.controller.user_controller;


import com.blackcode.book_store_be.dto.cartitems.CartItemsReq;
import com.blackcode.book_store_be.dto.cartitems.CartItemsRes;
import com.blackcode.book_store_be.dto.category.CategoryReq;
import com.blackcode.book_store_be.dto.category.CategoryRes;
import com.blackcode.book_store_be.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/cartTransaction")
public class CartTransactionController {

    @Autowired
    private CartItemsService cartItemsService;



    @GetMapping("/getCart/{userId}")
    public List<CartItemsRes> getCart(@PathVariable("userId") Long userId) {
        return cartItemsService.getCart(userId);
    }

    @PostMapping("/addCart/{userId}")
    public void addToCart(@PathVariable("userId") Long userId, @RequestBody CartItemsReq item) {
        cartItemsService.addToCart(userId, item);
    }

    @DeleteMapping("/removeCart/{userId}/{bookId}")
    public void removeFromCart(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {
        cartItemsService.removeFromCart(userId, bookId);
    }

    @PostMapping("/clearCart/{userId}")
    public void clearCart(@PathVariable("userId") Long userId) {
        cartItemsService.clearCart(userId);
    }

    @PostMapping("/updateCartQty/{userId}/{bookId}/{quantity}")
    public void updateCartQty(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId, @PathVariable("quantity") Long quantity) {
        cartItemsService.updateQuantity(userId, bookId, quantity.intValue());
    }




}
