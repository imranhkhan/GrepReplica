package com.pramati.grepreplica.regex.extended.nfabuilder;

import com.pramati.grepreplica.regex.extended.Edge;
import com.pramati.grepreplica.regex.extended.NFA;
import com.pramati.grepreplica.regex.extended.State;

public class DOTBuilder extends NFABuilder {

	public DOTBuilder(NFA nfa) {
		super(nfa);
	}

	@Override
	public void add(char label) {
		State endState = new State();
		nfa.getEndState().getEpsilonEdge()
				.add(new Edge(nfa.getEndState(), endState, label));
		nfa.setEndState(endState);
	}

}
