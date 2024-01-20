package com.akesh.co.ShopProj.services;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akesh.co.ShopProj.Repos.UserRepos;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepos userRepos;
    @Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<com.akesh.co.ShopProj.models.User> user=userRepos.findByUsername(username);
		
		if(!user.isPresent())
		{
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDeatils(user.get());
		
	}

	
	public String CreateUser(com.akesh.co.ShopProj.models.User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepos.save(user);
		
		return "user Created";
		
	}
	
}
