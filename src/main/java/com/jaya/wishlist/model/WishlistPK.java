package com.jaya.wishlist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Data
public class WishlistPK implements Serializable {

    @Column(name = "CLIENT_ID")
    private Long clientId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

}
