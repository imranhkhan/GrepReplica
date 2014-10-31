package com.pramati.grepreplica.regex.extended.nfabuilder;

import java.util.HashMap;
import java.util.Map;

import com.pramati.grepreplica.regex.extended.NFA;

public class NFABuilderFactory {

	public static final Character DEFAULT = null;
	public static final Character EPS = '.';
	public static final Character STAR = '*';
	public static final Character PLUS = '+';
	public static final Character QUEST = '?';

	private static final Map<Character, NFABuilder> builderMap = new HashMap<Character, NFABuilder>();

	public static void initNFABuilder(NFA nfa) {
		builderMap.put(DEFAULT, new CHARBuilder(nfa));
		builderMap.put(EPS, new DOTBuilder(nfa));
		builderMap.put(STAR, new STARBuilder(nfa));
		builderMap.put(PLUS, new PLUSBuilder(nfa));
		builderMap.put(QUEST, new QUESTBuilder(nfa));
	}

	public static NFABuilder getBuilder(char label) {
		NFABuilder nfaBuilder = builderMap.get(label);
		if (nfaBuilder == null) {
			nfaBuilder = builderMap.get(DEFAULT);
		}
		return nfaBuilder;
	}
}
