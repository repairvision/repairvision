package org.sidiff.revision.editrules.generation.difference.configuration.filters;

public class DefaultFilter {

	private FilterConfiguration filters;
	
	public DefaultFilter(FilterConfiguration filters) {
		this.filters = filters;
	}

	public FilterConfiguration getFilters() {
		return filters;
	}
	
	public void setFilters(FilterConfiguration filterConfiguration) {
		this.filters = filterConfiguration;
	}
}
