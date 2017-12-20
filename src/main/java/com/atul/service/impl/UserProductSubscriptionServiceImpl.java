package com.atul.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atul.dto.AccountsDto;
import com.atul.dto.ProductsDto;
import com.atul.dto.UserProductSubscriptionDto;
import com.atul.exception.OlbValidationException;
import com.atul.persistent.dao.ProductDao;
import com.atul.persistent.dao.UserDao;
import com.atul.persistent.model.Accounts;
import com.atul.persistent.model.Products;
import com.atul.persistent.model.User;
import com.atul.service.UserProductSubscriptionService;

@Service
public class UserProductSubscriptionServiceImpl implements UserProductSubscriptionService{

	private UserDao userDao;
	private ProductDao productDao;
		
	
	@Autowired
	public UserProductSubscriptionServiceImpl(UserDao userDao, ProductDao productDao) {
		super();
		this.userDao = userDao;
		this.productDao = productDao;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProductsDto> getAllProducts() {
		
		List<Products> productList = this.productDao.findAll();
		List<ProductsDto> productsDtoList = productList.stream().map(products -> new ProductsDto(products.getProductId(),products.getProductName(),
								products.getDescription(),products.getMinBalance())).collect(Collectors.toList());
		
		return productsDtoList;
		
	}

	@Override
	@Transactional
	public UserProductSubscriptionDto subscribe(Long userId, Long productId,Long accountId) {
		
		//check if user exists 
		//check if product exists 
		//add product to user entity 
		//persists user entity
		User user = this.userDao.findOne(userId);
		if(user == null){
			//throw exception 
		}
		Products product = this.productDao.findOne(productId);
		if(product == null){
			throw new OlbValidationException("Product you chhose to subscrine doesn't exists . Please choose another product");
		}
		
		Accounts accountToDebit = user.getAccounts().stream().filter(account -> account.getAccountId().equals(accountId)).findFirst().orElse(null);
		if(accountToDebit == null){
			throw new OlbValidationException("The account you choose to debit doesn't exist.Please try with another account");
		}
		
		if(accountToDebit.getBalance() < product.getMinBalance()){
			throw new OlbValidationException("You don't have sufficient Balance to subscribe to this product");
		}else{			
			accountToDebit.setBalance(accountToDebit.getBalance() - product.getMinBalance());						
		}		
		user.addProducts(product);
		
		ProductsDto productsDto = new ProductsDto(product.getProductId(), product.getProductName(),product.getDescription(),product.getMinBalance());
		AccountsDto accountsDto = new AccountsDto(accountToDebit.getAccountId(), accountToDebit.getBalance(), accountToDebit.getAccountType());
		
		UserProductSubscriptionDto userProdSubscriptionDto = new UserProductSubscriptionDto(productsDto,accountsDto);
		return userProdSubscriptionDto;		
		
		
	}

	@Override
	public List<ProductsDto> getAllSubscribedProductsByUserId(Long userId) {
		
				
		List<Products> productList = this.productDao.findAllSubscribedProductsByUserId(userId);
		List<ProductsDto> productsDtoList = productList.stream().map(products -> new ProductsDto(products.getProductId(),products.getProductName(),
				products.getDescription(),products.getMinBalance())).collect(Collectors.toList());

		return productsDtoList;
				
		
	}

}
