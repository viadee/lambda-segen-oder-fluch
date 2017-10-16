package de.viadee.lambda.codeexamples.performance;

import java.util.Arrays;
import java.util.stream.Stream;

public class Streams1 {

	public static void main(String[] args) {
		String[] stringArray = Stream.generate(
				() -> {
					return "Lorem ipsum dolor sit amet";
				})
				.limit(1000)
				.toArray(String[]::new);

		long startForEach = System.currentTimeMillis();
		repeatForEach(stringArray, 100000);
		long endForEach = System.currentTimeMillis();

		long startStream = System.currentTimeMillis();
		repeatStream(stringArray, 100000);
		long endStream = System.currentTimeMillis();

		System.out.println("Runtime ForEach: " + (endForEach - startForEach) + "ms");
		System.out.println("Runtime Stream: " + (endStream - startStream) +
				"ms");
	}

	private static void repeatStream(String[] stringArray, int times) {
		for (int i = 0; i <= times; i++) {
			findEsStream(stringArray);
		}
	}

	private static Integer findEsStream(String[] stringArray) {
		Integer count = Arrays.stream(stringArray)
				.map(String::length)
				.reduce(Integer::sum).get();
		return count;
	}

	private static void repeatForEach(String[] stringArray, int times) {
		for (int i = 0; i <= times; i++) {
			findEsForEach(stringArray);
		}

	}

	private static Integer findEsForEach(String[] stringArray) {
		Integer count = 0;
		for (String string : stringArray) {
			count = Integer.sum(count, string.length());
		}
		return count;

	}

}
