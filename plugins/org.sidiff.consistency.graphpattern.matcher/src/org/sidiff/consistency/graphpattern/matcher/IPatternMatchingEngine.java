package org.sidiff.consistency.graphpattern.matcher;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.GraphPattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.Visitor;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;

public interface IPatternMatchingEngine {

	public void initialize(Map<NodePattern, Collection<EObject>> seedSets);
	
	public GraphPattern getGraphPattern();
	
	public void setGraphPattern(GraphPattern graphPattern); 
	
	public List<NodePattern> getVariableNodes();
	
	public void start();
	
	public void finish();
	
	public DataStore createDataStore();
	
	public Visitor createVisitor();
	
	public IAtomicPatternFactory createAtomicPatternFactory();
	
	public IMatchValidation createMatchValidation();
	
}
