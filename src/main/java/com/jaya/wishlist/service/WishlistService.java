package com.jaya.wishlist.service;

import com.jaya.wishlist.exception.BusinessException;
import com.jaya.wishlist.model.Wishlist;
import com.jaya.wishlist.model.WishlistPK;
import com.jaya.wishlist.repository.ClientRepository;
import com.jaya.wishlist.repository.ProductRepository;
import com.jaya.wishlist.repository.WishlistRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    WishlistRepositoy repository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    public List<Wishlist> findAllByClientId(Long clientId) {
        validateClient(clientId);
        return repository.findByClientId(clientId);
    }

    public Wishlist findOneByClient(Long clientId, Long productId){
        validateClient(clientId);
        validateProduct(productId);
        return findById(clientId, productId)
                .orElseThrow( () -> new BusinessException("Product not found on the client's wish list.") );
    }

    public void add(Long clientId, Long productId){
        validateClient(clientId);
        validateProduct(productId);
        if(findById(clientId, productId).isPresent()){
            throw new BusinessException("This product is already on the client's wish list.");
        }
        validateClientLimitProduct(clientId);
        var wishlist = new Wishlist(new WishlistPK(clientId, productId));
        repository.save(wishlist);
    }

    public void delete(Long clientId, Long productId) {
        validateClient(clientId);
        validateProduct(productId);
        if(repository.findById(new WishlistPK(clientId, productId)).isEmpty()){
            throw new BusinessException("This product does not exists on the client's wish list.");
        }
        var wishlist = new Wishlist(new WishlistPK(clientId, productId));
        repository.delete(wishlist);
    }

    private void validateClient(Long clientId){
        clientRepository.findById(clientId).orElseThrow( () -> new BusinessException("Client not found."));
    }

    private void validateProduct(Long productId){
        productRepository.findById(productId).orElseThrow( () -> new BusinessException("Product not found.") );
    }

    private void validateClientLimitProduct(Long clientId){
        if(repository.count(Example.of(new Wishlist(new WishlistPK(clientId, null)))) > 19){
            throw new BusinessException("The client must have only 20 items.");
        }
    }

    private Optional<Wishlist> findById(Long clientId, Long productId){
        return repository.findById(new WishlistPK(clientId, productId));
    }

}
