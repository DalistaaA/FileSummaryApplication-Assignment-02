package com.auxenta.fileSummaryApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class ValidationTest {
	static String fileSeparator = System.getProperty("file.separator");
	static String currentDir = System.getProperty("user.dir");
	static File sourcefile = new File(currentDir + fileSeparator + "Log" + fileSeparator + "logging.log");

	@Test
	void test_checkInputEmpty() {
		assertTrue(Validation.checkInputEmpty(""));
		assertFalse(Validation.checkInputEmpty(" "));
		assertFalse(Validation.checkInputEmpty("test"));
	}

	@Test
	void test_checkIsFile() {
		assertTrue(Validation.checkIsFile(sourcefile));
		assertFalse(Validation.checkIsFile(new File("")));
		assertFalse(Validation.checkIsFile(new File("test")));
	}

	@Test
	void test_checkIsReadable() {
		assertTrue(Validation.checkIsReadable(sourcefile));
	}
	
	@Test
	void test_checkAll() {
		ArrayIndexOutOfBoundsException arrException = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Validation.checkAll(new String[] {" ", " "});
		});
		assertEquals("Input must have only one value. Please provide only one input as follows/path/to/file.txt", arrException.getMessage());
		
		NullPointerException nullException = assertThrows(NullPointerException.class, () -> {
			Validation.checkAll(new String[] {""});
		});
		assertEquals("Input is Empty. Provide valid input as follows /path/to/file.txt", nullException.getMessage());
		
		FileNotFoundException fileException = assertThrows(FileNotFoundException.class, () -> {
			Validation.checkAll(new String[] {"scvz"});
		});
		assertEquals("There is no file. Provide valid file path as follows /path/to/file.txt", fileException.getMessage());
	}

}
