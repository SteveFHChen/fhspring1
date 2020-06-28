package com.fh.springibatis.service;

import java.util.List;

import com.fh.dto.Person;

public interface IPersonService6Transaction {
	public void addPerson(Person person);
	public void deletePerson(Person person);
	public List<Person> findPersons(Person person);
	public void testTransaction(Person person);
}
