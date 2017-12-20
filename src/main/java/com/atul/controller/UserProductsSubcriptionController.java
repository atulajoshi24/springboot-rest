package com.atul.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atul.dto.ProductsDto;
import com.atul.dto.UserDto;
import com.atul.dto.UserProductSubscriptionDto;
import com.atul.service.UserProductSubscriptionService;

@RestController
public class UserProductsSubcriptionController {
	
	private UserProductSubscriptionService userProductSubscriptionService;

	@Autowired
	public UserProductsSubcriptionController(UserProductSubscriptionService userProductSubscriptionService) {
	
		this.userProductSubscriptionService = userProductSubscriptionService;
	}
	
	
	@RequestMapping(value = "/productSubscription/{userId}/{productId}/{accountId}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void subscribe(@PathVariable("productId") final Long productId,
						  @PathVariable("accountId") final Long accountId,HttpServletRequest request){
		
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long userId = null;
		
		if(auth instanceof UserDto){
			userId = ((UserDto)auth).getUserId();
		}

		if(userId == null){
			//throw exception 
		}
		
		UserProductSubscriptionDto userProductSubscriptionDto = this.userProductSubscriptionService.subscribe(userId, productId,accountId);
		request.getSession().setAttribute("userProductSubscriptionDto",userProductSubscriptionDto);
 
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<ProductsDto> getAllProducts(HttpServletRequest req){
			
		return this.userProductSubscriptionService.getAllProducts();
	}
	
	@RequestMapping(value = "/subscriptionInfo", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public UserProductSubscriptionDto getSubscriptionInfo(HttpServletRequest req){
			
		UserProductSubscriptionDto userProductSubscriptionDto = (UserProductSubscriptionDto)req.getSession().getAttribute("userProductSubscriptionDto");
		return userProductSubscriptionDto;
		
	}
	
	@RequestMapping(value = "/subscribedProducts", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<ProductsDto> getAllSubscribedProductsByUserId(){
			
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long userId = null;
		
		if(auth instanceof UserDto){
			userId = ((UserDto)auth).getUserId();
		}

		if(userId == null){
			//throw exception 
		}
		
		return this.userProductSubscriptionService.getAllSubscribedProductsByUserId(userId);
		
	}
	

}
