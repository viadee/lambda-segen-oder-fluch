package de.viadee.lambda.codeexamples.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

public class Exceptions2 {

	/**
	 * Einfache Dateiverarbeitung mit Files.lines und Streams
	 * 
	 * Erweitert um Angabe des Charsets
	 */
	@Test
	public void testFilesLinesWithCharset() {
		try (Stream<String> lines = Files.lines(Exceptions1.PATH_TEST_TXT, StandardCharsets.ISO_8859_1)) {
			final Optional<String> first = lines.findFirst();
			assertEquals("Münster", first.get());
		} catch (IOException e) {
			fail("Datei " + Exceptions1.PATH_TEST_TXT + "konnte nicht gelesen werden");
		}
	}

}
