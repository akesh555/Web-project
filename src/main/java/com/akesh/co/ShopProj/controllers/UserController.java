package com.akesh.co.ShopProj.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akesh.co.ShopProj.models.AuthRequest;
import com.akesh.co.ShopProj.models.Product;
import com.akesh.co.ShopProj.models.User;
import com.akesh.co.ShopProj.services.*;
import com.akesh.co.ShopProj.services.UserService;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	@Autowired
	UserService userService;
	
	@GetMapping("/userdata")
	public String getUser()
	{
		return "User Data";
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user)
	{
		

		
//		User getuserdetailsUser=userService.CreateUser(user);
//		return getuserdetailsUser;
		return userService.CreateUser(user);
	}
	
	
	@PostMapping("/login")
	public String loginUser(@RequestBody AuthRequest authRequest)
	

	{
	  Authentication authentication=
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	
	if (authentication.isAuthenticated()) {
		
		return jwtService.generateToken(authRequest.getUsername());
		
	}
	else
	{
		throw new RuntimeException("wrong password");
	}
	}
	}

	

