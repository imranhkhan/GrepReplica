package com.pramati.grepreplica.regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RegExExecutor {

	public static void main(String[] args) throws Exception {

		BufferedReader testCaseReader = new BufferedReader(new FileReader(
				new File("D:/testcase/regextestcase.csv")));
		String line = "";
		while ((line = testCaseReader.readLine()) != null) {
			String[] tokens = line.split(";");
			if (tokens.length > 1) {
				System.out.println(tokens[0] + "  "
						+ new RegExPattern(tokens[0]).find(tokens[1]));
			}
		}
		testCaseReader.close();
	}
}