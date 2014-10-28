package com.pramati.grepreplica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.pramati.grepreplica.patternmatcher.ExtendedPatternMatcher;
import com.pramati.grepreplica.patternmatcher.PatternMatcher;

public class FileHandler {

	PatternMatcher patternMatcher;

	public FileHandler(String regex) {
		patternMatcher = new ExtendedPatternMatcher(regex);
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
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			while ((inputStr = fileReader.readLine()) != null) {
				if (patternMatcher.match(inputStr)) {
					matches++;
				}
			}
			fileReader.close();
			System.out.println("matches in file " + matches + "\n");
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return matches;
	}

}
