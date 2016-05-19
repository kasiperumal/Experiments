package com.kasi.sample;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

public class SampleTest {

	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("Circle", "Triangle", "Rectangle");
		Observable<String> stringObservable = Observable.from(stringList);
		stringObservable.subscribe(new SimpleObserver());
	}

}
