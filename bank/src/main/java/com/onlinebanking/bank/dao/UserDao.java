package com.onlinebanking.bank.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.onlinebanking.bank.model.Users;

@Repository
public class UserDao {
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource =new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		 dataSource.setUrl("jdbc:mysql://localhost/OnlineBanking");
//		 dataSource.setUsername("root");
//		 dataSource.setPassword("Venky@454");
//		 return dataSource;
//	}
	@Autowired
	JdbcTemplate template;
	public String registerUser(Users a) {
		String sqlQuery="insert into Users values(?,?,?,?,?,?,?,?,?)";
		return template.update(sqlQuery,a.getAccountNumber(),a.getUserName(),a.getPassword(),a.getPhone(),a.getEmail(),a.getAddress(),a.getAadhar(),a.getDateOfBirth(),a.getGender())+" record inserted successfully";
	}
}

