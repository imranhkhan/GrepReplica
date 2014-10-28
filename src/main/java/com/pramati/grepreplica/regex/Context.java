package com.pramati.grepreplica.regex;

import com.pramati.grepreplica.regex.exception.RegExException;
import com.pramati.grepreplica.regex.handler.MetaCharHelper;

public class Context {

	private final String regex;
	private String inputStr;
	private int strLength;

	private int regexPos;
	private int strPos;
	private int index;

	public Context(String regex) {
		this.regex = regex;
	}

	public boolean initContext(String inputStr) {
		this.inputStr = inputStr;
		this.strLength = inputStr.length();
		if (strLength == 0) {
			return false;
		}
		this.index = 0;
		this.strPos = 0;
		this.regexPos = 0;
		return true;
	}

	public boolean isStrEnd() {
		if (index < inputStr.length() && strPos < inputStr.length()) {
			return false;
		}
		return true;
	}

	public boolean isRegExEnd() {
		if (regexPos < regex.length()) {
			return false;
		}
		return true;
	}

	public char getRegExChar() {
		if (regexPos >= 0) {
			return regex.charAt(regexPos);
		} else {
			throw new RegExException("Invalid Regular expression");
		}
	}

	public char getPrevRegExChar() {
		if ((regexPos - 1) >= 0) {
			return regex.charAt(regexPos - 1);
		} else {
			throw new RegExException("Invalid Regular expression");
		}

	}

	public char getStrChar() {
		if (strPos < strLength) {
			return inputStr.charAt(strPos);
		} else {
			throw new RegExException("input string exhausted");
		}
	}

	public char getPrevStrChar() {
		if ((strPos - 1) >= 0) {
			return inputStr.charAt(strPos - 1);
		} else {
			return inputStr.charAt(strPos);
		}
	}

	public boolean canIncrement() {
		return strPos < strLength - 1;
	}

	public void incrementStrPos() {
		strPos++;
	}

	public void incrementRegexPos() {
		regexPos++;
	}

	public boolean isPreviousEqual() {
		return getPrevStrChar() == getPrevRegExChar();
	}

	public void reset() {
		index = index + 1;
		strPos = index;
		regexPos = 0;
	}

	public boolean nextIsChar() {
		if (regexPos < regex.length() - 1
				&& MetaCharHelper.getCharSet().contains(
						regex.charAt(regexPos + 1))) {
			return false;
		}
		return true;
	}
}
