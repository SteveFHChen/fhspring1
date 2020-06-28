package com.fh.springintegration;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

public class FHChannelInterceptor1 implements ChannelInterceptor {

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		// TODO Auto-generated method stub
		System.out.println("Call "+this.getClass().getName()+"-preSend().");
		return message;
	}

	@Override
	public void postSend(Message<?> message, MessageChannel channel,
			boolean sent) {
		// TODO Auto-generated method stub
		System.out.println("Call "+this.getClass().getName()+"-postSend().");
	}

	@Override
	public void afterSendCompletion(Message<?> message, MessageChannel channel,
			boolean sent, Exception ex) {
		// TODO Auto-generated method stub
		System.out.println("Call "+this.getClass().getName()+"-afterSendCompletion()======<<<<<.");
	}

	@Override
	public boolean preReceive(MessageChannel channel) {
		// TODO Auto-generated method stub
		System.out.println("Call "+this.getClass().getName()+"-preReceive().");
		return false;
	}

	@Override
	public Message<?> postReceive(Message<?> message, MessageChannel channel) {
		// TODO Auto-generated method stub
		System.out.println("Call "+this.getClass().getName()+"-postReceive().");
		return message;
	}

	@Override
	public void afterReceiveCompletion(Message<?> message,
			MessageChannel channel, Exception ex) {
		// TODO Auto-generated method stub
		System.out.println("Call "+this.getClass().getName()+"-afterReceiveCompletion().======<<<<<");
	}

}
