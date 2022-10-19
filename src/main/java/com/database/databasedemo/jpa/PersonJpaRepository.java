package com.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.database.databasedemo.entity.Person;

//Repository
//Transaction
@Repository
@Transactional
public class PersonJpaRepository {

	// Connect to the database
	@PersistenceContext
	EntityManager entityManager;

//	public Person findById(int id) {
//		return entityManager.find(Person.class, id);
//	}

	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("Find_All_Persons", Person.class);
		return namedQuery.getResultList();
	}

	public Person update(Person person) {
		return entityManager.merge(person);
	}

	public Person insert(Person person) {
		return entityManager.merge(person);
	}

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}

}
