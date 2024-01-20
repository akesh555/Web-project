package com.akesh.co.ShopProj.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class CartItem {

	      @Id
	      @GeneratedValue(strategy = GenerationType.IDENTITY)
	      private Long id;
	      
	      @ManyToOne
	      private Product product;
	      
	      @ManyToOne
	      private User user;
	      
	      private Integer quantity;
	      
	      private Integer price;
	      
	      @Override
		public String toString() {
			return "CartItem [id=" + id + ", product=" + product + ", user=" + user + ", createdAt=" + createdAt + "]";
		}



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public Product getProduct() {
			return product;
		}



		public void setProduct(Product product) {
			this.product = product;
		}



		public User getUser() {
			return user;
		}



		public void setUser(User user) {
			this.user = user;
		}



		public LocalDateTime getCreatedAt() {
			return createdAt;
		}



		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}



		public CartItem() {
			super();
			// TODO Auto-generated constructor stub
		}



	






		public Integer getQuantity() {
			return quantity;
		}



		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}



		public Integer getPrice() {
			return price;
		}



		public void setPrice(Integer price) {
			this.price = price;
		}



		public CartItem(Product product, User user, Integer quantity, Integer price) {
			super();
			this.product = product;
			this.user = user;
			this.quantity = quantity;
			this.price = price;
		}







		@CreationTimestamp
	      private LocalDateTime createdAt;
	      
}
