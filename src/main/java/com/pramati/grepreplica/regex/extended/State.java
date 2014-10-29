package com.pramati.grepreplica.regex.extended;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {
	private final int stateId;
	private final Map<Character, Edge> edgeMap = new HashMap<Character, Edge>();
	private Map<Character, Edge> prevEdgeMap = new HashMap<Character, Edge>();
	private List<Edge> epsilonEdge = new ArrayList<Edge>();
	private boolean isFinal = false;
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

	public List<Edge> getEpsilonEdge() {
		return epsilonEdge;
	}

	public void setEpsilonEdge(List<Edge> epsilonEdge) {
		this.epsilonEdge = epsilonEdge;
	}

	public Map<Character, Edge> getPrevEdgeMap() {
		return prevEdgeMap;
	}

	public void setPrevEdgeMap(Map<Character, Edge> preEdgeMap) {
		this.prevEdgeMap = preEdgeMap;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
}
