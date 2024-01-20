package com.akesh.co.ShopProj.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akesh.co.ShopProj.services.CartItemService;

@RestController
@RequestMapping("/api/v1/cartitem")
public class CartController {
	
	@Autowired
   CartItemService cartItemService;
	
	@PostMapping("/")
	public String addToCart(@RequestBody Map<String, Long> item)
	{
//		 System.out.println(item);
		cartItemService.addToCart(item);
		System.out.println(item);
		
		return "controller";
	}

}
