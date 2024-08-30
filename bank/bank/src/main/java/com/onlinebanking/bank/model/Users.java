package com.onlinebanking.bank.model;

import java.util.Date;

public class Users {

	private long accountNumber;
	private String userName;
	private String password;
	private long phone;
	private String email;
	private String address;
	private long aadhar;
	private Date dateOfBirth;
	private String gender;
	
	public Users(long accountNumber, String userName, String password, long phone, String email,
			String address, long aadhar, Date dateOfBirth, String gender) {
		super();
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.aadhar = aadhar;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	

	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Users [accountNumber=" + accountNumber + ", userName=" + userName + ", password="
				+ password + ", phone=" + phone + ", email=" + email + ", address=" + address + ", aadhar="
				+ aadhar + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + "]";
	}
}
