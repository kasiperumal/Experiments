package com.kasi.sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("one", "two", "three");
		list.stream()
			.map(s -> s.toUpperCase())
			.filter(s -> s.length() < 10)
			.max(Comparator.comparing(s -> s.length()))
			.ifPresent(s -> System.out.println(s));

	}

}
