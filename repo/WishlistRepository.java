package com.capspringboot.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capspringboot.demo.model.Cart;
import com.capspringboot.demo.model.Wishlist;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist,Integer>{
	 
     public List<Wishlist> findById(Integer productId, Integer userId);

	public List<Wishlist>findAllProductsByUserId(Integer userId);

	
}
