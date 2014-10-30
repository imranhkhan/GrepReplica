package com.pramati.grepreplica.regex.extended;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {

	private boolean isFinal = false;
	private static int idcounter = 0;
	
	private final int stateId;
	private final Map<Character, Edge> edgeMap = new HashMap<Character, Edge>();
	private final Map<Character, Edge> prevEdgeMap = new HashMap<Character, Edge>();
	private final List<Edge> epsilonEdge = new ArrayList<Edge>();

	public State() {
		stateId = idcounter++;
	}

	public int getStateId() {
		return stateId;
	}

	public Map<Character, Edge> getEdgeMap() {
		return edgeMap;
	}

	public List<Edge> getEpsilonEdge() {
		return epsilonEdge;
	}

	public Map<Character, Edge> getPrevEdgeMap() {
		return prevEdgeMap;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
}
