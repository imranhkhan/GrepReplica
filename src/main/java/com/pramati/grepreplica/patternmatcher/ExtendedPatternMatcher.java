package com.pramati.grepreplica.patternmatcher;

import java.io.File;

import com.pramati.grepreplica.regex.exception.RegExException;
import com.pramati.grepreplica.regex.extended.*;

public class ExtendedPatternMatcher implements PatternMatcher {

	private Pattern pattern;
	private Matcher matcher;

	public ExtendedPatternMatcher(String regex) {
		pattern = new Pattern();
		matcher = pattern.compile(regex);
	}

	public boolean match(String testStr) {
		if (matcher.find(testStr)) {
			return true;
		}
		return false;
	}

	public int match(File file) {
		throw new RegExException("not implemented");
	}

}
