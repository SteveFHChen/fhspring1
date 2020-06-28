package com.fh.springibatis.repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseDao extends SqlMapClientDaoSupport{
	
	@Autowired
	private DataSource ds;
	@Autowired
	private SqlMapClient sqlMapClient;
	
	/**
	 * 3种init方式：
	 * 使用@Autowired和@PostConstruct是可以的
	 * 使用SqlMapClientDaoSupport.initDao()不可行，具体原因要看spring Ioc的先后顺序
	 */
	@Autowired
	public void init(){
		this.setDataSource(ds);
		this.setSqlMapClient(sqlMapClient);
	}
    
	@PostConstruct
    public void initSqlMapClient(){
//    	super.setSqlMapClient(sqlMapClient);
    	this.setDataSource(ds);
		this.setSqlMapClient(sqlMapClient);
    }

	@Override
	protected void initDao() throws Exception {
		// TODO Auto-generated method stub
		super.initDao();
		System.out.println("User implements DaoSupport-initDao();");
	} 
}