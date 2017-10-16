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
		Random random = new Random();

		List<Integer> randomIntegers = IntStream
				.range(1, 9999999)
				.map(random::nextInt)
				.boxed()
				.collect(Collectors.toList());

		ArrayList<Integer> arrayList = new ArrayList<>(randomIntegers);
		LinkedList<Integer> linkedList = new LinkedList<>(randomIntegers);

		System.out.println("ArrayList parallel: " + averageParallel(arrayList) +
				"ms");
		System.out.println("LinkedList parallel: " + averageParallel(linkedList) +
				"ms");
		System.out.println("ArrayList sequential: " + averageSequential(arrayList) +
				"ms");
		System.out.println("LinkedList sequential: " + averageSequential(linkedList) +
				"ms");
	}

	private static long maxParallel(List<Integer> list) {
		long start = System.currentTimeMillis();
		list.parallelStream()
				.mapToInt(Integer::intValue)
				.sum();
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static long maxSequential(List<Integer> list) {
		long start = System.currentTimeMillis();
		list.stream()
				.mapToInt(Integer::intValue)
				.sum();
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static double averageParallel(List<Integer> list) {
		return LongStream.range(0, 10).map(i -> maxParallel(list)).average().getAsDouble();
	}

	private static double averageSequential(List<Integer> list) {
		return LongStream.range(0, 10).map(i -> maxSequential(list)).average().getAsDouble();
	}

}
