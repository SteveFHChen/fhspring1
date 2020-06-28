package com.fh.springintegration;

import org.springframework.integration.annotation.Filter;
import org.springframework.messaging.handler.annotation.Payload;

public class TestFilter1 {

	@Filter
	public boolean check(@Payload String msg){
		System.out.println("FH Fileter check - "+this.getClass().getName()+" check: "+msg);
		if(msg.equals("2"))
			return false;
		else
			return true;
	}
}
