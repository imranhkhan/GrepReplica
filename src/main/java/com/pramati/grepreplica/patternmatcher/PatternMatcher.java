package com.pramati.grepreplica.patternmatcher;

import java.io.File;

public interface PatternMatcher {

	/*
	 * Initialize the PatternMatcher for given regex
	 */
	public void initialize(String regex);

	/*
	 * Find pattern in given testStr
	 */
	public boolean match(String testStr);

	/*
	 * Find pattern in given file
	 */
	public int match(File file);
}
