package com.auxenta.fileSummaryApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class FilesUtilTest {
	String newLine = System.getProperty("line.separator");
	String content = "As a user, I want to get Number of characters, Number of words, No of Sentences," + newLine
			+ "No of Paragraphs and  occurrence of each word in a specific file.";

	@Test
	void test_countCharacters() throws IOException {
		assertEquals(4, FilesUtil.countCharacters("want"));
		assertEquals(6, FilesUtil.countCharacters("want  "));
		assertEquals(8, FilesUtil.countCharacters("want@$%&"));
		assertEquals(0, FilesUtil.countCharacters(""));
	}

	@Test
	void test_countLines() throws IOException {
		assertEquals(2, FilesUtil.countLines(content));
		assertEquals(0, FilesUtil.countLines(""));
	}

	@Test
	void test_countWords() throws IOException {
		assertEquals(32, FilesUtil.countWords(content));
		assertEquals(0, FilesUtil.countWords(""));
	}

	@Test
	void test_countSentences() throws IOException {
		assertEquals(1, FilesUtil.countSentences(content));
		assertEquals(0, FilesUtil.countSentences(""));
	}

	@Test
	void test_countWordOccurance() throws IOException {
		HashMap<String, Integer> map = FilesUtil.countWordOccurance(content);
		assertEquals(5, map.get("of").intValue());
		NullPointerException nullException = assertThrows(NullPointerException.class, () -> {
			FilesUtil.countWordOccurance("");
		});
		assertEquals("Input is Empty!", nullException.getMessage());
	}
}
