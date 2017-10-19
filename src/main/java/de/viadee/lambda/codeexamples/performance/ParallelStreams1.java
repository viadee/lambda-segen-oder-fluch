package de.viadee.lambda.codeexamples.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ParallelStreams1 {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>(generateRandomIntegers());
		LinkedList<Integer> linkedList = new LinkedList<>(generateRandomIntegers());

		System.out.println("ArrayList parallel: " + averageSummationTimeParallel(arrayList) +
				"ms");
		System.out.println("LinkedList parallel: " + averageSummationTimeParallel(linkedList) +
				"ms");
		System.out.println("ArrayList sequential: " + averageSummationTimeSequential(arrayList) +
				"ms");
		System.out.println("LinkedList sequential: " + averageSummationTimeSequential(linkedList) +
				"ms");
	}

	private static long sumParallel(List<Integer> list) {
		long start = System.currentTimeMillis();
		list.parallelStream()
				.mapToInt(Integer::intValue)
				.sum();
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static long sumSequential(List<Integer> list) {
		long start = System.currentTimeMillis();
		list.stream()
				.mapToInt(Integer::intValue)
				.sum();
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static double averageSummationTimeParallel(List<Integer> list) {
		return LongStream.range(0, 10).map(i -> sumParallel(list)).average().getAsDouble();
	}

	private static double averageSummationTimeSequential(List<Integer> list) {
		return LongStream.range(0, 10).map(i -> sumSequential(list)).average().getAsDouble();
	}

	private static List<Integer> generateRandomIntegers() {
		Random random = new Random();
		List<Integer> randomIntegers = IntStream
				.range(1, 9999999)
				.map(random::nextInt)
				.boxed()
				.collect(Collectors.toList());
		return randomIntegers;
	}

}
