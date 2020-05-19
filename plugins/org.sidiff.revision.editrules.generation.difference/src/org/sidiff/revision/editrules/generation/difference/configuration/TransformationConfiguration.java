package org.sidiff.revision.editrules.generation.difference.configuration;

import org.sidiff.revision.editrules.generation.difference.configuration.filters.FilterConfiguration;

public class TransformationConfiguration {
	
	private String editRuleName;
	
	private String unknownNamesPrefix = "N";

	private SymmetricModelDifference difference;
	
	private FilterConfiguration filters;
	
	public TransformationConfiguration(
			String editRuleName,
			SymmetricModelDifference difference, 
			FilterConfiguration filters) {
		
		this.editRuleName = editRuleName;
		this.difference = difference;
		this.filters = filters;
	}

	public TransformationConfiguration(String editRuleName, SymmetricModelDifference difference) {
		this(editRuleName, difference, new FilterConfiguration());
	}

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
	
	public SymmetricModelDifference getDifference() {
		return difference;
	}

	public void setDifference(SymmetricModelDifference difference) {
		this.difference = difference;
	}

	public FilterConfiguration getFilters() {
		return filters;
	}
	
	public void setFilters(FilterConfiguration filters) {
		this.filters = filters;
	}
	
}
