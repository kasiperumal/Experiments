package com.kasi.sample;

import java.security.KeyStore.Entry;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest1 {

	public static void main(String[] args) {
		Person person1 = new Person(15);
		Person person2 = new Person(15);
		Person person3 = new Person(20);
		
		List<Person> list = Arrays.asList(person1, person2, person3);
//		Map<Integer, Long> map =
		LocalTime beforeTime = LocalTime.now();
		list.stream().parallel()
			.filter(person->person.getAge() < 30)
			.collect(
				Collectors.groupingBy(
					Person::getAge,
					Collectors.counting()
					)
				)
			.forEach((k,v)->System.out.println("key:" + k + ", value:" + v));
		LocalTime afterTime = LocalTime.now();
		System.out.println("Timetaken:" + ChronoUnit.MILLIS.between(beforeTime, afterTime));
		
		Map<Integer, Long> map =
		list.stream().parallel()
			.filter(person->person.getAge() < 30)
			.collect(
				Collectors.groupingBy(
					Person::getAge,
					Collectors.counting()
					)
				);
		
		list.stream().spliterator();
		Stream.builder().;
		
		//map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

	}

}
