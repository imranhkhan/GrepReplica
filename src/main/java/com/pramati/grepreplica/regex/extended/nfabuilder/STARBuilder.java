package com.pramati.grepreplica.regex.extended.nfabuilder;

import com.pramati.grepreplica.regex.extended.Edge;
import com.pramati.grepreplica.regex.extended.NFA;
import com.pramati.grepreplica.regex.extended.State;

public class STARBuilder extends NFABuilder {

	public STARBuilder(NFA nfa) {
		super(nfa);
	}

	@Override
	public void add(char input) {
		State nfaEndState = nfa.getEndState();
		State prevState = getPrevState(nfaEndState);
		prevState.getEdgeMap().put(prevChar,
				new Edge(prevState, prevState, prevChar));
		nfa.setEndState(prevState);
	}
}
