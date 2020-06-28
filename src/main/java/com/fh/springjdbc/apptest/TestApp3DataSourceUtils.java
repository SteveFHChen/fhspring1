package com.fh.springjdbc.apptest;

import java.sql.Connection;

import javax.sql.DataSource;

import oracle.jdbc.driver.OracleDriver;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestApp3DataSourceUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestApp3DataSourceUtils app1 = new TestApp3DataSourceUtils();
		DataSource ds = app1.newDataSource();
		
		Connection con = DataSourceUtils.getConnection(ds);
	}
	
	private DataSource newDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(OracleDriver.class.getName());
		ds.setUrl("jdbc:oracle:thin:@192.168.2.11:1522:prod");
		ds.setUsername("mydev1");
		ds.setPassword("oracle1");
//		this.ds = ds;
		return ds;
	}

}
