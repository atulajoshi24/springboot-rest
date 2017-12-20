package com.atul.service.impl;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atul.dto.AccountsDto;
import com.atul.dto.UserDto;
import com.atul.persistent.dao.AccountsDao;
import com.atul.persistent.dao.RoleDao;
import com.atul.persistent.dao.UserDao;
import com.atul.persistent.model.Accounts;
import com.atul.persistent.model.Role;
import com.atul.persistent.model.User;
import com.atul.service.UserService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserServiceImpl implements UserService,UserDetailsService{
		
	private UserDao userDao;
	private RoleDao roleDao;	
	private AccountsDao accountsDao; 
	

	@Autowired
	public UserServiceImpl(UserDao userDao, RoleDao roleDao, AccountsDao accountsDao) {
		super();
		this.userDao = userDao;
		this.roleDao = roleDao;
		this.accountsDao = accountsDao;
	}


	@Override
	@Transactional
	public void saveUser(User user){
		
		//set account and roles details for time being 
		Accounts account = new Accounts();
		account.setBalance(10000.0);
		account.setAccountType("SAVING");
		user.addAcount(account);
		
		/*Role role = new Role();
		role.setRoleName("USER");
		user.addRole(role);*/
		List<Role> role = roleDao.findByRoleName("USER");
		user.addRole(role.get(0));
		
		user.setCreatedDate(new Date());
		
		userDao.save(user);		
		
	}


	@Override
	@Transactional(readOnly=true)
	public User getUserByUserName(String userName) {
		
		return this.userDao.findByUserName(userName);
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<AccountsDto> getUserAccounts(){
		

		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long userId = null;
		
		if(auth instanceof UserDto){
			userId = ((UserDto)auth).getUserId();
		}

		if(userId == null){
			//throw exception 
		}
				
		List<Accounts> accountsList =  this.userDao.findByUserId(userId);
		List<AccountsDto> accountsDtoList = accountsList.stream().map(accounts -> new AccountsDto(accounts.getAccountId(),
				accounts.getBalance(),accounts.getAccountType())).collect(Collectors.toList());

		return accountsDtoList;
		
		
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user  = this.userDao.findByUserName(username);
		
		if (user == null) {
            throw new UsernameNotFoundException("Username was not found: " + username);
        }

		UserDto userDto = new UserDto(user.getUserId(), user.getUserName(), user.getPassword());
        return userDto;
				
	}
	

}
