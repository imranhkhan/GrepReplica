package com.pramati.grepreplica.patternmatcher;


import java.io.File;

import com.pramati.grepreplica.regex.RegExPattern;
import com.pramati.grepreplica.regex.exception.RegExException;

public class MinimalPatternMatcher implements PatternMatcher {

	private RegExPattern regexPattern;

	public MinimalPatternMatcher(String regex) {
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
