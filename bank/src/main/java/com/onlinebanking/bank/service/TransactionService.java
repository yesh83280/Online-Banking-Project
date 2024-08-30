package com.onlinebanking.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebanking.bank.dao.TransactionDao;
import com.onlinebanking.bank.model.TransactionDTO;

@Service
public class TransactionService {
	
	@Autowired
	TransactionDao transactionDAO;
	
	public boolean creditAmount(TransactionDTO creditDTO,float balance) {
	
		return transactionDAO.creditAmount(creditDTO,balance);
	}

	public String withdrawAmount(TransactionDTO withdrawDTO,float balance) {
		return transactionDAO.withdrawAmount(withdrawDTO,balance);
	}
	
	public boolean transferAmount(TransactionDTO transferDTO) {
		return transactionDAO.transferAmount(transferDTO);
	}
	
	public List<TransactionDTO> viewTransactions(long accNumber){
		return transactionDAO.viewTransactions(accNumber);
	}
	
	public List<TransactionDTO> adminViewTransactions() {
		return transactionDAO.adminViewTransactions();
	}
}
