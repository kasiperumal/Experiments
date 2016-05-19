package com.kasi.test.CucumberJava;

import java.util.concurrent.TimeUnit;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
    Belly belly = new Belly();
    
    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        belly.eat(cukes);
    }
    
    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int arg1) throws Throwable {
    	Thread.sleep(1000);
    }

    @Then("^my belly should growl$")
    public void my_belly_should_growl() throws Throwable {
    	belly.growl();
    }

}
