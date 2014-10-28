package com.pramati.grepreplica.regex.handler;

import com.pramati.grepreplica.regex.Context;

public class DOTHandler extends MetaCharHandler {

	public DOTHandler(Context grepContext) {
		super(grepContext);
	}

	public boolean handle() {
		if (canHandleCurr(MetaCharHelper.DOT)) {
			increamentPos();
			return true;
		}
		return false;
	}

}
