package com.sms.payload.entry;

import java.math.BigInteger;

public class Contact {
	
	private String rollNo;
	
	private Boolean isGaurdian;
	
	private String gaurdianType;
	
	private String fatherName;
	
	private String fatherOccup;
	
	private BigInteger fatherIncome;
	
	private BigInteger fatherPh; 
	
	private String motherName;
	
	private String motherOccup;
	
	private BigInteger motherIncome;
	
	private BigInteger motherPh;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Boolean getIsGaurdian() {
		return isGaurdian;
	}

	public void setIsGaurdian(Boolean isGaurdian) {
		this.isGaurdian = isGaurdian;
	}

	public String getGaurdianType() {
		return gaurdianType;
	}

	public void setGaurdianType(String gaurdianType) {
		this.gaurdianType = gaurdianType;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherOccup() {
		return fatherOccup;
	}

	public void setFatherOccup(String fatherOccup) {
		this.fatherOccup = fatherOccup;
	}

	public BigInteger getFatherIncome() {
		return fatherIncome;
	}

	public void setFatherIncome(BigInteger fatherIncome) {
		this.fatherIncome = fatherIncome;
	}

	public BigInteger getFatherPh() {
		return fatherPh;
	}

	public void setFatherPh(BigInteger fatherPh) {
		this.fatherPh = fatherPh;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherOccup() {
		return motherOccup;
	}

	public void setMotherOccup(String motherOccup) {
		this.motherOccup = motherOccup;
	}

	public BigInteger getMotherIncome() {
		return motherIncome;
	}

	public void setMotherIncome(BigInteger motherIncome) {
		this.motherIncome = motherIncome;
	}

	public BigInteger getMotherPh() {
		return motherPh;
	}

	public void setMotherPh(BigInteger motherPh) {
		this.motherPh = motherPh;
	}
		
}
