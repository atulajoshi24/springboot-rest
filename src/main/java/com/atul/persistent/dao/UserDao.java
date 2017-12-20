package com.atul.persistent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atul.persistent.model.Accounts;
import com.atul.persistent.model.User;

public interface UserDao extends JpaRepository<User,Long>{
	
	public User findByUserName(String userName);
	
	@Query("select u.accounts from User u where u.userId = :userId")
	public List<Accounts> findByUserId(@Param("userId") Long userId);
	

	
	

}
