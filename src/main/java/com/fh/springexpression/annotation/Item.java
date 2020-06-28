package com.fh.springexpression.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("itemBean")
public class Item {

    @Value("itemA")//直接注入String
    private String name;
    
    @Value("10")//直接注入integer
    private int total;
    
    public String getInfo(){
    	return this.name+"_"+this.total;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}