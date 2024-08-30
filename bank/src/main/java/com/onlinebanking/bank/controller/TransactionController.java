package com.onlinebanking.bank.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebanking.bank.model.TransactionDTO;
import com.onlinebanking.bank.service.BeneficiaryService;
import com.onlinebanking.bank.service.TransactionService;

@RestController
@CrossOrigin(origins = "*")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	BeneficiaryService beneficiaryService;
	
	@PostMapping("/creditAmount")
	@ResponseBody
	public String creditAmount(@RequestBody TransactionDTO creditDTO) {
		
		System.out.println("Transactions"+creditDTO);
		float balance=beneficiaryService.checkBalance(creditDTO.getAccNumber());
		System.out.println("Balance"+balance);
		boolean status=transactionService.creditAmount(creditDTO,balance);
		if(status) {
			return "Amount credited successfully";
		}
		return "";
		
	}
	
	@PostMapping("/withdrawAmount")
	@ResponseBody
	public Map<String,Object> withdrawAmount(@RequestBody TransactionDTO withdrawDTO) {
		
		System.out.println("Transactions"+withdrawDTO);
		Map<String,Object> returnVal=new HashMap<String,Object>();
		float balance=beneficiaryService.checkBalance(withdrawDTO.getAccNumber());
		System.out.println("Balance"+balance);
		String message=transactionService.withdrawAmount(withdrawDTO,balance);
		if(message=="Amount Withdrawn Successfully") {
			returnVal.put("status", true);
			returnVal.put("message", message);
		}
		else {
			returnVal.put("status", false);
			returnVal.put("message", message);
		}
		return returnVal;
	}
	
	@PostMapping("/transferAmount")
	@ResponseBody
	public Map<String,Object> transferAmount(@RequestBody TransactionDTO transferDTO) {
		
		System.out.println("Transactions"+transferDTO);
		Map<String,Object> returnVal=new HashMap<String,Object>();
		float balance=beneficiaryService.checkBalance(transferDTO.getAccNumber());
		System.out.println("Balance"+balance);
		String message=transactionService.withdrawAmount(transferDTO,balance);
		if(message=="Amount Withdrawn Successfully") {
			float targetAccountBalance=beneficiaryService.checkBalance(transferDTO.getTargetAccNumber());
			System.out.println("Target Account Balance"+targetAccountBalance);
			TransactionDTO creditDTO=new TransactionDTO();
			creditDTO.setAccNumber(transferDTO.getTargetAccNumber());
			creditDTO.setAmount(transferDTO.getAmount());
			creditDTO.setTransactionType(transferDTO.getTransactionType());
			System.out.println("CreditDTO"+creditDTO);
			boolean status=transactionService.creditAmount(creditDTO,balance);
			if(status) {
				String msg="Amount Transferred successfully";
				returnVal.put("status", true);
				returnVal.put("message", msg);
			}
			else {
				boolean status1=transactionService.creditAmount(transferDTO,balance);
				String msg="Enter valid target account number details";
				returnVal.put("status", false);
				returnVal.put("message", msg);
			}
		}
		else {
			returnVal.put("status", false);
			returnVal.put("message", message);
		}

		return returnVal;
	}
	
	@GetMapping("/viewTransactions/{accNumber}")
	@ResponseBody
	public List<TransactionDTO> viewTransactions(@PathVariable("accNumber") long accNo) {
		
		float val=0;
		List<TransactionDTO> transactions=new ArrayList<TransactionDTO>();
		System.out.println("Account Number"+accNo);
		transactions=transactionService.viewTransactions(accNo);
		return transactions;
	}
	
	@GetMapping("/adminViewTransactions")
	@ResponseBody
	public List<TransactionDTO> adminViewTransactions() {
		
		float val=0;
		List<TransactionDTO> transactions=new ArrayList<TransactionDTO>();
		transactions=transactionService.adminViewTransactions();
		return transactions;
	}
	
	

}
