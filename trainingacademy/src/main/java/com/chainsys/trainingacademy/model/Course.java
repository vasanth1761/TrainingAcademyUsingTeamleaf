package com.chainsys.trainingacademy.model;

import java.sql.Blob;

import org.springframework.web.multipart.MultipartFile;

public class Course {
	int courseId;
	String courseName;
	String courseType;
	byte[] courseImage;
	int amount;
	String image;
	public void setCourseImage(byte[] courseImage ) {
		this.courseImage = courseImage;
		}
	
	public Course(int courseId, String courseName, String courseType, byte[] courseImage, int amount, String image) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseType = courseType;
		this.courseImage = courseImage;
		this.amount = amount;
		this.image = image;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public Course(int courseId, String courseName, String courseType, byte[] courseImage,int amount) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseType = courseType;
		this.courseImage = courseImage;
		this.amount=amount;
	}
	public Course() {
	}
	
	public byte[] getCourseImage() {
		return courseImage;
	}
	
	
}