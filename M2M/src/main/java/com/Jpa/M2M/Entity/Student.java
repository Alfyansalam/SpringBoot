package com.Jpa.M2M.Entity;

import javax.persistence.CascadeType;

import java.util.Set;

import javax.persistence.*;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="student_tbl")
public class Student {
	@Id
	@GeneratedValue
private long id;
private int age;
private String department;
private String name;


@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
@JoinTable(name="student_course",
joinColumns = {
        @JoinColumn(name="student_id",referencedColumnName="id"
                    )},
inverseJoinColumns = {
        @JoinColumn(name="course_id",referencedColumnName="id"
                )})
@JsonManagedReference
private Set<Course>courses;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String grade) {
	this.department = department;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


}
