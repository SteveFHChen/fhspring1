package com.fh.springbeans;

import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.NamespaceHandler;

import com.fh.springbeans.namespacehandlerresovler.FHNamespaceHandlerResolver;

public class TestApp5DefaultNamespaceHandlerResolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. Test use DefaultNamespaceHandlerResolver to load default namespace and user defined namespace in META-INF");
		DefaultNamespaceHandlerResolver hr = new DefaultNamespaceHandlerResolver();
		System.out.println("hr: "+hr);
		NamespaceHandler h1 = hr.resolve("mycustomertestnamespaceuri");
		System.out.println("handler: "+h1);
		
		System.out.println("2. Test use DefaultNamespaceHandlerResolver to load user defined namespace not in META-INF");
		DefaultNamespaceHandlerResolver hr2 = new DefaultNamespaceHandlerResolver(null, "springbeans/mycustomertestnamespace.handlers");
		System.out.println("hr2: "+hr2);
		
		System.out.println("3. Test use DefaultNamespaceHandlerResolver to load user defined namespace and default namespace in META-INF");
		FHNamespaceHandlerResolver hr3 = new FHNamespaceHandlerResolver(null, new String[]{"springbeans/mycustomertestnamespace.handlers","META-INF/spring.handlers"});
		System.out.println("hr3: "+hr3);
	}

}
