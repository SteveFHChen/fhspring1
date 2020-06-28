package com.fh.springjdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fh.dto.Person;
import com.fh.springjdbc.repository.IPersonRepository2;
import com.fh.springjdbc.repository.IPersonRepository3;
import com.fh.springjdbc.service.IPersonService2;

@Component
public class PersonService2Impl implements IPersonService2 {

	@Autowired
	private IPersonRepository2 personRepository2;
	
	@Autowired
	private IPersonRepository3 personRepository3;
	
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
//		this.personRepository2.addPerson(person);
		this.personRepository3.addPerson(person);
	}

//	public void deletePerson(Person person) {
//		// TODO Auto-generated method stub
//		this.personRepository.deletePerson(person);
//	}
	
	public List<Person> findPersons(Person person) {
		// TODO Auto-generated method stub
		return this.personRepository2.findPersons(person);
	}

	@Override
	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		this.personRepository2.deletePerson(person);
	}

}
