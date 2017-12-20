package com.atul.persistent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atul.persistent.model.Products;

public interface ProductDao extends JpaRepository<Products,Long>{

	
	@Query("select distinct u.products from User u join u.products where u.userId = :userId")
	public List<Products> findAllSubscribedProductsByUserId(@Param("userId") Long userId);
	
	
}
