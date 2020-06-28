package com.fh.springcore.io.support;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class TestPropertiesLoaderUtils {

	public static void main(String[] args){
		System.out.println("1.Use JDK Propertis to load properties:");
		Properties prop = new Properties();
	      // add some properties
	      prop.put("Height", "200");
	      prop.put("Width", "15");

	      try {

	         // create a output and input as a xml file
	         FileOutputStream fos = new FileOutputStream("properties.xml");
	         FileInputStream fis = new FileInputStream("properties.xml");

	         // store the properties in the specific xml
	         prop.storeToXML(fos, null);

	         // load from the xml that we saved earlier
	         prop.loadFromXML(fis);

	         // print the properties list
	         prop.list(System.out);
	         
	         fis.close();
	         fos.close();

	      } catch (IOException ex) {
	         ex.printStackTrace();
	      } finally{
	    	  
	      }
	      
	    System.out.println("2. Use Spring PropertiesLoaderUtils to load properties:");
	    try {
	    	System.out.println(TestPropertiesLoaderUtils.class.getClassLoader().getResource(""));
			Properties prop2 = PropertiesLoaderUtils.loadAllProperties("springcontext/testapp1.properties", null /*TestPropertiesLoaderUtils.class.getClassLoader()*/);
			prop2.list(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    System.out.println("3. Use Spring PropertiesLoaderUtils to load properties, including in all the jars:");
	    try {
	    	System.out.println(TestPropertiesLoaderUtils.class.getClassLoader().getResource(""));
			Properties prop2 = PropertiesLoaderUtils.loadAllProperties("META-INF/spring.handlers", null /*TestPropertiesLoaderUtils.class.getClassLoader()*/);
			prop2.list(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
