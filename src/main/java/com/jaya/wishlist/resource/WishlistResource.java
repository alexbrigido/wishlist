package com.jaya.wishlist.resource;

import com.jaya.wishlist.model.Wishlist;
import com.jaya.wishlist.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class WishlistResource {

    @Autowired
    WishlistService service;

    @GetMapping(value = "/wishlist")
    public ResponseEntity<List<Wishlist>> findAll(
            @RequestParam(value = "clientId") Long clientId
    ){
        return ResponseEntity.ok(service.findAllByClientId(clientId));
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
        service.add(clientId, productId);
        return ResponseEntity.created(URI.create("/wishlist/")).build();
    }

    @DeleteMapping(value = "/wishlist")
    public ResponseEntity<Object> delete(
            @RequestParam(value = "clientId") Long clientId,
            @RequestParam(value = "productId") Long productId
    ){
        service.delete(clientId, productId);
        return ResponseEntity.ok().build();
    }
}
