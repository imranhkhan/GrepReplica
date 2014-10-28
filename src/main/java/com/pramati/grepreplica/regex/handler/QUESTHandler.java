package com.pramati.grepreplica.regex.handler;

import com.pramati.grepreplica.regex.Context;

public class QUESTHandler extends MetaCharHandler {

	public QUESTHandler(Context grepContext) {
		super(grepContext);
	}

	@Override
	public boolean handle() {
		if (grepContext.canIncrement()
				&& canHandlePrev(grepContext.getStrChar())) {
			grepContext.incrementRegexPos();
			increamentPos();
		}
		return true;
	}

}
