package com.onlinebanking.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebanking.bank.dao.BeneficiaryDao;
import com.onlinebanking.bank.model.BeneficiaryDTO;
import com.onlinebanking.bank.model.Users;
import com.onlinebanking.bank.service.BeneficiaryService;

@RestController
@CrossOrigin(origins = "*")
public class BeneficiaryController {
	
	@Autowired
	BeneficiaryService beneficiaryService;
	
	@PostMapping("/addBeneficiary")
	@ResponseBody
	public String addBeneficiary(@RequestBody BeneficiaryDTO bDTO) {
		
		System.out.println("Beneficiary"+bDTO);
		boolean status=beneficiaryService.addBeneficiary(bDTO);
		if(status) {
			return "Beneficiary added successfully";
		}
		else {
			return "";
		}
	}
	
	@PostMapping("/viewBeneficiary")
	@ResponseBody
	public BeneficiaryDTO viewBeneficiary(@RequestBody long accNo) {
		
		BeneficiaryDTO bto=new BeneficiaryDTO();
		System.out.println("Account Number"+accNo);
		
		return bto;
	}
	
	@GetMapping("/checkBalance/{accNumber}")
	@ResponseBody
	public float checkBalance(@PathVariable("accNumber") long accNo) {
		
		float val=0;
		System.out.println("Account Number"+accNo);
		val=beneficiaryService.checkBalance(accNo);
		return val;
	}
	
	@PostMapping("/closeAccount")
	@ResponseBody
	public boolean closeAccount(@RequestBody Users userDTO) {
		
		System.out.println("User Details"+userDTO);
		boolean status=beneficiaryService.closeAccount(userDTO);
		if(status) {
			return true;
		}
		return false;
	}
	
	@GetMapping("/adminViewUserDetails")
	@ResponseBody
	public List<Users> adminViewUserDetails() {
		
		float val=0;
		List<Users> users=new ArrayList<Users>();
		users=beneficiaryService.adminViewUserDetails();
		return users;
	}
	
	@GetMapping("/adminCloseAccount/{accNumber}")
	@ResponseBody
	public boolean adminCloseAccount(@PathVariable("accNumber") long accNo) {
		
		float val=0;
		System.out.println("Account Number"+accNo);
		val=beneficiaryService.checkBalance(accNo);
		System.out.println("Balance"+val);
		if(val<=0) {
			System.out.println("Balance"+val);
			boolean status=beneficiaryService.adminCloseAccount(accNo);
			if(status) {
				return true;
			}
			return false;
		}
		return false;
	}
	
}
