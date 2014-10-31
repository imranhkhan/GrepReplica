package com.pramati.grepreplica.regex.extended.nfabuilder;

import com.pramati.grepreplica.regex.extended.Edge;
import com.pramati.grepreplica.regex.extended.NFA;
import com.pramati.grepreplica.regex.extended.State;

public class PLUSBuilder extends NFABuilder {

	public PLUSBuilder(NFA nfa) {
		super(nfa);
	}

	@Override
	public void add(char input) {
		State nfaEndState = nfa.getEndState();
		nfaEndState.getEdgeMap().put(prevChar,
				new Edge(nfaEndState, nfaEndState, prevChar));
	}

}
