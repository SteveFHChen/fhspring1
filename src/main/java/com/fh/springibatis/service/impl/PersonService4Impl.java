package com.fh.springibatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fh.dto.Person;
import com.fh.springibatis.repository.IPersonRepository4;
import com.fh.springibatis.service.IPersonService4;

@Component
public class PersonService4Impl implements IPersonService4 {

	@Autowired
	private IPersonRepository4 personRepository4;

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		this.personRepository4.addPerson(person);
		System.out.println("Add person "+person);
	}

	@Override
	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		this.personRepository4.deletePerson(person);
	}

	@Override
	public List<Person> findPersons(Person person) {
		// TODO Auto-generated method stub
		return this.personRepository4.findPersons(person);
	}

	/*public IPersonRepository4 getPersonRepository4() {
		return personRepository4;
	}

	public void setPersonRepository4(IPersonRepository4 personRepository4) {
		this.personRepository4 = personRepository4;
	}*/
	
}
