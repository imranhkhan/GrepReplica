package com.pramati.grepreplica.regex.extended.nfabuilder;

import com.pramati.grepreplica.regex.extended.Edge;
import com.pramati.grepreplica.regex.extended.NFA;
import com.pramati.grepreplica.regex.extended.State;

public abstract class NFABuilder {

	protected NFA nfa;
	protected static char prevChar;

	public NFABuilder(NFA nfa) {
		this.nfa = nfa;
	}

	public static NFA createSingleEdgeNFA() {
		State startState = new State();
		State finalState = new State();
		startState.getEpsilonEdge().add(
				new Edge(startState, finalState, NFABuilderFactory.EPS));
		NFA nfa = new NFA();
		nfa.setStartState(startState);
		nfa.setEndState(finalState);
		return nfa;
	}

	public State getPrevState(State currState) {
		return currState.getPrevEdgeMap().get(prevChar).getSource();
	}

	public abstract void add(char label);
}
