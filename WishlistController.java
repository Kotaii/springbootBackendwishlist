package com.capspringboot.demo;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.capspringboot.demo.model.Response;
import com.capspringboot.demo.model.Wishlist;
import com.capspringboot.demo.repo.WishlistRepository;

@CrossOrigin(origins = {"http://localhost:9080", "http://localhost:9191", "http://localhost:4200"})
@RequestMapping("/wishList")
@Controller
public class WishlistController {
	@Autowired
	private WishlistRepository repository;
	
	final String TAG= "Wishlist";
	
	@PostMapping("/add/")
	public Response<Wishlist> addItemToWishList(@RequestParam Integer productId,@RequestParam Integer userId) {
		Date date = new Date();
		
		Wishlist wishlist = new Wishlist(null, productId, userId);
		repository.save(wishlist);
		
		return new Response<Wishlist>(101, TAG+" Saved succesfully at "+date, null);
	}
	
	@GetMapping("/get")
	public Response<Wishlist> getWishListItems() {
		Date date = new Date();
		
		ArrayList<Wishlist> list = new ArrayList<Wishlist>();
		repository.findAll().forEach((wishlist) -> list.add(wishlist));
		
		return new Response<Wishlist>(101, list.size()+" "+TAG+"s fetched succesfully at "+date, list);
	}
	
	@GetMapping("/get/{id}")
	public Response<Wishlist> getWishListItemsById(@PathVariable("id") Integer id) {
		Date date = new Date();
		
		ArrayList<Wishlist> list = new ArrayList<Wishlist>();
		Wishlist wishlist = repository.findById(id).get();
		list.add(wishlist);
		
		return new Response<Wishlist>(101, TAG+" fetched succesfully at "+date, list);
	}
	
	@GetMapping("/get-user-wishlist/{userid}")
	public Response<Wishlist> getUserCartProducts(@PathVariable("userId") Integer userId) {
		Date date = new Date();
		
		ArrayList<Wishlist> list = new ArrayList<Wishlist>();
		repository.findAllProductsByUserId(userId).forEach((cart) -> list.add(cart));
		
		
		return new Response<Wishlist>(101, list.size()+" "+TAG+"s fetched succesfully at "+date, list);
	}
}