package com.sms.payload.entry;

import java.sql.Date;

public class QualifyingExams {
	
	private String rollNo;
	
	private String sslcSchoolName;
	
	private Double sslcPercentage;
	
	private Date sslcCompleted;
	
	private Boolean isHsc;
	
	private String hscSchoolName;
	
	private Double higherSecPercentage;
	
	private Date hscCompleted;
	
	private Boolean isDiploma;
	
	private String diplomaCollege;
	
	private Double diplomaPercentage;
	
	private Date diplomaCompleted;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getSslcSchoolName() {
		return sslcSchoolName;
	}

	public void setSslcSchoolName(String sslcSchoolName) {
		this.sslcSchoolName = sslcSchoolName;
	}

	public Double getSslcPercentage() {
		return sslcPercentage;
	}

	public void setSslcPercentage(Double sslcPercentage) {
		this.sslcPercentage = sslcPercentage;
	}

	public Date getSslcCompleted() {
		return sslcCompleted;
	}

	public void setSslcCompleted(Date sslcCompleted) {
		this.sslcCompleted = sslcCompleted;
	}

	public Boolean getIsHsc() {
		return isHsc;
	}

	public void setIsHsc(Boolean isHsc) {
		this.isHsc = isHsc;
	}

	public String getHscSchoolName() {
		return hscSchoolName;
	}

	public void setHscSchoolName(String hscSchoolName) {
		this.hscSchoolName = hscSchoolName;
	}

	public Double getHigherSecPercentage() {
		return higherSecPercentage;
	}

	public void setHigherSecPercentage(Double higherSecPercentage) {
		this.higherSecPercentage = higherSecPercentage;
	}

	public Date getHscCompleted() {
		return hscCompleted;
	}

	public void setHscCompleted(Date hscCompleted) {
		this.hscCompleted = hscCompleted;
	}

	public Boolean getIsDiploma() {
		return isDiploma;
	}

	public void setIsDiploma(Boolean isDiploma) {
		this.isDiploma = isDiploma;
	}

	public String getDiplomaCollege() {
		return diplomaCollege;
	}

	public void setDiplomaCollege(String diplomaCollege) {
		this.diplomaCollege = diplomaCollege;
	}

	public Double getDiplomaPercentage() {
		return diplomaPercentage;
	}

	public void setDiplomaPercentage(Double diplomaPercentage) {
		this.diplomaPercentage = diplomaPercentage;
	}

	public Date getDiplomaCompleted() {
		return diplomaCompleted;
	}

	public void setDiplomaCompleted(Date diplomaCompleted) {
		this.diplomaCompleted = diplomaCompleted;
	}
}
