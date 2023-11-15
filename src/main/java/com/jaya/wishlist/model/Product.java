package com.jaya.wishlist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PRODUCT")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "NAME")
    private String name;

}
