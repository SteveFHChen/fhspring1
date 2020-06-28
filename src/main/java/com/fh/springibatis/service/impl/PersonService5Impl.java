package com.fh.springibatis.service.impl;

import java.util.List;

import com.fh.dto.Person;
import com.fh.springibatis.repository.IPersonRepository5;
import com.fh.springibatis.service.IPersonService5;

public class PersonService5Impl implements IPersonService5 {

	private IPersonRepository5 personRepository5;

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		this.personRepository5.addPerson(person);
		System.out.println("Add person "+person);
	}

	@Override
	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		this.personRepository5.deletePerson(person);
	}

	@Override
	public List<Person> findPersons(Person person) {
		// TODO Auto-generated method stub
		return this.personRepository5.findPersons(person);
	}

	public IPersonRepository5 getPersonRepository5() {
		return personRepository5;
	}

	public void setPersonRepository5(IPersonRepository5 personRepository5) {
		this.personRepository5 = personRepository5;
	}
	
}
