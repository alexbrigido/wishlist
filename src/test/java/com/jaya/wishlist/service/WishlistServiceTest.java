package com.jaya.wishlist.service;

import com.jaya.wishlist.model.Client;
import com.jaya.wishlist.model.Product;
import com.jaya.wishlist.model.Wishlist;
import com.jaya.wishlist.model.WishlistPK;
import com.jaya.wishlist.repository.ClientRepository;
import com.jaya.wishlist.repository.ProductRepository;
import com.jaya.wishlist.repository.WishlistRepositoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class WishlistServiceTest {

    @InjectMocks
    private WishlistService service;

    @Mock
    private WishlistRepositoy repository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp(){
        Mockito.when(clientRepository.findById(1l)).thenReturn(
                Optional.ofNullable(Client.builder()
                        .clientId(1l)
                        .name("TONY STARK")
                        .build())
        );
        Mockito.when(productRepository.findById(1l)).thenReturn(
                Optional.ofNullable(Product.builder()
                        .productId(1l)
                        .name("Smart TV 86\" 4K LG 86QNED80SRA")
                        .build())
        );
        Mockito.when(productRepository.findById(2l)).thenReturn(
                Optional.ofNullable(Product.builder()
                        .productId(2l)
                        .name("Apple notebook MacBook Pro")
                        .build())
        );
        Mockito.when(repository.findByClientId(1l)).thenReturn(List.of(
                Wishlist.builder()
                        .id(new WishlistPK(1l, 1l))
                        .build()
        ));
        Mockito.when(repository.findById(new WishlistPK(1l, 1l)))
                .thenReturn(
                Optional.ofNullable(Wishlist.builder()
                        .id(new WishlistPK(1l, 1l))
                        .build())
        );
    }

    @Test
    void shouldListAllByClientSuccessfully(){
        var list = service.findAllByClientId(1l);
        Assertions.assertEquals(1, list.size());
        Mockito.verify(repository, Mockito.times(1)).findByClientId(1l);
    }

    @Test
    void shouldListOneProductByClientSuccessfully(){
        var theOne = service.findOneByClient(1l, 1l);
        Assertions.assertEquals(1, theOne.getId().getClientId());
        Assertions.assertEquals(1, theOne.getId().getProductId());
        Mockito.verify(repository, Mockito.times(1))
                .findById(new WishlistPK(1l, 1l));
    }

    @Test
    void shouldAddProductSuccessfully(){
        service.add(1l, 2l);
        Mockito.verify(repository, Mockito.times(1))
                .save(Wishlist.builder()
                        .id(new WishlistPK(1l, 2l))
                .build());
    }

    @Test
    void shouldDeleteProductSuccessfully(){
        service.delete(1l, 1l);
        Mockito.verify(repository, Mockito.times(1))
                .delete(Wishlist.builder()
                        .id(new WishlistPK(1l, 1l))
                .build());
    }

}
