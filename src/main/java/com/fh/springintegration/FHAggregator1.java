package com.fh.springintegration;

import java.util.List;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class FHAggregator1 {

	@Aggregator
	public Message<String> fhAggregator1(List<Message<String>> msgList){
		System.out.println("AAAAA: FHAggregator1-fhAggregator1 is called to do aggregator.");
		System.out.println("AAAAA: Test to aggregate message 4x:");
		for(Message msg : msgList){
			System.out.println("FHAggregator1-fhAggregator1 output received message:"+msg.getPayload());
		}
		return MessageBuilder.withPayload("Hello Aggregated Message.").build();
	}
}
