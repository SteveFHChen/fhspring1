package com.fh.springibatis.repository.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import com.fh.dto.Person;
import com.fh.springibatis.repository.IPersonRepository5;
import com.ibatis.sqlmap.client.SqlMapClient;

//@Component
public class PersonRepository5Impl extends SqlMapClientDaoSupport implements
		IPersonRepository5 {

	/*@Autowired
	private DataSource ds;
	@Autowired
	private SqlMapClient sqlMapClient;
	
	@Autowired
	public void init(){
		this.setDataSource(ds);
		this.setSqlMapClient(sqlMapClient);
	}*/
	
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
