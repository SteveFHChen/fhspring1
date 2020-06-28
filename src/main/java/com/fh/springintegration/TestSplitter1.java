package com.fh.springintegration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.channel.AbstractMessageChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Payload;

public class TestSplitter1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springintegration/message1.xml");
		
		for(String name: ctx.getBeanDefinitionNames()){
			System.out.println("BEAN:"+name+" CLASS:"+ctx.getBean(name).getClass().getName());
		}
		
		MessageChannel simpleChannel = (MessageChannel)ctx.getBean("simpleChannel");
		
		AbstractMessageChannel amChannel = (AbstractMessageChannel)simpleChannel;
		amChannel.addInterceptor(0, new FHChannelInterceptor1());
		
		//Test 1: send a single message
		simpleChannel.send(MessageBuilder.withPayload("Hello world.").build());
		
		//Test 2: send some messages
		TestSplitter1.buildMessage(simpleChannel);
	}

	public static void buildMessage(MessageChannel channel){
		for(int i=1; i<=5; i++){
			Message<String> msg = MessageBuilder.withPayload("FH message "+i).build();
			channel.send(msg);
		}
	}
	
	//Method 1: Configure with XML
	public List<Message<String>> fhSplitter1(@Payload final String msg){
		List<Message<String>> result = new ArrayList<Message<String>>();
		System.out.println("Try to split one message to 5 messages:");
		for(int i=1; i<=5; i++){
			Message<String> msgx = MessageBuilder.withPayload(msg + (i+5)).setHeader("testheader", ""+i).build();
			result.add(msgx);
		}
		return result;
	}
	
	//Method 2: Configure with annotation
//	@Splitter	//This annotation will be identified by <int:splitter>
	public List<Message<String>> fhSplitter2(@Payload final String msg){
		List<Message<String>> result = new ArrayList<Message<String>>();
		System.out.println("Try to split one message to 5 messages:");
		for(int i=1; i<=5; i++){
			Message<String> msgx = MessageBuilder.withPayload(msg + i).setHeader("testheader", ""+i).build();
			result.add(msgx);
		}
		return result;
	}
	
	public void normalPrint(String s){
		System.out.println("FFFFF:"+s);
	}
	
	public void exceptionPrint(String s) throws Exception{
//		throw new Exception("Exception happened "+s);
		System.out.println("DDDDD:"+s);
	}
}
