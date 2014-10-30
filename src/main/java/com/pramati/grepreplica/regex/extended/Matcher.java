package com.pramati.grepreplica.regex.extended;

import java.util.List;

public class Matcher {

	private final NFA nfa;

	public Matcher(NFA nfa) {
		this.nfa = nfa;
	}

	public boolean find(String testStr) {
		State currState = nfa.getStartState();
		for (int i = 0; i < testStr.length(); i++) {
			if (currState != nfa.getEndState()) {
				Edge edge = getEdge(currState, testStr.charAt(i));
				if (edge != null) {
					currState = edge.getDest();
				} else {
					currState = nfa.getStartState();
				}
			} else {
				break;
			}
		}
		return currState.isFinal();
	}

	public Edge getEdge(State currState, char label) {
		Edge edge = getDotEdge(currState);
		if (edge == null) {
			edge = getLabledEdge(currState, label);
		}
		return edge;

	}

	public Edge getLabledEdge(State currState, char label) {
		Edge edge = currState.getEdgeMap().get(label);
		// FileHandler.GETEDGE_COUNT++;
		if (edge == null) {
			List<Edge> epsEdges = currState.getEpsilonEdge();
			if (epsEdges.size() > 0) {
				edge = getEdgeByEpsilonTransition(epsEdges, label);
			}
		}
		return edge;
	}

	public Edge getDotEdge(State currState) {
		// FileHandler.GETDOT_COUNT++;
		if (currState.getEdgeMap().size() == 0
				&& currState.getEpsilonEdge().size() == 1) {
			return currState.getEpsilonEdge().get(0);
		}
		return null;
	}

	public Edge getEdgeByEpsilonTransition(List<Edge> epsEdges, char label) {
		Edge edge = null;
		for (Edge epsEdge : epsEdges) {
			// FileHandler.EPSLOOP_COUNT++;
			State destState = epsEdge.getDest();
			if (destState.getEdgeMap().get(label) != null) {
				edge = destState.getEdgeMap().get(label);
				break;
			}
		}
		return edge;
	}
}
