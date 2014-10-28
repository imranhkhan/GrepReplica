package com.pramati.grepreplica.regex.handler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.pramati.grepreplica.regex.Context;

public class MetaCharHelper {

	public static final Character DOT = '.';
	public static final Character STAR = '*';
	public static final Character PLUS = '+';
	public static final Character QUEST = '?';
	public static final Character CHAR = null;

	private static Map<Character, MetaCharHandler> metaCharMap = new HashMap<Character, MetaCharHandler>();

	public static void initHendlers(Context grepContext) {
		metaCharMap.put(DOT, new DOTHandler(grepContext));
		metaCharMap.put(STAR, new STARHandler(grepContext));
		metaCharMap.put(PLUS, new PLUSHandler(grepContext));
		metaCharMap.put(QUEST, new QUESTHandler(grepContext));
		metaCharMap.put(CHAR, new CHARHandler(grepContext));
	}

	public static MetaCharHandler getMetaCharHandler(char metaChar) {
		MetaCharHandler metaCharHandler = metaCharMap.get(metaChar);
		if (metaCharHandler == null) {
			metaCharHandler = metaCharMap.get(CHAR);
		}
		return metaCharHandler;
	}

	public static Set<Character> getCharSet() {
		Set<Character> charSet = new HashSet<Character>(metaCharMap.keySet());
		charSet.remove('.');
		charSet.remove(null);
		return charSet;
	}
}
