package com.fh.forjunit;

public class Activity {
	
	private UserManager userManager = new UserManager();
	
	public void login(){
		String userName = "";//get from page form
		String password = "";// get from page form
		userManager.performLogin(userName, password);
	}
}
