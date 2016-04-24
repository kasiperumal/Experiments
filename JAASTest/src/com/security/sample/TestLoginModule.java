package com.security.sample;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class TestLoginModule implements LoginModule {
	public static final String TEST_USERNAME = "test";
	public static final String TEST_PASSWORD = "test";
	private CallbackHandler callbackHandler = null;
	private boolean authSucess = false;

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {
		this.callbackHandler = callbackHandler;

	}

	@Override
	public boolean login() throws LoginException {
		Callback[] callbacks = new Callback[2];
		callbacks[0] = new NameCallback("User name:");
		callbacks[1] = new PasswordCallback("Password:", false);
		try {
			callbackHandler.handle(callbacks);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedCallbackException e) {
			e.printStackTrace();
		}
		String name = ((NameCallback)callbacks[0]).getName();
		String password = new String(((PasswordCallback)callbacks[1]).getPassword());
		if(name.equals(TEST_USERNAME) && password.equals(TEST_PASSWORD)) {
			System.out.println("Authentication Success...");
			authSucess = true;
		} else {
			authSucess = false;
			throw new FailedLoginException("Authentication failure");
		}
		return authSucess;
	}

	@Override
	public boolean commit() throws LoginException {
		return authSucess;
	}

	@Override
	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

}
