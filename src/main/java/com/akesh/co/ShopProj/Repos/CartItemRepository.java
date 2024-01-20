package com.akesh.co.ShopProj.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akesh.co.ShopProj.models.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
