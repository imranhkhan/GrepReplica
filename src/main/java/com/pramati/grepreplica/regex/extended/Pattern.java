package com.pramati.grepreplica.regex.extended;

public class Pattern {

	private NFA nfa;
	private Matcher matcher;
	private char prevChar;

	/*
	 * Later labels will be converted to class then EPSILON can be implemented
	 * as null movement for now because '.' can accept any char, I have just
	 * added '.' as EPSILON move
	 */
	public static final char EPS = '.';
	public static final char STAR = '*';
	public static final char PLUS = '+';
	public static final char QUEST = '?';

	public Matcher compile(String regex) {
		for (int i = 0; i < regex.length(); i++) {
			char label = regex.charAt(i);

			switch (label) {
			default:
				defaultChar(label);
				prevChar = label;
				break;
			case Pattern.EPS:
				dotChar(EPS);
				break;
			case Pattern.STAR:
				starChar();
				break;
			case Pattern.PLUS:
				plusChar();
				break;
			case Pattern.QUEST:
				questChar();
				break;
			}
		}
		if (nfa == null) {
			nfa = createSingleEdgeNFA();
		}
		nfa.getEndState().setFinal(true);
		matcher = new Matcher(nfa);
		return matcher;
	}

	public void defaultChar(char label) {
		Edge edge;
		State endState = new State();
		if (nfa == null) {
			nfa = new NFA();
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
		endState.getPrevEdgeMap().put(label, edge);
	}

	public void dotChar(char label) {
		State endState = new State();
		nfa.getEndState().getEpsilonEdge()
				.add(new Edge(nfa.getEndState(), endState, label));
		nfa.setEndState(endState);
	}

	public void plusChar() {
		State nfaEndState = nfa.getEndState();
		nfaEndState.getEdgeMap().put(prevChar,
				new Edge(nfaEndState, nfaEndState, prevChar));
	}

	public void starChar() {
		State nfaEndState = nfa.getEndState();
		State prevState = getPrevState(nfaEndState);

		prevState.getEdgeMap().put(prevChar,
				new Edge(prevState, prevState, prevChar));
		nfa.setEndState(prevState);
	}

	public void questChar() {
		State nfaEndState = nfa.getEndState();
		State prevState = getPrevState(nfaEndState);
		prevState.getEpsilonEdge().add(
				new Edge(prevState, nfaEndState, Pattern.EPS));
	}

	public State getPrevState(State currState) {
		return currState.getPrevEdgeMap().get(prevChar).getSource();
	}

	public NFA createSingleEdgeNFA() {
		State startState = new State();
		State finalState = new State();
		startState.getEpsilonEdge().add(
				new Edge(startState, finalState, Pattern.EPS));
		NFA nfa = new NFA();
		nfa.setStartState(startState);
		nfa.setEndState(finalState);
		return nfa;
	}
}
