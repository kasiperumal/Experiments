package com.security.sample;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class TestDriver {

	public static void main(String[] args) {
		System.setProperty("java.security.auth.login.config", "jass.config");
		LoginContext context = null;
		try {
			context = new LoginContext("TestJass", new TestCallbackHandler());
		} catch (LoginException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		while(true) {
			try {
				context.login();
				System.exit(0);
			} catch (LoginException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
