package com.akesh.co.ShopProj.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@ToString
@Entity
@Table(name ="products")
@NoArgsConstructor // it will create constructors
@Getter // It will create setter and getter
@Setter

public class Product {

	public Product(String name, Integer price, Integer quanity) {
		super();
		this.name = name;
		this.price = price;
		this.quanity = quanity;
	}

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name ="price",nullable = false)
	private Integer price;
	
	@Column(name="qty",nullable = false)
	private Integer quanity;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<CartItem> cartItems=new ArrayList<>();

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quanity=" + quanity + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuanity() {
		return quanity;
	}

	public void setQuanity(Integer quanity) {
		this.quanity = quanity;
	}
	
	

}

