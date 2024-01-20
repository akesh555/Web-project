package com.akesh.co.ShopProj.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akesh.co.ShopProj.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findProductByName(String name);

}
