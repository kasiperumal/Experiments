package com.kasi.sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest3 {

	public static void main(String[] args) throws IOException {
		Function<String, Stream<String>> stringToWords = line -> Pattern.compile(" ").splitAsStream(line);
		Stream<String> lines = Files.lines(Paths.get("src/com/kasi/sample", "StreamTest2.java"));
		lines.flatMap(stringToWords).forEach(System.out::println);
		
		
	}

}
