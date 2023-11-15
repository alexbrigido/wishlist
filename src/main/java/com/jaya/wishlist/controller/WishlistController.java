package com.jaya.wishlist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WishlistController {


    @GetMapping(value = "/wishlist")
    public ResponseEntity<Object> findAll(
            @RequestParam(value = "clientId") Long clientId
    ){
        var response = "olá";
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/wishlist/{productId}")
    public ResponseEntity<Object> findByProductId(
            @RequestParam(value = "clientId") Long clientId,
            @PathVariable(value = "productId") Long productId
    ){
        var response = "olá";
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/wishlist")
    public ResponseEntity<Object> add(
            @RequestParam(value = "clientId") Long clientId,
            @RequestParam(value = "productId") Long productId
    ){
        var response = "olá";
        return ResponseEntity.ok(response);
    }
}
