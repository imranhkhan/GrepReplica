package com.pramati.grepreplica.regex.extended;

public class Matcher {

	private final NFA nfa;
	private final EdgeFinder edgeFinder;

	public Matcher(NFA nfa) {
		this.nfa = nfa;
		edgeFinder = new EdgeFinder();
	}

	public boolean find(String testStr) {
		State currState = nfa.getStartState();
		for (int i = 0; i < testStr.length(); i++) {
			if (currState != nfa.getEndState()) {
				Edge edge = edgeFinder.findEdge(currState, testStr.charAt(i));
				if (edge != null) {
					currState = edge.getDest();
				} else {
					currState = nfa.getStartState();
				}
			}
		}
		return currState.isFinal();
	}
}
