package org.sidiff.consistency.graphpattern.matcher.matching.selection;

import org.sidiff.consistency.graphpattern.NodePattern;

public interface IAtomicPatternFactory {

	public AtomicPattern getAtomicPattern(PathSelector path, NodePattern node);
}
