package com.auxenta.fileSummaryApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validation {
	private static Logger logger = LogManager.getLogger(Validation.class);

	public static Boolean checkInputEmpty(String input) {
		return input.isEmpty();
	}

	public static Boolean checkIsFile(File source) {
		return source.isFile();
	}

	public static Boolean checkIsReadable(File source) {
		return Files.isReadable(source.toPath());
	}

	public static void checkAll(String args[]) throws IOException {
		if (args.length != 1) {
			logger.error("Input must have only one value. Please provide only one input as follows /path/to/file.txt");
			throw new ArrayIndexOutOfBoundsException("Input must have only one value. Please provide only one input as follows/path/to/file.txt");
		} else if (checkInputEmpty(args[0])) {
			logger.error("Input is Empty. Provide valid input as follows /path/to/file.txt");
			throw new NullPointerException("Input is Empty. Provide valid input as follows /path/to/file.txt");
		} else if (!checkIsFile(new File(args[0]))) {
			logger.error("There is no file. Provide valid file path as follows /path/to/file.txt");
			throw new FileNotFoundException("There is no file. Provide valid file path as follows /path/to/file.txt");
		}
	}
}
