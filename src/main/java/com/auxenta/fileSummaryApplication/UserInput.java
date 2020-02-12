package com.auxenta.fileSummaryApplication;

import java.io.File;
import java.io.IOException;

public class UserInput {
	
	public static void handlingInputs(String args[]) throws IOException {
		Validation.checkAll(args); 
		FilesUtil.callAllMethods(new File(args[0]));
	}
}
