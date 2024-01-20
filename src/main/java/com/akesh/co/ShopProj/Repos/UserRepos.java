package com.akesh.co.ShopProj.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akesh.co.ShopProj.models.User;

public interface UserRepos extends JpaRepository<User, Long>
{
   Optional<User> findByUsername(String username);
	
}
