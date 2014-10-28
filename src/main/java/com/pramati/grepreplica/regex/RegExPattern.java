package com.pramati.grepreplica.regex;

import com.pramati.grepreplica.regex.exception.RegExException;
import com.pramati.grepreplica.regex.handler.MetaCharHandler;
import com.pramati.grepreplica.regex.handler.MetaCharHelper;

public class RegExPattern {

	private Context grepContext;

	public RegExPattern(String regEx) {
		grepContext = new Context(regEx);
		MetaCharHelper.initHendlers(grepContext);
	}

	public boolean find(String inputStr) {
		boolean found = false;
		try {
			if (grepContext.initContext(inputStr)) {
				found = process();
			}
		} catch (RegExException e) {
			e.printStackTrace();
		}
		return found;
	}

	private boolean process() {
		boolean matched = true;
		while (!grepContext.isStrEnd()) {
			if (!grepContext.isRegExEnd()) {
				matched = true;
				MetaCharHandler metaCharHandler = MetaCharHelper
						.getMetaCharHandler(grepContext.getRegExChar());
				boolean found = metaCharHandler.handle();
				grepContext.incrementRegexPos();
				if (!found) {
					matched = false;
					grepContext.reset();
				}
			} else {
				break;
			}
		}
		return matched;
	}
}
