package com.pramati.grepreplica.regex.extended;

import java.util.List;

public class Matcher {

	private NFA nfa;

	public Matcher(NFA nfa) {
		this.nfa = nfa;
	}

	public boolean find(String testStr) {
		State currState = nfa.getStartState();
		for (int i = 0; i < testStr.length(); i++) {
			if (currState != nfa.getEndState()) {
				Edge edge = getCurrEdge(currState, testStr.charAt(i));
				if (edge != null) {
					//System.out.println(" " + currState.getStateId() + " "
					//		+ testStr.charAt(i) + " " + edge.getLabel());
					currState = edge.getDest();
				} else {
					currState = nfa.getStartState();
				}
			}
		}
		return currState.isFinal();
	}

	public Edge getCurrEdge(State currState, char label) {
		Edge edge = currState.getEdgeMap().get(label);
		if (edge == null) {
			List<Edge> epsEdges = currState.getEpsilonEdge();
			for (Edge epsEdge : epsEdges) {
				State destState = epsEdge.getDest();
				if (destState.getEdgeMap().get(label) != null) {
					edge = destState.getEdgeMap().get(label);
					break;
				}
				edge = epsEdges.get(0);
			}
		}

		return edge;
	}

	public static void main(String[] args) {
		Matcher matcher = new Pattern().compile("File");
		System.out
				.println(matcher
						.find("Marking Film C:\\Windows\\system32\\regsvr32.exe to run when uninstalled"));
	}
}
