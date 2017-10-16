package de.viadee.lambda.codeexamples.lambdavsinnerclass;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaVsInnerClass2_InnerClass {

	public static void main(String[] args) {

		class InnerClass implements Predicate<Integer> {

			private Integer y;

			public InnerClass(Integer y) {
				this.y = y;
			}

			@Override
			public boolean test(Integer x) {
				return x >= y;
			}

		}

		Stream<Integer> filterdByInnerClass = Stream.of(2, 5, 10, 20).filter(new InnerClass(10));

		String innerClass = filterdByInnerClass.map(String::valueOf).collect(Collectors.joining(","));

		System.out.println("InnerClass: " + innerClass);

	}

}
