package com.auxenta.fileSummaryApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	private static Logger logger = LogManager.getLogger(UserInput.class);

	public static void main(String[] args) {
		try {
			UserInput.handlingInputs(args);
		} catch (Exception e) {
			logger.error(e);
		}

	}
}
