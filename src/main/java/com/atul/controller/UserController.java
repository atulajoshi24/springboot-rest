package com.atul.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atul.dto.AccountsDto;
import com.atul.dto.UserDto;
import com.atul.persistent.model.User;
import com.atul.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService; 	
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody User user){
		
		this.userService.saveUser(user);
	}
	
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public UserDto getUserDetails(@RequestParam(value="username") String userName,
            @RequestParam(value="password") String password,HttpServletRequest req){
		
		User user  = this.userService.getUserByUserName(userName);
		if(user != null && password.equals(user.getPassword())){
			UserDto userDto = new UserDto();
			userDto.setUserId(user.getUserId());
			userDto.setPassWord(user.getPassword());
			userDto.setUserName(user.getUserName());
			req.getSession().setAttribute("userId", userDto.getUserId());			
			return userDto;
		}else{
			//return emprt user object and check 
			return new UserDto();
		}
		
	}*/
	
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<AccountsDto> getAccounts(){
		
		
		return this.userService.getUserAccounts();
 
	}
	
	@RequestMapping("/user")
	public UserDto user(Principal user) {
		
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long userId = null;
		UserDto userDto = null;
		
		if(auth instanceof UserDto){
			
			userId = ((UserDto)auth).getUserId();
			String userName= ((UserDto)auth).getUserName();
			String userPassword = ((UserDto)auth).getPassWord();
			userDto = new UserDto(userId,userName,userPassword);			
			
		}

		if(userId == null){
			//throw exception 
		}
		
		return userDto;
	}
	
	
}
