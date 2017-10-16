package de.viadee.lambda.codeexamples.lesbarkeit;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class KeywordInString {

	protected static final List<String> keywords = Arrays.asList("#JCON",
			"@viadee_it", "jcon.one");
	protected static final String tweet1 = "Welcome @tobiaslvoss to #JCON Oct 25, 2017! Visit his session: #JUnit 5 mit dynamischen Testfällen @viadee_it http://www.jcon.one";
	protected static final String tweet1a = "Welcome @tobiaslvoss to #JCON Oct 25, 2017! Visit his session: #JUnit 5 mit dynamischen Testfällen @viadee http://www.jcon.one";
	protected static final String tweet2 = "Welcome Christian Nockemann to #JCON Oct 25, 2017! Visit his session: #SpringBatch #PerformanceMonitoring @viadee_it http://www.jcon.one";
	protected static final String tweet3 = " Welcome Björn Meschede to #JCON Oct 25, 2017! Visit his session: Good Times with Bad Code #CleanCode @viadee_it http://www.jcon.one";

	@Test
	public void testAllMatch() {
		assertTrue(keywords.stream().allMatch(tweet1::contains));
		assertTrue(keywords.stream().allMatch(tweet2::contains));
		assertTrue(keywords.stream().allMatch(tweet3::contains));
	}
	
	@Test
	public void testDebugging() {
		assertTrue(keywords.stream().allMatch(tweet1a::contains));
		//assertTrue(keywords.stream().peek(s -> System.out.println(s)).allMatch(tweet1a::contains));
	}

}
