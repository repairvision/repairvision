package org.sidiff.repair.ui.peo.evaluation.recording;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class DifferenceSlicingCriterion {

	// Historical: Model A //
	
	protected EObject contextA;
	
	protected int contextADistance = -1;

	protected Set<EObject> scopeA; 
	
	protected int scopeADistance = -1;
	
	protected Set<EObject> modelABlacklist;
	
	// Introduced: Model B //
	
	protected EObject contextB;
	
	protected int contextBDistance = -1;
	
	protected Set<EObject> scopeB;
	
	protected int scopeBDistance = -1;
	
	protected Set<EObject> modelBBlacklist;
	
	// Resolved: Model C //
	
	protected EObject contextC;
	
	protected int contextCDistance = -1;
	
	protected Set<EObject> scopeC;
	
	protected int scopeCDistance = -1;
	
	protected Set<EObject> modelCBlacklist;
	
	// Meta-Model //
	
	protected Set<EClass> classBlacklist;
	
	protected Set<EReference> referenceBlacklist;
	
	public DifferenceSlicingCriterion() {
		this.scopeA = new HashSet<>();
		this.scopeB = new HashSet<>();
		this.modelABlacklist = new HashSet<>();
		this.modelBBlacklist = new HashSet<>();
	}

	public EObject getContextA() {
		return contextA;
	}

	public void setContextA(EObject contextA) {
		this.contextA = contextA;
	}

	public int getContextADistance() {
		return contextADistance;
	}

	public void setContextADistance(int contextADistance) {
		this.contextADistance = contextADistance;
	}

	public Set<EObject> getScopeA() {
		return scopeA;
	}

	public void setScopeA(Set<EObject> scopeA) {
		this.scopeA = scopeA;
	}

	public int getScopeADistance() {
		return scopeADistance;
	}

	public void setScopeADistance(int scopeADistance) {
		this.scopeADistance = scopeADistance;
	}

	public Set<EObject> getModelABlacklist() {
		return modelABlacklist;
	}

	public void setModelABlacklist(Set<EObject> modelABlacklist) {
		this.modelABlacklist = modelABlacklist;
	}

	public EObject getContextB() {
		return contextB;
	}

	public void setContextB(EObject contextB) {
		this.contextB = contextB;
	}

	public int getContextBDistance() {
		return contextBDistance;
	}

	public void setContextBDistance(int contextBDistance) {
		this.contextBDistance = contextBDistance;
	}

	public Set<EObject> getScopeB() {
		return scopeB;
	}

	public void setScopeB(Set<EObject> scopeB) {
		this.scopeB = scopeB;
	}

	public int getScopeBDistance() {
		return scopeBDistance;
	}

	public void setScopeBDistance(int scopeBDistance) {
		this.scopeBDistance = scopeBDistance;
	}

	public Set<EObject> getModelBBlacklist() {
		return modelBBlacklist;
	}

	public void setModelBBlacklist(Set<EObject> modelBBlacklist) {
		this.modelBBlacklist = modelBBlacklist;
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

	public EObject getContextC() {
		return contextC;
	}

	public void setContextC(EObject contextC) {
		this.contextC = contextC;
	}

	public int getContextCDistance() {
		return contextCDistance;
	}

	public void setContextCDistance(int contextCDistance) {
		this.contextCDistance = contextCDistance;
	}

	public Set<EObject> getScopeC() {
		return scopeC;
	}

	public void setScopeC(Set<EObject> scopeC) {
		this.scopeC = scopeC;
	}

	public int getScopeCDistance() {
		return scopeCDistance;
	}

	public void setScopeCDistance(int scopeCDistance) {
		this.scopeCDistance = scopeCDistance;
	}

	public Set<EObject> getModelCBlacklist() {
		return modelCBlacklist;
	}

	public void setModelCBlacklist(Set<EObject> modelCBlacklist) {
		this.modelCBlacklist = modelCBlacklist;
	}
}
