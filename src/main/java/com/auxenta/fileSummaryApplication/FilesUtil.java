package com.auxenta.fileSummaryApplication;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilesUtil {
	private static Logger logger = LogManager.getLogger(FilesUtil.class);
	static String content;
	static String newLine = System.getProperty("line.separator");

	public static int countCharacters(String content) throws IOException {
		return content.toCharArray().length;
	}

	public static int countLines(String content) throws IOException {
		int length = 0;
		if(content.length() > 0) {
			length = content.split(newLine).length;
		}
		return length;
	}

	public static int countWords(String content) throws IOException {
		int length = 0;
		if(content.length() > 0) {
			length = content.split("\\s+|\\,|\\'|\\[|\\]|\\{|\\}|\\.|\\<|\\>|\\/|\\|\\(|\\)").length;
		}
		return length;
	}
	
	public static int countSentences(String content)throws IOException{
		int length = 0;
		if(content.length() > 0) 
		{ 
			length = content.split("[!?.:]+").length; 
		}
		return length;
	}
	
	public static HashMap<String, Integer> countWordOccurance(String content) throws IOException {
		if(Validation.checkInputEmpty(content)) {
			throw new NullPointerException("Input is Empty!");
		}
		HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
		String[] words = content.split("\\s+|\\,|\\'|\\[|\\]|\\{|\\}|\\.|\\<|\\>|\\/|\\|\\(|\\)");
		for (String str : words) {
			if (wordCountMap.containsKey(str)) {
				wordCountMap.put(str, wordCountMap.get(str) + 1);
			} else {
				wordCountMap.put(str, 1);
			}
		}
		return wordCountMap;
	}

	public static void callAllMethods(File file) throws IOException {
		content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		logger.info("Total Number Of Characters are : " + countCharacters(content));
		logger.info("Total Number Of Lines are : " + countLines(content));
		logger.info("Total Number Of Words are : " + countWords(content));
		logger.info("Total Number Of Sentences are : " + countSentences(content));
		logger.info(countWordOccurance(content));
	}
}
