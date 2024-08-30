package com.onlinebanking.bank.service;

import org.springframework.http.HttpStatus;

import com.onlinebanking.bank.dao.UserDao;
import com.onlinebanking.bank.model.Users;

public class UserService {
	UserDao ud=new UserDao();
	public String registerUser(Users users, HttpStatus ok)
	{
		return ud.registerUser(users);
	}
}
