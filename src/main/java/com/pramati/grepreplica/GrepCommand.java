package com.pramati.grepreplica;

import java.io.File;

/**
 * GrepCommand
 *
 */
public class GrepCommand {

	private FileHandler fileHandler;
	
	public int grep(String fileName, String regex) {
		int totalMatch = 0;
		File file = new File(fileName);
		fileHandler = new FileHandler(regex);
		if (file.exists()) {
			totalMatch = fileHandler.matchPattern(file);
		} else {
			throw new RuntimeException("File/Folder doest not exist");
		}
		return totalMatch;
	}
}
