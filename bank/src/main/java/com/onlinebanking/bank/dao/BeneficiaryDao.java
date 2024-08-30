package com.onlinebanking.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.onlinebanking.bank.model.BeneficiaryDTO;
import com.onlinebanking.bank.model.TransactionDTO;
import com.onlinebanking.bank.model.Users;


@Repository
public class BeneficiaryDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean addBeneficiary(BeneficiaryDTO bDTO) {
		
		String sqlQuery="insert into bankdb.Beneficiary values(?,?,?,?,?,?)";
		int status=jdbcTemplate.update(sqlQuery,bDTO.getBid(),bDTO.getIfsc(),bDTO.getAccNumber(),bDTO.getBankName(),
				bDTO.getbName(),bDTO.getMaxLimit());
		if(status>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@SuppressWarnings("deprecation")
	public float checkBalance(long accNumber) {
		String sqlQuery="select balance from bankdb.Account where accNumber=?";
		float balance=0;
		try {
		balance=jdbcTemplate.queryForObject(sqlQuery,new Object[]{accNumber},
			 new RowMapper<Float>()  {
                 public Float mapRow(ResultSet rs, int rowNum) throws SQLException {
                	 return rs.getFloat("balance");
                 }
		});
		}catch (EmptyResultDataAccessException e) {
	        return 0;
	    }	
		return balance;
	}
	
	public boolean closeAccount( Users userDTO) {
		
		String sqlQuery="Delete from bankdb.User where accNumber=? and Pwd=?";
		int rows = jdbcTemplate.update(sqlQuery,new Object[]{userDTO.getAccountNumber(),userDTO.getPassword()});
		System.out.println(rows);
		if(rows>0) {
			return true;
		}
		return false;
		
	}
	
	public List<Users> adminViewUserDetails(){
		
		String sqlQuery="select * from bankdb.User";
		final List<Users> users=new ArrayList<Users>();
		try {
			
			jdbcTemplate.query(sqlQuery,
					new RowCallbackHandler() {

				public void processRow(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub

					Users user = new Users();
			    	
			    	user.setAccountNumber(rs.getLong("accNumber"));
			    	user.setUserName(rs.getString("userName"));
			    	user.setPhone(rs.getLong("phone"));
			    	user.setEmail(rs.getString("email"));
			    	users.add(user);
				}
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Users"+users);
		return users;

	}
	
	public boolean adminCloseAccount(long accNumber) {
		
		String sqlQuery="Delete from bankdb.User where accNumber=?";
		int rows = jdbcTemplate.update(sqlQuery,new Object[]{accNumber});
		System.out.println(rows);
		if(rows>0) {
			return true;
		}
		return false;
		
	}
}
