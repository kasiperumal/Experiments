package com.kasi.test.CucumberJava;

public class Belly {
	private int cukes = 0;
    public void eat(int cukes) {
    	this.cukes = cukes;
    }

	public void growl() {
		if(cukes > 1) {
			System.out.println("Growling Sound");
		}
	}
}
