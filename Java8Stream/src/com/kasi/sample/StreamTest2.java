package com.kasi.sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) throws IOException {
		String text = "here comes and here goes";
		Stream<String> words = Pattern.compile(" ").splitAsStream(text);
		words.distinct().forEach(System.out::println);
		
		Stream<String> lines = Files.lines(Paths.get("src/com/kasi/sample","StreamTest1.java"));
		LocalTime beforeTime = LocalTime.now();
		lines.filter(s->s.contains("Time"))
			.forEach(s-> System.out.println("Line: " + s + ", Length: "+ s.length()));
		LocalTime afterTime = LocalTime.now();
		System.out.println("Timetaken:" + ChronoUnit.MILLIS.between(beforeTime, afterTime));

	}

}
