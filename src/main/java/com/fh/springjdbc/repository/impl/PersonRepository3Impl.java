package com.fh.springjdbc.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.fh.dto.Person;
import com.fh.springjdbc.repository.IPersonRepository3;

@Component
public class PersonRepository3Impl extends JdbcDaoSupport implements
		IPersonRepository3 {

	/**
	 * Inherit JdbcDaoSupport to get JdbcTemplate.
	 */
	
	@Autowired
	private DataSource ds;
	
	/**
	 * After compared, I found the initDao() is later than the @PostConstruct.
	 */
	@PostConstruct
    private void initialize() {
		System.out.println(this.getClass().getName()+"-initialize().");
        setDataSource(ds);
    }
	
	@Override
	protected void initDao() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+"-initDao().");
//		this.setDataSource(ds);
	}

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		String sql = "insert into t1(id, name) values(?, ?)";
		int n = this.getJdbcTemplate().update(sql, person.getId(), person.getName());
		System.out.println("Insert "+n+" records success.");
	}

	@Override
	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Person> findPersons(Person person) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+"-findPerson().");
		String sql = "select * from t1 where 1=1";
		
//		List<Person> persons = this.jdbcTemplate.queryForList(sql, new Object[]{}, Person.class);
		
		List<Map<String, Object>> result = this.getJdbcTemplate().queryForList(sql, new Object[]{});
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
