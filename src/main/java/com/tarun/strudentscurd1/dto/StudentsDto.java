package com.tarun.strudentscurd1.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class StudentsDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	long mobile;
	int maths_marks;
	int science_marks;
	int english_marks;
	double percentage;
	String result;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public int getMaths_marks() {
		return maths_marks;
	}
	public void setMaths_marks(int maths_marks) {
		this.maths_marks = maths_marks;
	}
	public int getScience_marks() {
		return science_marks;
	}
	public void setScience_marks(int science_marks) {
		this.science_marks = science_marks;
	}
	public int getEnglish_marks() {
		return english_marks;
	}
	public void setEnglish_marks(int english_marks) {
		this.english_marks = english_marks;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "StudentsDto [id=" + id + ", name=" + name + ", mobile=" + mobile + ", maths_marks=" + maths_marks
				+ ", science_marks=" + science_marks + ", english_marks=" + english_marks + ", percentage=" + percentage
				+ ", result=" + result + "]";
	}

}
