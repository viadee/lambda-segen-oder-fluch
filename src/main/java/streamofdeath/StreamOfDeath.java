package streamofdeath;

import static java.lang.System.out;
import static java.util.stream.IntStream.range;

import org.junit.Test;

public class StreamOfDeath {

	@Test
	public void areYouKiddingMe() {
		// @formatter:off
		range(1, 9).boxed().map( i -> {if(i == 7) return "--------------"; else if(i == 8) return "      ||"; else range(1, 7-i).boxed().map((integer) -> {return " ";}).forEach(out::print);out.print("|"); range(0,i*2).boxed().map((integer) -> {return " ";}).forEach(out::print);out.print("|"); return ""; }).forEach(out::println);
		// @formatter:on
	}

}
