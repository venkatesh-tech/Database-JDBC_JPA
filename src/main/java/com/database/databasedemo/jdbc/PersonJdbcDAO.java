package com.database.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import com.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDAO {

	@Autowired
	JdbcTemplate jdbcTemplate; // Spring uses jdbc template to connect to database

	// select * from person;
	@SuppressWarnings("unchecked")
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
	}

	@SuppressWarnings("deprecation")
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}
}
