package com.pramati.grepreplica.regex.extended;

import com.pramati.grepreplica.regex.extended.nfabuilder.NFABuilder;
import com.pramati.grepreplica.regex.extended.nfabuilder.NFABuilderFactory;

public class Pattern {

	private NFA nfa;
	private Matcher matcher;

	public Pattern() {
		nfa = new NFA();
		NFABuilderFactory.initNFABuilder(nfa);
	}

	public Matcher compile(String regex) {
		for (int i = 0; i < regex.length(); i++) {
			char label = regex.charAt(i);
			NFABuilder nfaBuilder = NFABuilderFactory.getBuilder(label);
			nfaBuilder.add(label);
		}
		if (nfa == null) {
			nfa = NFABuilder.createSingleEdgeNFA();
		}
		nfa.getEndState().setFinal(true);
		matcher = new Matcher(nfa);
		return matcher;
	}

}
