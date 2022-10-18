package com.database.databasedemo.jdbc;

import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import com.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDAO {

	@Autowired
	JdbcTemplate jdbcTemplate; // Spring uses jdbc template to connect to database

	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getDate("birth_date"));

			return person;
		}

	}

	// select * from person;
	@SuppressWarnings("unchecked")
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?",
				new BeanPropertyRowMapper<Person>(Person.class), new Object[] { id }); // id can also be place directly
																						// in place of new Object[]{id}
	}

	public Person findByLocation(String location) {
		return jdbcTemplate.queryForObject("select * from person where location=?",
				new BeanPropertyRowMapper<Person>(Person.class), location);
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] { id });// Update doesn't require
																							// mapper and delete returns
																							// Integer value for no of
																							// rows affected
	}

	public int insert(Person person) {
		return jdbcTemplate.update("insert into person values(?,?,?,?);", new Object[] { person.getId(),
				person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()) });

	}

	public int update(Person person) {
		return jdbcTemplate.update("update person set name=?,location=?,birth_date=? where id=?;",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
						person.getId() });

	}
}
