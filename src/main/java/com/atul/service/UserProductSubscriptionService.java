package com.atul.service;

import java.util.List;

import com.atul.dto.ProductsDto;
import com.atul.dto.UserProductSubscriptionDto;

public interface UserProductSubscriptionService {
	
	public UserProductSubscriptionDto subscribe(Long userId,Long productId,Long accountId);
	public List<ProductsDto> getAllProducts();	
	public List<ProductsDto> getAllSubscribedProductsByUserId(Long userId);
	
	
	

}
