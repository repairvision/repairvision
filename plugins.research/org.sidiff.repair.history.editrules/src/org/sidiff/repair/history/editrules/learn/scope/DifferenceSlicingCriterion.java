package org.sidiff.repair.history.editrules.learn.scope;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.FilterConfiguration;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IAttributeFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IObjectFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IReferenceFilter;

public class DifferenceSlicingCriterion {

	// Historical Model //

	protected Set<EObject> historicalFragment;
	
	// Revised Model Extensions //

	protected int historicalFragmentDistance = -1;
	
	// Historical Model Filter //

	protected FilterConfiguration historicalFilters = new FilterConfiguration();

	// Revised Model //

	protected Set<EObject> revisedFragment;
	
	// Revised Model Extensions //

	protected int revisedFragmentDistance = -1;

	// Revised Model Filter //
	
	protected FilterConfiguration revisedFilters = new FilterConfiguration();

	// Meta-Model Filter //

	protected Set<EClass> classBlacklist;

	protected Set<EReference> referenceBlacklist;

	// Syntactic Extensions //

	/**
	 * Adds the direct corresponding container of all added/removed objects in
	 * the fragment.
	 */
	protected boolean addFirstCorrespondingContainer = true;

	/**
	 * Adds the corresponding container of all added/removed objects in the
	 * fragment until the root element of the model.
	 */
	protected boolean addAllCorrespondingContainers = false;

	/**
	 * Adds the direct added/removed container of all added/removed objects in
	 * the fragment.
	 */
	protected boolean addFirstChangedContainer = true;

	/**
	 * Adds the added/removed container of all added/removed objects in the
	 * fragment until the root element of the model.
	 */
	protected boolean addAllChangedContainers = false;

	public DifferenceSlicingCriterion() {
		this.historicalFragment = new HashSet<>();
		this.revisedFragment = new HashSet<>();

		this.classBlacklist = new HashSet<>();
		this.referenceBlacklist = new HashSet<>();
	}

	public Set<EObject> getHistoricalFragment() {
		return historicalFragment;
	}

	public void setHistoricalFragment(Set<EObject> historicalFragment) {
		this.historicalFragment = historicalFragment;
	}

	public int getHistoricalFragmentDistance() {
		return historicalFragmentDistance;
	}

	public void setHistoricalFragmentDistance(int historicalFragmentDistance) {
		this.historicalFragmentDistance = historicalFragmentDistance;
	}

	public IObjectFilter getHistoricalObjectFilter() {
		return historicalFilters.getObjectFilter();
	}

	public void setHistoricalObjectFilter(IObjectFilter historicalObjectFilter) {
		this.historicalFilters.setObjectFilter(historicalObjectFilter);
	}

	public IReferenceFilter getHistoricalReferenceFilter() {
		return historicalFilters.getReferenceFilter();
	}

	public void setHistoricalReferenceFilter(IReferenceFilter historicalReferenceFilter) {
		this.historicalFilters.setReferenceFilter(historicalReferenceFilter);
	}

	public IAttributeFilter getHistoricalAttributeFilter() {
		return historicalFilters.getAttributeFilter();
	}

	public void setHistoricalAttributeFilter(IAttributeFilter historicalAttributeFilter) {
		this.historicalFilters.setAttributeFilter(historicalAttributeFilter);
	}

	public Set<EObject> getRevisedFragment() {
		return revisedFragment;
	}

	public void setRevisedFragment(Set<EObject> revisedFragment) {
		this.revisedFragment = revisedFragment;
	}

	public int getRevisedFragmentDistance() {
		return revisedFragmentDistance;
	}

	public void setRevisedFragmentDistance(int revisedFragmentDistance) {
		this.revisedFragmentDistance = revisedFragmentDistance;
	}

	public IObjectFilter getRevisedObjectFilter() {
		return revisedFilters.getObjectFilter();
	}

	public void setRevisedObjectFilter(IObjectFilter revisedObjectFilter) {
		this.revisedFilters.setObjectFilter(revisedObjectFilter);
	}

	public IReferenceFilter getRevisedReferenceFilter() {
		return revisedFilters.getReferenceFilter();
	}

	public void setRevisedReferenceFilter(IReferenceFilter revisedReferenceFilter) {
		this.revisedFilters.setReferenceFilter(revisedReferenceFilter);
	}

	public IAttributeFilter getRevisedAttributeFilter() {
		return revisedFilters.getAttributeFilter();
	}

	public void setRevisedAttributeFilter(IAttributeFilter revisedAttributeFilter) {
		this.revisedFilters.setAttributeFilter(revisedAttributeFilter);
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

	public boolean isAddFirstCorrespondingContainer() {
		return addFirstCorrespondingContainer;
	}

	public void setAddFirstCorrespondingContainer(boolean addFirstCorrespondingContainer) {
		this.addFirstCorrespondingContainer = addFirstCorrespondingContainer;
	}

	public boolean isAddAllCorrespondingContainers() {
		return addAllCorrespondingContainers;
	}

	public void setAddAllCorrespondingContainers(boolean addAllCorrespondingContainers) {
		this.addAllCorrespondingContainers = addAllCorrespondingContainers;
	}

	public boolean isAddFirstChangedContainer() {
		return addFirstChangedContainer;
	}

	public void setAddFirstChangedContainer(boolean addFirstChangedContainer) {
		this.addFirstChangedContainer = addFirstChangedContainer;
	}

	public boolean isAddAllChangedContainers() {
		return addAllChangedContainers;
	}

	public void setAddAllChangedContainers(boolean addAllChangedContainers) {
		this.addAllChangedContainers = addAllChangedContainers;
	}
}
