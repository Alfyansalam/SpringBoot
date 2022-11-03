package com.Jpa.M2M.Entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Courses_table")
public class Course {
@Id
@GeneratedValue
	private int id;
	private String title;
	private String Abbrevation;
	private int modules;
	private double fees;
	
	
	@ManyToMany(mappedBy="courses",fetch=FetchType.LAZY)
	
	@JsonBackReference
	private Set<Student>student;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbbrevation() {
		return Abbrevation;
	}
	public void setAbbrevation(String abbrevation) {
		Abbrevation = abbrevation;
	}
	public int getModules() {
		return modules;
	}
	public void setModules(int modules) {
		this.modules = modules;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
}
