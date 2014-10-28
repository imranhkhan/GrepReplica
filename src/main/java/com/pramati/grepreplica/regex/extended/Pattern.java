package com.pramati.grepreplica.regex.extended;

public class Pattern {

	private NFA nfa;
	private Matcher matcher;

	/*
	 * Later labels will be converted to class then EPSILON can be implemented
	 * as null movement for now because '.' can accept any char, I have just
	 * added '.' as EPSILON move
	 */
	public static final char EPS = '.';
	public static final char STAR = '*';

	public Matcher compile(String regex) {
		for (int i = 0; i < regex.length(); i++) {
			char label = regex.charAt(i);

			switch (label) {
			default:
				defaultChar(label);
				break;
			case EPS:
				defaultChar(EPS);
				break;
			case STAR:
				break;
			}
		}
		matcher = new Matcher(nfa);
		return matcher;
	}

	public void defaultChar(char label) {
		State startState = new State();
		State endState = new State();
		Edge edge = new Edge(startState, endState, label);
		startState.getEdgeMap().put(label, edge);
		if (nfa == null) {
			nfa = new NFA();
			nfa.setStartState(startState);
			nfa.setEndState(endState);
		} else {
			nfa.getEndState().getEdgeMap().put(label, edge);
			nfa.setEndState(endState);
		}
	}

	public void star() {

	}
}
