package org.sidiff.graphpattern.sandbox.algorithms;

import java.util.List;

import org.sidiff.graphpattern.sandbox.graph.Example;
import org.sidiff.graphpattern.sandbox.graph.Match;

public interface IMatchingEngine {

	List<Match> getMatches(Example example);
}
