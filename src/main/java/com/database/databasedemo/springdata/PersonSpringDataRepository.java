package com.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database.databasedemo.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {

}
