package com.atul.persistent.dao;

import com.atul.persistent.model.Accounts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountsDao extends JpaRepository<Accounts,Long> {

	@Query("from Accounts ac where ac.user = ?")
	public List<Accounts> findByUserId(Long userId);
	
	

}
