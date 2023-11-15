package com.jaya.wishlist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistPK implements Serializable {

    @Column(name = "CLIENT_ID")
    private Long clientId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

}
