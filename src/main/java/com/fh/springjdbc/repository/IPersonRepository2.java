package com.fh.springjdbc.repository;

import java.util.List;
import java.util.Map;

import com.fh.dto.Person;

public interface IPersonRepository2 {

	public void addPerson(Person person);
	public void deletePerson(Person person);
	public List<Person> findPersons(Person person);
	public List<Person> map2Person(List<Map<String, Object>> list);
}
