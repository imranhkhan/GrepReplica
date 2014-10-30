package com.pramati.grepreplica;

import java.io.File;

import com.pramati.grepreplica.regex.exception.RegExException;

/**
 * GrepCommand
 *
 */
public class GrepCommand {

	public int grep(String fileName, String regex, String matcherId) {
		int totalMatch = 0;
		File file = new File(fileName);
		if (file.exists()) {
			FileHandler fileHandler = new FileHandler(regex, matcherId);
			totalMatch = fileHandler.matchPattern(file);

			System.out.println("dot count =" + FileHandler.GETDOT_COUNT);
			System.out.println("getlabled count " + FileHandler.GETEDGE_COUNT);
			System.out.println("eps loop count=" + FileHandler.EPSLOOP_COUNT);
		} else {
			throw new RegExException("File/Folder doest not exist");
		}
		return totalMatch;
	}
}
