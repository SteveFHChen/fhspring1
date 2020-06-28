package com.fh.springintegration;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class FHServiceActivator1 {

	@ServiceActivator
	public Message handler(Message msg){
		System.out.println("BBBBB: Serivce Activator process message: "+msg.getPayload());
		Message msg1 = MessageBuilder.withPayload(msg.getPayload()+"p").build();
		return msg1;
	}
}
