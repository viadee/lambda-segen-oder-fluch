package de.viadee.lambda.codeexamples.lambdavsinnerclass;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaVsInnerClass1 {

	public static void main(String[] args) {
		
		// Lambda Ausdruck
		
		Predicate<Integer> lambda = x -> x >= 10;
		
		System.out.println("Lambda: " + lambda.test(20));
		
		
		// Inner Class
		
		class InnerClass implements Predicate<Integer>{
			
			private Integer y;

			public InnerClass(Integer y) {
				this.y = y;
			}

			@Override
			public boolean test(Integer x) {
				return x >= y;
			}
			
		}
		
		InnerClass innerClass = new InnerClass(10);
		
		System.out.println("InnerClass: " + innerClass.test(20));

	}

}
