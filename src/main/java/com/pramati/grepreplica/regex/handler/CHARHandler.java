package com.pramati.grepreplica.regex.handler;

import com.pramati.grepreplica.regex.Context;

public class CHARHandler extends MetaCharHandler {

	public CHARHandler(Context grepContext) {
		super(grepContext);
	}

	@Override
	public boolean handle() {
		if (canHandleCurr(grepContext.getStrChar())) {
			increamentPos();
			return true;
		} else {
			return !grepContext.nextIsChar();
		}
	}
}
