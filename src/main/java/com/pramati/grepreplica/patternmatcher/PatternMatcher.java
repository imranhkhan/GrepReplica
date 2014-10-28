package com.pramati.grepreplica.patternmatcher;

import java.io.File;


public interface PatternMatcher {
	
	public boolean match(String testStr);
	public int match(File file);
}
