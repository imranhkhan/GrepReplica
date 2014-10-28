package com.pramati.grepreplica.patternmatcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.pramati.grepreplica.regex.exception.RegExException;

public class NativePatternMatcher implements PatternMatcher {

	private final String regex;

	public NativePatternMatcher(String regex) {
		this.regex = regex;
	}

	public int match(File file) {
		int matchCount = 0;
		try {
			String[] cmd = new String[5];
			cmd[0] = "C:\\cygwin64\\bin\\grep";
			cmd[1] = "-e";
			cmd[2] = regex;
			cmd[3] = file.getAbsolutePath();
			cmd[4] = "-r";
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(cmd);
			InputStream result = process.getInputStream();
			BufferedReader resultReader = new BufferedReader(
					new InputStreamReader(result));
			while (resultReader.readLine() != null) {
				matchCount++;
			}
			resultReader.close();
		} catch (IOException io) {
			io.printStackTrace();
		}
		return matchCount;
	}

	public boolean match(String testStr) {
		// TODO Auto-generated method stub
		throw new RegExException("Not implemented");
	}
	
	
}
