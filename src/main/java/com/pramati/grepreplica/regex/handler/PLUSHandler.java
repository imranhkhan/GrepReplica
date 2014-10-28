package com.pramati.grepreplica.regex.handler;

import com.pramati.grepreplica.regex.Context;

public class PLUSHandler extends MetaCharHandler {

	public PLUSHandler(Context grepContext) {
		super(grepContext);
	}

	@Override
	public boolean handle() {
		if (grepContext.isPreviousEqual()) {
			while (grepContext.canIncrement()
					&& canHandlePrev(grepContext.getStrChar())) {
				increamentPos();
			}
			return true;
		}
		return false;
	}
}
