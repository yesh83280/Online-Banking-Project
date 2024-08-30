package com.onlinebanking.bank.controller;

import com.onlinebanking.bank.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.onlinebanking.bank.dao.UserDao;
import com.onlinebanking.bank.model.Users;

@RestController
@RequestMapping("/OnlineBanking")
public class UserController {
	UserService us=new UserService();
	@PostMapping("/registration")
	public String Account_Register(@RequestBody Users users)
	{
		System.out.println(users.getAccountNumber());
		System.out.println(users.getUserName());
		System.out.println(users.getPassword());
		System.out.println(users.getPhone());
		System.out.println(users.getEmail());
		System.out.println(users.getAddress());
		System.out.println(users.getAadhar());
		System.out.println(users.getDateOfBirth());
		System.out.println(users.getGender());
		UserService us=new UserService();
		return us.registerUser(users,HttpStatus.OK);
	}
	
	
}
