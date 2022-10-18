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

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?",
				new BeanPropertyRowMapper<Person>(Person.class), new Object[] { id }); // id can also be place directly
																						// in place of new Object[]{id}
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] { id });// Update doesn't require
																							// mapper and it returns
																							// Integer value for no of
																							// rows affected
	}

	public Person findByLocation(String location) {
		return jdbcTemplate.queryForObject("select * from person where location=?",
				new BeanPropertyRowMapper<Person>(Person.class), location);
	}
}
