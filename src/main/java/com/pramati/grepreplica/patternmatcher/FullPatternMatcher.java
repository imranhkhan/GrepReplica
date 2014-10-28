package com.pramati.grepreplica.patternmatcher;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pramati.grepreplica.regex.exception.RegExException;

public class FullPatternMatcher implements PatternMatcher {

	private Pattern pattern;

	public FullPatternMatcher(String regex) {
		pattern = Pattern.compile(regex);
	}

	public boolean match(String inputStr) {
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

	public int match(File file) {
		// TODO Auto-generated method stub
		throw new RegExException("Not implemented");
	}
}
