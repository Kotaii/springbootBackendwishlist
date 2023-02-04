package com.capspringboot.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer wishlistId;
	private Integer productId;
	private Integer userId;
	
	
	public Wishlist() {
		
	}


	public Wishlist(Integer wishlistId, Integer productId, Integer userId) {
		this.wishlistId = wishlistId;
		this.productId = productId;
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Wishlist [wishlistId=" + wishlistId + ", productId=" + productId + ", userId=" + userId + "]";
	}








    
    
	
	
	

}
