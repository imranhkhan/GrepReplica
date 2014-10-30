package com.pramati.grepreplica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.pramati.grepreplica.patternmatcher.NativePatternMatcher;
import com.pramati.grepreplica.patternmatcher.PatternMatcher;
import com.pramati.grepreplica.patternmatcher.PatternMatcherFactory;

public class FileHandler {

	PatternMatcher patternMatcher;

	public static int GETDOT_COUNT;
	public static int GETEDGE_COUNT;
	public static int EPSLOOP_COUNT;

	public FileHandler(String regex, String matcherId) {
		patternMatcher = PatternMatcherFactory.getPatternMatcher(regex,
				matcherId);
	}

	public int matchPattern(File file) {
		int matchCount = 0;
		if (file.isDirectory()) {
			matchCount = matchInDirectory(file);
		} else {
			matchCount = matchInFile(file);
		}
		return matchCount;
	}

	private int matchInDirectory(File file) {

		int matches = 0;
		File[] fileList = file.listFiles();
		for (File fileToProcess : fileList) {
			matches = matches + this.matchInFile(fileToProcess);
		}
		return matches;
	}

	private int matchInFile(File file) {
		int matches = 0;
		String inputStr = "";
		try {
			if (patternMatcher instanceof NativePatternMatcher) {
				matches = patternMatcher.match(file);
			} else {
				BufferedReader fileReader = new BufferedReader(new FileReader(
						file));
				while ((inputStr = fileReader.readLine()) != null) {
					if (patternMatcher.match(inputStr)) {
						matches++;
					}
				}
				fileReader.close();
			}
			System.out.println("matches in file " + file.getName() + " = "
					+ matches + "\n");
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return matches;
	}

}
