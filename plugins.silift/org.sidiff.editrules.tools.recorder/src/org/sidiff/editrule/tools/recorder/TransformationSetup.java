package org.sidiff.editrule.tools.recorder;

import java.util.Collection;

import org.sidiff.editrule.tools.recorder.filters.IAttributeFilter;
import org.sidiff.editrule.tools.recorder.filters.IObjectFilter;
import org.sidiff.editrule.tools.recorder.filters.IReferenceFilter;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;

public class TransformationSetup {
	
	protected String editRuleName;
	
	protected String unknownNamesPrefix = "N";

	protected Collection<Correspondence> correspondences;
	
	protected Collection<Change> changes;
	
	protected IObjectFilter contextObjectFilter = IObjectFilter.DUMMY;
	
	protected IAttributeFilter contextAttributeFilter = IAttributeFilter.DUMMY;
	
	protected IReferenceFilter contextReferenceFilter = IReferenceFilter.DUMMY;

	public String getEditRuleName() {
		return editRuleName;
	}

	public void setEditRuleName(String editRuleName) {
		this.editRuleName = editRuleName;
	}

	public String getUnknownNamesPrefix() {
		return unknownNamesPrefix;
	}

	public void setUnknownNamesPrefix(String unknownNamesPrefix) {
		this.unknownNamesPrefix = unknownNamesPrefix;
	}

	public Collection<Correspondence> getCorrespondences() {
		return correspondences;
	}

	public void setCorrespondences(Collection<Correspondence> correspondences) {
		this.correspondences = correspondences;
	}

	public Collection<Change> getChanges() {
		return changes;
	}

	public void setChanges(Collection<Change> changes) {
		this.changes = changes;
	}

	public IObjectFilter getContextObjectFilter() {
		return contextObjectFilter;
	}

	public void setContextObjectFilter(IObjectFilter contextObjectFilter) {
		this.contextObjectFilter = contextObjectFilter;
	}

	public IAttributeFilter getContextAttributeFilter() {
		return contextAttributeFilter;
	}

	public void setContextAttributeFilter(IAttributeFilter contextAttributeFilter) {
		this.contextAttributeFilter = contextAttributeFilter;
	}

	public IReferenceFilter getContextReferenceFilter() {
		return contextReferenceFilter;
	}

	public void setContextReferenceFilter(IReferenceFilter contextReferenceFilter) {
		this.contextReferenceFilter = contextReferenceFilter;
	}
}
