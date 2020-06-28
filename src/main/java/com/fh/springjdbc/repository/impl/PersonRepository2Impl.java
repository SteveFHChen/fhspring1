package com.fh.springjdbc.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fh.dto.Person;
import com.fh.springjdbc.repository.IPersonRepository2;

@Component
public class PersonRepository2Impl implements IPersonRepository2 {

	/**
	 * Use @Autowired to inject and get JdbcTemplate
	 */
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+"-addPerson().");
		String sql = "insert into t1(id, name) values(?, ?)";
		int n = this.jdbcTemplate.update(sql, person.getId(), person.getName());
		System.out.println("Insert "+n+" records success.");
	}

	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+"-deletePerson().");
		int n = this.jdbcTemplate.update("delete from t1 where id=?", new Object[]{person.getId()});
		System.out.println("Delete "+n+" person id="+person.getId());
	}

	public List<Person> findPersons(Person person) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+"-findPerson().");
		String sql = "select * from t1 where 1=1";
		
//		List<Person> persons = this.jdbcTemplate.queryForList(sql, new Object[]{}, Person.class);
		
		List<Map<String, Object>> result = this.jdbcTemplate.queryForList(sql, new Object[]{});
		List<Person> persons = map2Person(result);
		return persons;
	}

	@Override
	public List<Person> map2Person(List<Map<String, Object>> list) {
		// TODO Auto-generated method stub
		List<Person> persons = new ArrayList<Person>();
		for(Map m : list){
			Person p = new Person();
			p.setId(Integer.parseInt((String)m.get("ID")));
			p.setName((String) m.get("NAME"));
			persons.add(p);
		}
		return persons;
	}

	
}
