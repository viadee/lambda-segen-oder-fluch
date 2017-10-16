package de.viadee.lambda.codeexamples.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

public class Exceptions1 {

	protected static final Path PATH_TEST_TXT = Paths.get("src", "main", "java", "de", "viadee", "lambda",
			"codeexamples", "exceptions", "test.txt");

	/**
	 * Einfache Dateiverarbeitung mit Files.lines und Streams
	 */
	@Test
	public void testFilesLines() {
		try (Stream<String> lines = Files.lines(PATH_TEST_TXT)) {
			final Optional<String> first = lines.filter(s -> s.startsWith("M")).findFirst();
			assertEquals("Münster", first.get());
		} catch (IOException e) {
			fail("Datei " + PATH_TEST_TXT + "konnte nicht gelesen werden");
		}
	}

}
