package org.sidiff.repair.history.editrules.learning;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class DifferenceSlicingCriterion {

	// Historical: Model A //
	
	protected EObject contextHistorical;
	
	protected Set<EObject> scopeHistorical; 
	
	protected int scopeHistoricalDistance = -1;
	
	protected Set<EObject> modelHistoricalBlacklist;
	
	// Resolved: Model C //
	
	protected EObject contextResolved;
	
	protected Set<EObject> scopeResolved;
	
	protected int scopeResolvedDistance = -1;
	
	protected Set<EObject> modelResolvedBlacklist;
	
	// Meta-Model //
	
	protected Set<EClass> classBlacklist;
	
	protected Set<EReference> referenceBlacklist;
	
	public DifferenceSlicingCriterion() {
		this.scopeHistorical = new HashSet<>();
		this.scopeResolved = new HashSet<>();
		
		this.modelHistoricalBlacklist = new HashSet<>();
		this.modelResolvedBlacklist = new HashSet<>();
		
		this.classBlacklist = new HashSet<>();
		this.referenceBlacklist = new HashSet<>();
	}

	public EObject getContextHistorical() {
		return contextHistorical;
	}

	public void setContextHistorical(EObject contextHistorical) {
		this.contextHistorical = contextHistorical;
	}

	public Set<EObject> getScopeHistorical() {
		return scopeHistorical;
	}

	public void setFragmentHistorical(Set<EObject> scopeHistorical) {
		this.scopeHistorical = scopeHistorical;
	}

	public int getScopeHistoricalDistance() {
		return scopeHistoricalDistance;
	}

	public void setScopeHistoricalDistance(int scopeHistoricalDistance) {
		this.scopeHistoricalDistance = scopeHistoricalDistance;
	}

	public Set<EObject> getModelHistoricalBlacklist() {
		return modelHistoricalBlacklist;
	}

	public void setModelHistoricalBlacklist(Set<EObject> modelHistoricalBlacklist) {
		this.modelHistoricalBlacklist = modelHistoricalBlacklist;
	}

	public EObject getContextResolved() {
		return contextResolved;
	}

	public void setContextResolved(EObject contextResolved) {
		this.contextResolved = contextResolved;
	}

	public Set<EObject> getScopeResolved() {
		return scopeResolved;
	}

	public void setFragmentResolved(Set<EObject> scopeResolved) {
		this.scopeResolved = scopeResolved;
	}

	public int getScopeResolvedDistance() {
		return scopeResolvedDistance;
	}

	public void setScopeResolvedDistance(int scopeResolvedDistance) {
		this.scopeResolvedDistance = scopeResolvedDistance;
	}

	public Set<EObject> getModelResolvedBlacklist() {
		return modelResolvedBlacklist;
	}

	public void setModelResolvedBlacklist(Set<EObject> modelResolvedBlacklist) {
		this.modelResolvedBlacklist = modelResolvedBlacklist;
	}

	public Set<EClass> getClassBlacklist() {
		return classBlacklist;
	}

	public void setClassBlacklist(Set<EClass> classBlacklist) {
		this.classBlacklist = classBlacklist;
	}

	public Set<EReference> getReferenceBlacklist() {
		return referenceBlacklist;
	}

	public void setReferenceBlacklist(Set<EReference> referenceBlacklist) {
		this.referenceBlacklist = referenceBlacklist;
	}
}
