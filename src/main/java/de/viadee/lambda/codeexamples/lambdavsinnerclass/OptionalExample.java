package de.viadee.lambda.codeexamples.lambdavsinnerclass;

import java.util.Optional;

public class OptionalExample {

	private static String fallbackMethod() {
		System.out.println("fallbackMethod called!");
		return "Value is not present";
	}

	public static void main(String[] args) {

		System.out.println("orElse():");
		System.out.println(Optional.of("Value is present").orElse(fallbackMethod()));

		System.out.println(System.getProperty("line.separator"));

		System.out.println("orElseGet()");
		System.out.println(Optional.of("Value is present").orElseGet(() -> fallbackMethod()));

	}

}
