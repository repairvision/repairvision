package org.sidiff.consistency.graphpattern.sandbox.algorithms;

import java.util.List;

import org.sidiff.consistency.graphpattern.sandbox.graph.Example;
import org.sidiff.consistency.graphpattern.sandbox.graph.Match;

public interface IMatchingEngine {

	List<Match> getMatches(Example example);
}
