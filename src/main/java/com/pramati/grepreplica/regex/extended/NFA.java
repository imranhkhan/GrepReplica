package com.pramati.grepreplica.regex.extended;

public class NFA {

	private State startState;
	private State endState;

	public State getStartState() {
		return startState;
	}

	public State getEndState() {
		return endState;
	}

	public void setStartState(State startState) {
		this.startState = startState;
	}

	public void setEndState(State endState) {
		this.endState = endState;
	}
}
