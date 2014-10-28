package com.pramati.grepreplica.regex.extended;

public class Matcher {

	private NFA nfa;

	public Matcher(NFA nfa) {
		this.nfa = nfa;
	}

	public boolean find(String testStr) {
		State currState = nfa.getStartState();
		State preState = null;

		for (int i = 0; i < testStr.length(); i++) {
			if (currState != nfa.getEndState()) {
				Edge edge = getCurrEdge(currState, testStr.charAt(i));
				if (edge != null) {
					preState = currState;
					currState = edge.getDest();
				} else {
					if (preState != null)
						currState = preState;
				}
			}
		}

		if (currState == nfa.getEndState()) {
			return true;
		} else {
			return false;
		}
	}

	public Edge getCurrEdge(State currState, char label) {
		Edge edge = currState.getEdgeMap().get(Pattern.EPS);
		if (edge == null) {
			edge = currState.getEdgeMap().get(label);
		}
		return edge;
	}
}
