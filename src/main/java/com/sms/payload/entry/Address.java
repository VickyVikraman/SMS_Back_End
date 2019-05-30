package com.sms.payload.entry;

import java.math.BigInteger;

public class Address {
	
	private String rollNo;
	
	private String nativePlace;
	
	private String permanentAdd;
	
	private String city;
	
	private String state;
	
	private BigInteger zip;
	
	private Boolean isComSameAsPerm;
	
	private String communicationAdd;
	
	private String ccity;
	
	private String cstate;
	
	private BigInteger czip;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getPermanentAdd() {
		return permanentAdd;
	}

	public void setPermanentAdd(String permanentAdd) {
		this.permanentAdd = permanentAdd;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigInteger getZip() {
		return zip;
	}

	public void setZip(BigInteger zip) {
		this.zip = zip;
	}

	public Boolean getIsComSameAsPerm() {
		return isComSameAsPerm;
	}

	public void setIsComSameAsPerm(Boolean isComSameAsPerm) {
		this.isComSameAsPerm = isComSameAsPerm;
	}

	public String getCommunicationAdd() {
		return communicationAdd;
	}

	public void setCommunicationAdd(String communicationAdd) {
		this.communicationAdd = communicationAdd;
	}

	public String getCcity() {
		return ccity;
	}

	public void setCcity(String ccity) {
		this.ccity = ccity;
	}

	public String getCstate() {
		return cstate;
	}

	public void setCstate(String cstate) {
		this.cstate = cstate;
	}

	public BigInteger getCzip() {
		return czip;
	}

	public void setCzip(BigInteger czip) {
		this.czip = czip;
	}
	
}
