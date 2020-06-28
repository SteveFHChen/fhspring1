package com.fh.springjdbc.service;

import java.util.List;

import com.fh.dto.Person;

public interface IPersonService2 {
	public void addPerson(Person person);
	public void deletePerson(Person person);
	public List<Person> findPersons(Person person);
}
