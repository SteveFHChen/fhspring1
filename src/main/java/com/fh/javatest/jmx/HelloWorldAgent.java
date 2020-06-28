package com.fh.javatest.jmx;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

public class HelloWorldAgent {

	public static void main(String[] args) throws MalformedObjectNameException,
			NullPointerException, InstanceAlreadyExistsException,
			MBeanRegistrationException, NotCompliantMBeanException, IOException {

		int rmiPort = 1099;
		String jmxServerName = "TestJMXServer";
		
		System.out.println("1. Register port:");
		// jdkfolder/bin/rmiregistry.exe 9999		
		Registry registry = LocateRegistry.createRegistry(rmiPort);

		System.out.println("2. Create MBean server:");
		MBeanServer mbs = MBeanServerFactory.createMBeanServer(jmxServerName);
		//MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		/**
		 * 两种获取MBeanServer的方式。
		 * MBeanServer mbs = MBeanServerFactory.createMBeanServer(jmxServerName);
		 * 这种方式主要用于JDK1.5以前
		 * MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		 * 这种方式是JDK1.5引入的。
		 */
	
		/*HtmlAdaptorServer adapter = new HtmlAdaptorServer();
		ObjectName adapterName;
		adapterName = new ObjectName(jmxServerName + ":name=" + "htmladapter");
		adapter.setPort(8082);
		adapter.start();
		mbs.registerMBean(adapter, adapterName);*/

		
		System.out.println("3. Start testing static MBean:");
		ObjectName objName = new ObjectName(jmxServerName + ":name=" + "HelloWorld");
		System.out.println(objName+" doMain: "+objName.getDomain());
		System.out.println(objName+" key property of name: "+objName.getKeyProperty("name"));
		
		if(!mbs.isRegistered(objName)){
			System.out.println(objName+" isn't registered, registering now...");
			mbs.registerMBean(new HelloWorld(), objName);
		}else
			System.out.println(objName+" has been registered.");
		
		try {
			//Check info of a MBean with object name.
			MBeanInfo mbi = mbs.getMBeanInfo(objName);
			System.out.println("MBeanInfo: "+mbi);
			
			mbs.invoke(objName, "printHello", new Object[]{"Lucy"},	 new String[] {"java.lang.String"});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * Dynamic MBean
		 */
		System.out.println("4. Start testing dynamic MBean:");
		ObjectName name = new ObjectName("agent:name=test");
        DynamicHello dynamicHello = new DynamicHello();
        if(!mbs.isRegistered(name)){
        	mbs.registerMBean(dynamicHello, name);
        }
        
        try {
			mbs.invoke(name, "printName", null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

        System.out.println("5. Export server:");
		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + rmiPort + "/" + jmxServerName);
		System.out.println("JMXServiceURL: " + url.toString());
		JMXConnectorServer jmxConnServer = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
		jmxConnServer.start();

	}
}