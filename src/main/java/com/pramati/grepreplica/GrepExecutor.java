package com.pramati.grepreplica;


/*
 * Main class that execute the grep on given file or directory
 * It requires following command line argument
 * 
 * @args[0]  regex   @required
 * @args[1]  file or directory @required 
 * @args[2]  PatternMatcher to use OPTIONS[-e Extended , -f Java, -n Native, -m Minimal] @optional 
 * 
 * */
public class GrepExecutor {

	public static void main(String[] args) {

		String fileName = null;
		String regex = null;
		String matcherId = "-e";

		if (args.length > 1) {
			regex = args[0];
			fileName = args[1];
		} else {
			System.err.println("Pattern or File/Folder location is missing");
			return;
		}

		if (args.length == 3) {
			matcherId = args[2];
		}
		try {
			Thread.sleep(000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("grep started ... ");
		long startTime = System.currentTimeMillis();
		GrepCommand grepCommand = new GrepCommand();
		int matches = grepCommand.grep(fileName, regex, matcherId);
		System.out.println("Total matches " + matches + " in "
				+ (System.currentTimeMillis() - startTime) + " ms");

	}

}
