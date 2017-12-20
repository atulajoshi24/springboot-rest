package com.atul.service;

import java.util.List;

import com.atul.dto.AccountsDto;
import com.atul.persistent.model.User;

public interface UserService {
	
	public void saveUser(User user);
	public User getUserByUserName(String userName);
	public List<AccountsDto> getUserAccounts();

}
