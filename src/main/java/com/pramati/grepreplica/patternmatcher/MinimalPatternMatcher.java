package com.pramati.grepreplica.patternmatcher;


import java.io.File;

import com.pramati.grepreplica.regex.exception.RegExException;
import com.pramati.grepreplica.regex.minimal.RegExPattern;

public class MinimalPatternMatcher implements PatternMatcher {

	private RegExPattern regexPattern;

	public void initialize(String regex) {
		regexPattern = new RegExPattern(regex);	
	}

	public boolean match(String inputStr) {
		if (regexPattern.find(inputStr)) {
			return true;
		}
		return false;
	}

	public int match(File file) {
		// TODO Auto-generated method stub
		throw new RegExException("Not implemented");
	}
}
