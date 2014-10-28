package com.pramati.grepreplica.regex.handler;

import com.pramati.grepreplica.regex.Context;

public abstract class MetaCharHandler {
	protected final Context grepContext;
	
	public MetaCharHandler(Context grepContext) {
		this.grepContext = grepContext;
	}

	public boolean canHandleCurr(char strChar) {
		if (grepContext.getRegExChar() == strChar) {
			return true;
		}
		return false;
	}

	public boolean canHandlePrev(char strChar) {
		if (grepContext.getPrevRegExChar() == strChar) {
			return true;
		}
		return false;
	}

	public void increamentPos() {
		grepContext.incrementStrPos();
	}


	public abstract boolean handle();
}
