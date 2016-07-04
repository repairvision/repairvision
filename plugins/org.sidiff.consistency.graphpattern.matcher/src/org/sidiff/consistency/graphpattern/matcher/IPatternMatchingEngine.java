package org.sidiff.consistency.graphpattern.matcher;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.Visitor;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;
import org.sidiff.consistency.graphpattern.matcher.tools.CrossReferencer;
import org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper;
import org.sidiff.consistency.graphpattern.matcher.wgraph.IConstraintTester;

public interface IPatternMatchingEngine {

	public void initialize(Map<NodePattern, Collection<EObject>> variableNodeMatching);
	
	public List<NodePattern> getGraphPattern();
	
	public void setGraphPattern(List<NodePattern> graphPattern); 
	
	public List<NodePattern> getVariableNodes();
	
	public void start();
	
	public void finish();
	
	public DataStore createDataStore();
	
	public Visitor createVisitor();
	
	public MatchingHelper getMatchingHelper();
	
	public CrossReferencer getCrossReferencer();
	
	public IConstraintTester getConstraintTester();
	
	public IAtomicPatternFactory getAtomicPatternFactory();
	
	public IMatchValidation getMatchValidation();
}
