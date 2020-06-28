package com.fh.springibatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dto.Person;
import com.fh.springibatis.repository.IPersonRepository6Transaction;
import com.fh.springibatis.service.IPersonService6Transaction;

@Component
public class PersonService6TransactionImpl implements IPersonService6Transaction {

	@Autowired
	private IPersonRepository6Transaction personRepository6;

//	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class,timeout=1,isolation=Isolation.DEFAULT, readOnly=true)
	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
//		if(person.getName().equalsIgnoreCase("Lily522"))
//			throw new RuntimeException("My Test for transaction.");
		this.personRepository6.addPerson(person);
		System.out.println("Add person "+person);
	}

	@Override
	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		this.personRepository6.deletePerson(person);
	}

	@Override
	public List<Person> findPersons(Person person) {
		// TODO Auto-generated method stub
		return this.personRepository6.findPersons(person);
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,timeout=1,isolation=Isolation.DEFAULT)
	@Override
	public void testTransaction(Person person) {
		// TODO Auto-generated method stub
		
		this.addPerson(person);
		person.setName(person.getName()+"2");
		this.addPerson(person);
		throw new RuntimeException("My Test for transaction.");
	}

}
