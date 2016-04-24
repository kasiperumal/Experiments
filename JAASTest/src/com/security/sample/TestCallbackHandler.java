package com.security.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class TestCallbackHandler implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		NameCallback nameCallback = null;
		PasswordCallback passwordCallback = null;
		int count = 0;
		while(count < callbacks.length) {
			if(callbacks[count] instanceof NameCallback) {
				nameCallback = (NameCallback) callbacks[count++]; 
				System.out.println(nameCallback.getPrompt());
				nameCallback.setName(new BufferedReader(new InputStreamReader(System.in)).readLine());
			} else if(callbacks[count] instanceof PasswordCallback) {
				passwordCallback = (PasswordCallback) callbacks[count++]; 
				System.out.println(passwordCallback.getPrompt());
				passwordCallback.setPassword(new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray());
			}
		}
		
	}

}
