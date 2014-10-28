package com.pramati.grepreplica.regex.extended;

import java.util.HashMap;
import java.util.Map;

public class State {
	private final int stateId;
	private Map<Character, Edge> edgeMap = new HashMap<Character, Edge>();

	private static int idcounter = 0;

	public State() {
		stateId = idcounter++;
	}

	public int getStateId() {
		return stateId;
	}

	public Map<Character, Edge> getEdgeMap() {
		return edgeMap;
	}

	public void setEdgeMap(Map<Character, Edge> edgeMap) {
		this.edgeMap = edgeMap;
	}

}
