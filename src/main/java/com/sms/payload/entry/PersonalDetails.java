package com.sms.payload.entry;

import java.math.BigInteger;
import java.sql.Date;

public class PersonalDetails {
	
	private String rollNo;
	
	private Date dob;
	
	private Long age;
	
	private String gender;
	
	private String modeOfAdmission;
	
	private String caste;
	
	private String community;
	
	private String bloodGroup;
	
	private BigInteger phoneNumber;
	
	private Boolean isHostel;
	
	private String hostel;
	
	private Long roomNo;
	
	private Boolean isDayScholar;
	
	private String route;
	
	private Long busNo;
	
	private BigInteger aadhaarNo;
	
	private BigInteger accountNo;
	
	private Long currentSem;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getModeOfAdmission() {
		return modeOfAdmission;
	}

	public void setModeOfAdmission(String modeOfAdmission) {
		this.modeOfAdmission = modeOfAdmission;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getIsHostel() {
		return isHostel;
	}

	public void setIsHostel(Boolean isHostel) {
		this.isHostel = isHostel;
	}

	public String getHostel() {
		return hostel;
	}

	public void setHostel(String hostel) {
		this.hostel = hostel;
	}

	public Long getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Long roomNo) {
		this.roomNo = roomNo;
	}

	public Boolean getIsDayScholar() {
		return isDayScholar;
	}

	public void setIsDayScholar(Boolean isDayScholar) {
		this.isDayScholar = isDayScholar;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Long getBusNo() {
		return busNo;
	}

	public void setBusNo(Long busNo) {
		this.busNo = busNo;
	}

	public BigInteger getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(BigInteger aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public BigInteger getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(BigInteger accountNo) {
		this.accountNo = accountNo;
	}

	public Long getCurrentSem() {
		return currentSem;
	}

	public void setCurrentSem(Long currentSem) {
		this.currentSem = currentSem;
	}

}
