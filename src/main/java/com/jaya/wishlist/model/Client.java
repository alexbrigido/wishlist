package com.jaya.wishlist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CLIENT")
public class Client implements Serializable {

    @Id
    @Column(name = "CLIENT_ID")
    private Long clientId;

    @Column(name = "NAME")
    private String name;

}
