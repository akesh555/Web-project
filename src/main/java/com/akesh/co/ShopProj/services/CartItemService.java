package com.akesh.co.ShopProj.services;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.akesh.co.ShopProj.Repos.CartItemRepository;
import com.akesh.co.ShopProj.Repos.ProductRepository;
import com.akesh.co.ShopProj.Repos.UserRepos;
import com.akesh.co.ShopProj.models.CartItem;
import com.akesh.co.ShopProj.models.Product;

@Service
public class CartItemService {
	
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepos userRepos;
	
	public String addToCart(Map<String, Long> items)
	{
		CartItem cartItem=new CartItem();
		Optional<Product> product=productRepository.findById(items.get("product_id"));
		
		Optional<com.akesh.co.ShopProj.models.User> user=userRepos.findById(items.get("user_id"));
		
		cartItem.setProduct(product.get());
		cartItem.setUser(user.get());
		cartItem.setQuantity(items.get("quantity").intValue());
		cartItem.setPrice(items.get("price").intValue());
		
		cartItemRepository.save(cartItem);
		return "added to cart";
		
		
	}

}
