package com.pramati.grepreplica.regex.extended.nfabuilder;

import com.pramati.grepreplica.regex.extended.Edge;
import com.pramati.grepreplica.regex.extended.NFA;
import com.pramati.grepreplica.regex.extended.State;

public class QUESTBuilder extends NFABuilder {

	public QUESTBuilder(NFA nfa) {
		super(nfa);
	}

	@Override
	public void add(char input) {
		State nfaEndState = nfa.getEndState();
		State prevState = getPrevState(nfaEndState);
		prevState.getEpsilonEdge().add(
				new Edge(prevState, nfaEndState, NFABuilderFactory.EPS));
	}

}
