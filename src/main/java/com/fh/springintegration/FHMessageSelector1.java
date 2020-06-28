package com.fh.springintegration;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class FHMessageSelector1 implements MessageSelector {

	@Override
	public boolean accept(Message<?> message) {
		// TODO Auto-generated method stub
		System.out.println("FH Fileter check - "+this.getClass().getName()+" check: "+message);
		String msg = (String) message.getPayload();
		if(msg.equals("FH message 2"))
			return false;
		else
			return true;
	}

}
