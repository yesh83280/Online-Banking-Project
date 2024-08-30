package com.onlinebanking.bank.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.onlinebanking.bank.model.TransactionDTO;
import com.onlinebanking.bank.service.BeneficiaryService;

@Repository
public class TransactionDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
    public TransactionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
    	TransactionDTO transaction = new TransactionDTO();
    	
    	transaction.setTransactionId(rs.getLong("Tid"));
    	transaction.setTransactionType(rs.getString("TransactionType"));
    	transaction.setTransactionDate(rs.getDate("Tdate"));
    	transaction.setAccNumber(rs.getLong("accNumber"));

        return transaction;
    }
	
	
	
	public boolean creditAmount(TransactionDTO creditDTO,float balance) {
		

		balance+=creditDTO.getAmount();
		System.out.println("Balance"+balance);
		
		String sqlQuery1="update bankdb.Account SET balance=? where accNumber=?";
		
		int rows=jdbcTemplate.update(sqlQuery1,balance,creditDTO.getAccNumber());
		System.out.println("Rows"+rows);
		if(rows>0) {
			String sqlQuery2="insert into bankdb.Transactions (Tid,TransactionType,Tdate,accNumber,creditAmount,balance) values(?,?,?,?,?,?)";
			int status=jdbcTemplate.update(sqlQuery2,creditDTO.getTransactionId(),creditDTO.getTransactionType(),new Date(System.currentTimeMillis()),
					creditDTO.getAccNumber(),creditDTO.getAmount(),balance);
			if(status>0) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
public String withdrawAmount(TransactionDTO withdrawDTO,float balance) {
		
		
		
		if(balance==0) {
			return "Enter Valid Account Details";
		}
		
		if(balance<withdrawDTO.getAmount()) {
			return "Insufficient balance";
		}
		
		balance=balance-withdrawDTO.getAmount();
		String sqlQuery1="update bankdb.Account SET balance=? where accNumber=?";
		
		int rows=jdbcTemplate.update(sqlQuery1,balance,withdrawDTO.getAccNumber());
		
		
		if(rows>0) {
			String sqlQuery2="insert into bankdb.Transactions (Tid,TransactionType,Tdate,accNumber,debitAmount,balance) values(?,?,?,?,?,?)";
			int status=jdbcTemplate.update(sqlQuery2,withdrawDTO.getTransactionId(),withdrawDTO.getTransactionType(),new Date(System.currentTimeMillis()),
					withdrawDTO.getAccNumber(),withdrawDTO.getAmount(),balance);
			if(status>0) {
				return "Amount Withdrawn Successfully";
			}
		}
		return "Unable to withdraw amount";
	}

	public boolean transferAmount(TransactionDTO transferDTO) {
		String sqlQuery="insert into bankdb.Transactions values(?,?,?,?,)";
		int status=jdbcTemplate.update(sqlQuery,transferDTO.getTransactionId(),transferDTO.getTransactionType(),new Date(System.currentTimeMillis()),
				transferDTO.getAccNumber());
		if(status>0) {
			return true;
		}
		return false;
	}
	
	public List<TransactionDTO> viewTransactions(long accNumber){
		String sqlQuery="select * from bankdb.Transactions where accNumber=?";
		final List<TransactionDTO> transactions=new ArrayList<TransactionDTO>();
		try {
			
			jdbcTemplate.query(sqlQuery,
					new RowCallbackHandler() {

				public void processRow(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub

					TransactionDTO transaction = new TransactionDTO();
			    	
			    	transaction.setTransactionId(rs.getLong("Tid"));
			    	transaction.setTransactionType(rs.getString("TransactionType"));
			    	transaction.setTransactionDate(rs.getDate("Tdate"));
			    	transaction.setAccNumber(rs.getLong("accNumber"));
			    	transaction.setCreditAmount(rs.getLong("creditAmount"));
			    	transaction.setDebitAmount(rs.getLong("debitAmount"));
			    	transaction.setBalance(rs.getLong("balance"));
			    	transactions.add(transaction);
				}
			}, new Object[] {accNumber});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Transactions"+transactions);
		return transactions;
	}
	
	public List<TransactionDTO> adminViewTransactions() {
		String sqlQuery="select * from bankdb.Transactions";
		final List<TransactionDTO> transactions=new ArrayList<TransactionDTO>();
		try {
			
			jdbcTemplate.query(sqlQuery,
					new RowCallbackHandler() {

				public void processRow(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub

					TransactionDTO transaction = new TransactionDTO();
			    	
			    	transaction.setTid(rs.getLong("Tid"));
			    	transaction.setTransactionType(rs.getString("TransactionType"));
			    	transaction.setTransactionDate(rs.getDate("Tdate"));
			    	transaction.setAccNumber(rs.getLong("accNumber"));
//			    	transaction.setCreditAmount(rs.getLong("creditAmount"));
//			    	transaction.setDebitAmount(rs.getLong("debitAmount"));
//			    	transaction.setBalance(rs.getLong("balance"));
			    	transactions.add(transaction);
				}
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Transactions"+transactions);
		return transactions;
	}
	
	
}
