package com.database.databasedemo;

import java.sql.Date;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.database.databasedemo.entity.Person;
import com.database.databasedemo.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { // When using commandlinerunner you have to implement these
														// methods
		logger.info("All Users -> {}", dao.findAll()); // In logger the {} will be replaced by dao.findAll() value
		logger.info("UserId 10001 -> {}", dao.findById(10001));
		logger.info("UserLocation Nidadavole -> {}", dao.findByLocation("Nidadavole"));
		logger.info("Deleting 10004 -> No of rows deleted {}", dao.deleteById(10004));
		logger.info("Inserting 10005 -> No of rows inserted {}",
				dao.insert(new Person(10005, "Frank", "Chennai", new Date(0))));
		logger.info("Updating 10003 -> No of rows updated {}",
				dao.update(new Person(10005, "Peter", "Hyderabad", new Date(0))));

	}

}
