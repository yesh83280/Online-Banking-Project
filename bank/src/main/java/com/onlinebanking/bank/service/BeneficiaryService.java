package com.onlinebanking.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebanking.bank.dao.BeneficiaryDao;
import com.onlinebanking.bank.model.BeneficiaryDTO;
import com.onlinebanking.bank.model.Users;

@Service
public class BeneficiaryService {
	
	@Autowired
	BeneficiaryDao beneficiaryDao;
	
	public boolean addBeneficiary(BeneficiaryDTO bDTO) {
		return beneficiaryDao.addBeneficiary(bDTO);
	}
	
	public float checkBalance(long accNumber) {
		return beneficiaryDao.checkBalance(accNumber);
	}
	
	public boolean closeAccount( Users userDTO) {
		return beneficiaryDao.closeAccount(userDTO);
	}
	
	public List<Users> adminViewUserDetails(){
		return beneficiaryDao.adminViewUserDetails();
	}
	
	public boolean adminCloseAccount(long accNumber) {
		return beneficiaryDao.adminCloseAccount(accNumber);
	}
}
