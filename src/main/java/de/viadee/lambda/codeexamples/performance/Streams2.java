package de.viadee.lambda.codeexamples.performance;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Streams2 {

	public static void main(String[] args) {
		List<Integer> ints = new Random()
				.ints(100000, 0, Integer.MAX_VALUE)
				.boxed()
				.collect(Collectors.toList());

		long startForEach = System.currentTimeMillis();
		repeatForEach(ints, 1000);
		long endForEach = System.currentTimeMillis();

		long startStream = System.currentTimeMillis();
		repeatStream(ints, 1000);
		long endStream = System.currentTimeMillis();

		int[] intArray = new Random()
				.ints(100000, 0, Integer.MAX_VALUE).toArray();
		long startIntStream = System.currentTimeMillis();
		repeatIntStream(intArray, 1000);
		long endIntStream = System.currentTimeMillis();

		System.out.println("Runtime ForEach: " + (endForEach - startForEach) + "ms");
		System.out.println("Runtime Stream: " + (endStream - startStream) + "ms");
		System.out.println("Runtime IntStream: " + (endIntStream - startIntStream) + "ms");
	}

	private static int maxForEach(List<Integer> ints) {
		int max = Integer.MIN_VALUE;
		for (Integer n : ints) {
			max = Integer.max(max, n);
		}
		return max;
	}

	private static int maxStream(List<Integer> ints) {
		return ints.stream().reduce(Integer::max).get();
	}

	private static int maxIntStream(int[] intArray) {
		return Arrays.stream(intArray).max().getAsInt();
	}

	private static void repeatIntStream(int[] intArray, int times) {
		for (int i = 0; i <= times; i++) {
			maxIntStream(intArray);
		}
	}

	private static void repeatForEach(List<Integer> ints, int times) {
		for (int i = 0; i <= times; i++) {
			maxForEach(ints);
		}
	}

	private static void repeatStream(List<Integer> ints, int times) {
		for (int i = 0; i <= times; i++) {
			maxStream(ints);
		}
	}

}
