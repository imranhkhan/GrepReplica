package com.pramati.grepreplica.regex.extended.nfabuilder;

import com.pramati.grepreplica.regex.extended.Edge;
import com.pramati.grepreplica.regex.extended.NFA;
import com.pramati.grepreplica.regex.extended.State;

public class CHARBuilder extends NFABuilder {

	public CHARBuilder(NFA nfa) {
		super(nfa);
	}

	@Override
	public void add(char label) {
		Edge edge;
		State endState = new State();
		if (nfa.getStartState() == null && nfa.getEndState() == null) {
			State startState = new State();
			nfa.setStartState(startState);
			edge = new Edge(startState, endState, label);
			startState.getEdgeMap().put(label, edge);
			nfa.setEndState(endState);
		} else {
			edge = new Edge(nfa.getEndState(), endState, label);
			nfa.getEndState().getEdgeMap().put(label, edge);
			nfa.setEndState(endState);
		}
		prevChar = label;
		endState.getPrevEdgeMap().put(label, edge);
	}

}
