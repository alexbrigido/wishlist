package com.jaya.wishlist.service;

import com.jaya.wishlist.model.Wishlist;
import com.jaya.wishlist.repository.WishlistRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    WishlistRepositoy repository;

    public List<Wishlist> findAllByClientId(Long clientId) {
        return repository.findByClientId(clientId);
    }

}
