package com.fh.springibatis.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dto.Person;
import com.fh.springibatis.repository.BaseDao;
import com.fh.springibatis.repository.IPersonRepository6Transaction;

@Component
public class PersonRepository6TransactionImpl extends BaseDao implements
		IPersonRepository6Transaction {

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		this.getSqlMapClientTemplate().insert("insertPerson1", person);
	}

	@Override
	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		System.out.println("Delete person "+person);
		int rows=this.getSqlMapClientTemplate().delete("deletePerson1", person);
		System.out.println("Deleted "+rows+" rows.");
	}

	@Override
	public List<Person> findPersons(Person person) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("fhq1", null);
	}

	@Override
	public List<Person> map2Person(List<Map<String, Object>> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
