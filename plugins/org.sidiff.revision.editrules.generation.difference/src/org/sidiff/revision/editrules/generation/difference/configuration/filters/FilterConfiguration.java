package org.sidiff.revision.editrules.generation.difference.configuration.filters;

import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.IAddAttributeFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.IAddObjectFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.IAddReferenceFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.IAttributeValueChangeFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.ICorrespondenceAttributeFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.ICorrespondenceObjectFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.ICorrespondenceReferenceFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.IRemoveAttributeFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.IRemoveObjectFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.IRemoveReferenceFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults.DefaultAddAttributeFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults.DefaultAddObjectFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults.DefaultAddReferenceFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults.DefaultAttributeValueChangeFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults.DefaultCorrespondenceAttributeFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults.DefaultCorrespondenceObjectFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults.DefaultCorrespondenceReference;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults.DefaultRemoveAttributeFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults.DefaultRemoveObjectFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.changes.defaults.DefaultRemoveReferenceFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IAttributeFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IObjectFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.IReferenceFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.defauls.DefaultAttributeFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.defauls.DefaultObjectFilter;
import org.sidiff.revision.editrules.generation.difference.configuration.filters.model.defauls.DefaultReferenceFilter;

public class FilterConfiguration {
	
	private IObjectFilter objectFilter;
	
	private IAttributeFilter attributeFilter;
	
	private IReferenceFilter referenceFilter;
	
	private ICorrespondenceObjectFilter correspondenceObjectFilter;
	
	private ICorrespondenceReferenceFilter correspondenceReferenceFilter;
	
	private ICorrespondenceAttributeFilter correspondenceAttributeFilter;
	
	private IAddObjectFilter addObjectFilter;
	
	private IAddReferenceFilter addReferenceFilter;
	
	private IAddAttributeFilter addAttributeFilter;
	
	private IRemoveObjectFilter removeObjectFilter;
	
	private IRemoveReferenceFilter removeReferenceFilter;
	
	private IRemoveAttributeFilter removeAttributeFilter;
	
	private IAttributeValueChangeFilter attributeValueChangeFilter;
	
	
	public FilterConfiguration() {
		this.objectFilter = new DefaultObjectFilter(this);
		this.attributeFilter = new DefaultAttributeFilter(this);
		this.referenceFilter = new DefaultReferenceFilter(this);
		
		this.correspondenceObjectFilter = new DefaultCorrespondenceObjectFilter(this);
		this.correspondenceReferenceFilter = new DefaultCorrespondenceReference(this);
		this.correspondenceAttributeFilter = new DefaultCorrespondenceAttributeFilter(this);
		this.addObjectFilter = new DefaultAddObjectFilter(this);
		this.addReferenceFilter = new DefaultAddReferenceFilter(this);
		this.removeObjectFilter = new DefaultRemoveObjectFilter(this);
		this.removeReferenceFilter = new DefaultRemoveReferenceFilter(this);
		this.removeAttributeFilter = new DefaultRemoveAttributeFilter(this);
		this.attributeValueChangeFilter = new DefaultAttributeValueChangeFilter(this);
		this.addAttributeFilter = new DefaultAddAttributeFilter(this);
	}

	public IObjectFilter getObjectFilter() {
		return objectFilter;
	}

	public void setObjectFilter(IObjectFilter contextObjectFilter) {
		this.objectFilter = contextObjectFilter;
	}

	public IAttributeFilter getAttributeFilter() {
		return attributeFilter;
	}

	public void setAttributeFilter(IAttributeFilter contextAttributeFilter) {
		this.attributeFilter = contextAttributeFilter;
	}

	public IReferenceFilter getReferenceFilter() {
		return referenceFilter;
	}

	public void setReferenceFilter(IReferenceFilter contextReferenceFilter) {
		this.referenceFilter = contextReferenceFilter;
	}
	
	public ICorrespondenceObjectFilter getCorrespondenceObjectFilter() {
		return correspondenceObjectFilter;
	}

	public void setCorrespondenceObjectFilter(ICorrespondenceObjectFilter correspondenceObjectFilter) {
		this.correspondenceObjectFilter = correspondenceObjectFilter;
	}
	
	public ICorrespondenceReferenceFilter getCorrespondenceReferenceFilter() {
		return correspondenceReferenceFilter;
	}

	public void setCorrespondenceReferenceFilter(ICorrespondenceReferenceFilter correspondenceReferenceFilter) {
		this.correspondenceReferenceFilter = correspondenceReferenceFilter;
	}

	public ICorrespondenceAttributeFilter getCorrespondenceAttributeFilter() {
		return correspondenceAttributeFilter;
	}

	public void setCorrespondenceAttributeFilter(ICorrespondenceAttributeFilter correspondenceAttributeFilter) {
		this.correspondenceAttributeFilter = correspondenceAttributeFilter;
	}

	public IAddObjectFilter getAddObjectFilter() {
		return addObjectFilter;
	}

	public void setAddObjectFilter(IAddObjectFilter addObjectFilter) {
		this.addObjectFilter = addObjectFilter;
	}

	public IAddReferenceFilter getAddReferenceFilter() {
		return addReferenceFilter;
	}

	public void setAddReferenceFilter(IAddReferenceFilter addReferenceFilter) {
		this.addReferenceFilter = addReferenceFilter;
	}

	public IAddAttributeFilter getAddAttributeFilter() {
		return addAttributeFilter;
	}

	public void setAddAttributeFilter(IAddAttributeFilter addAttributeFilter) {
		this.addAttributeFilter = addAttributeFilter;
	}

	public IRemoveObjectFilter getRemoveObjectFilter() {
		return removeObjectFilter;
	}

	public void setRemoveObjectFilter(IRemoveObjectFilter removeObjectFilter) {
		this.removeObjectFilter = removeObjectFilter;
	}

	public IRemoveReferenceFilter getRemoveReferenceFilter() {
		return removeReferenceFilter;
	}

	public void setRemoveReferenceFilter(IRemoveReferenceFilter removeReferenceFilter) {
		this.removeReferenceFilter = removeReferenceFilter;
	}
	
	public IRemoveAttributeFilter getRemoveAttributeFilter() {
		return removeAttributeFilter;
	}

	public void setRemoveAttributeFilter(IRemoveAttributeFilter removeAttributeFilter) {
		this.removeAttributeFilter = removeAttributeFilter;
	}

	public IAttributeValueChangeFilter getAttributeValueChangeFilter() {
		return attributeValueChangeFilter;
	}

	public void setAttributeValueChangeFilter(IAttributeValueChangeFilter attributeValueChangeFilter) {
		this.attributeValueChangeFilter = attributeValueChangeFilter;
	}
}
