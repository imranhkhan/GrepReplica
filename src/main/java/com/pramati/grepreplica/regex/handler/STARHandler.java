package com.pramati.grepreplica.regex.handler;

import com.pramati.grepreplica.regex.Context;
import com.pramati.grepreplica.regex.exception.RegExException;

public class STARHandler extends MetaCharHandler {

	public STARHandler(Context grepContext) {
		super(grepContext);
	}

	@Override
	public boolean handle() throws RegExException {
		while (grepContext.canIncrement()
				&& canHandlePrev(grepContext.getStrChar())) {
			increamentPos();
		}
		return true;
	}

}
