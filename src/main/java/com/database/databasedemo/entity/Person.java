package com.database.databasedemo.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
//@Table(name = "Person") //No need to specify beacuse of same table and class names
public class Person {

	@Id
	@GeneratedValue
	private int id;

//	@Column(name = "name") // no need to specify beacuse of same column name 
	private String name;
	private String location;
	private Date birthDate;

	public Person() { // This is constructed for BeanPropertyRowMapper because it requires a no-arg
						// constructor
	}

	public Person(int id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public Person(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}

}
