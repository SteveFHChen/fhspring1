package com.fh.javatest.property;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class TestGetProperty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties pros = System.getProperties();
		Map env = System.getenv();
		
		System.out.println("Output system properties:");
		Enumeration e = pros.propertyNames();
		while(e.hasMoreElements()){
			String k = (String) e.nextElement();
			System.out.println(k + " -> "+pros.getProperty(k));
		}
		
		System.out.println("\n\nOutput environment properties:");
		Set envs = env.entrySet();
		Iterator it = envs.iterator();
		while(it.hasNext()){
			Entry entry = (Entry) it.next();
			System.out.println(entry.getKey() + " +> "+entry.getValue());
		}
	}

}
