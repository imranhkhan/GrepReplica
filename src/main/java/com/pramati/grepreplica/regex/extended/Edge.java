package com.pramati.grepreplica.regex.extended;

public class Edge {
	private final State source;
	private final State dest;
	private final char label;

	public Edge(State source, State dest, char label) {
		this.source = source;
		this.dest = dest;
		this.label = label;
	}

	public State getSource() {
		return source;
	}

	public State getDest() {
		return dest;
	}

	public char getLabel() {
		return label;
	}
}
