package de.viadee.lambda.codeexamples.performance;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ParallelStreams2 {

	public static void main(String[] args) throws InterruptedException {

		long startSequential = System.currentTimeMillis();
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
				.forEach(waitAndPrint(startSequential, "sequential"));

		System.out
				.println("==========================================================================================");

		long startParallel = System.currentTimeMillis();
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
				.parallel()
				.forEach(waitAndPrint(startParallel, "parallel"));
	}

	private static Consumer<? super Integer> waitAndPrint(final long startSeq, String typ) {
		return x -> {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// Nichts tun
			}
			System.out.println("Duration " + typ + " " + x + ": Thread " + Thread.currentThread().getName() + " "
					+ (System.currentTimeMillis() - startSeq) + "ms");
		};
	}

}
