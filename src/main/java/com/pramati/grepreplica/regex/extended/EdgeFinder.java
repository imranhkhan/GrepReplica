package com.pramati.grepreplica.regex.extended;

import java.util.List;

public class EdgeFinder {

	public Edge findEdge(State state, char label) {
		Edge edge = getDotEdge(state);
		if (edge == null) {
			edge = getLabledEdge(state, label);
		}
		return edge;
	}

	private Edge getLabledEdge(State state, char label) {
		Edge edge = state.getEdgeMap().get(label);
		if (edge == null) {
			List<Edge> epsEdges = state.getEpsilonEdge();
			if (epsEdges.size() > 0) {
				edge = getEdgeByEpsilonTransition(epsEdges, label);
			}
		}
		return edge;
	}

	private Edge getDotEdge(State state) {
		if (state.getEdgeMap().size() == 0
				&& state.getEpsilonEdge().size() == 1) {
			return state.getEpsilonEdge().get(0);
		}
		return null;
	}

	private Edge getEdgeByEpsilonTransition(List<Edge> epsEdges, char label) {
		Edge edge = null;
		for (Edge epsEdge : epsEdges) {
			State destState = epsEdge.getDest();
			if (destState.getEdgeMap().get(label) != null) {
				edge = destState.getEdgeMap().get(label);
				break;
			}
		}
		return edge;
	}
}
