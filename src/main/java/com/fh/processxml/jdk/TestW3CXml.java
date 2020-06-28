package com.fh.processxml.jdk;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestW3CXml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			File file = new File(TestW3CXml.class.getClassLoader().getResource("springcontext/TestApp1.xml").getFile());
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			NodeList nl = root.getChildNodes();
			for (int i = 0; i < nl.getLength(); i++) {
				Node node = nl.item(i);
				System.out.println("Node:"+node);
				if (node instanceof Element) {
					Element ele = (Element) node;
					System.out.println("Element:"+ele);
					/*if (delegate.isDefaultNamespace(ele)) {
						parseDefaultElement(ele, delegate);
					}
					else {
						delegate.parseCustomElement(ele);*/
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
