package com.jaya.wishlist.repository;

import com.jaya.wishlist.model.Wishlist;
import com.jaya.wishlist.model.WishlistPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepositoy extends JpaRepository<Wishlist, WishlistPK> {

    @Query(value = "from Wishlist w where w.id.clientId = ?1")
    public List<Wishlist> findByClientId(Long clientId);
}
