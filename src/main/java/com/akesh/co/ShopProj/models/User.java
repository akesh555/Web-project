package com.akesh.co.ShopProj.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
 
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name",nullable = false)
	private String name;
	@Column(name="username",nullable = false,unique = true)
	private String username;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="roles",nullable = false)
	private String roles;
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<CartItem> cartItems=new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public User() {
		super();
	}







	public User(String name, String username, String password, String roles) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}







	@CreationTimestamp
	private LocalDateTime createAt;
	
	@UpdateTimestamp
	private LocalDateTime updateAt;
	
}
