package de.viadee.lambda.codeexamples.lambdavsinnerclass;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaVsInnerClass2_Lambda {

	public static void main(String[] args) {

		Stream<Integer> filteredByLambda = Stream.of(2, 5, 10, 20).filter(x -> x >= 10);

		String lambda = filteredByLambda.map(String::valueOf).collect(Collectors.joining(","));

		System.out.println("Lambda: " + lambda);
	}

}
