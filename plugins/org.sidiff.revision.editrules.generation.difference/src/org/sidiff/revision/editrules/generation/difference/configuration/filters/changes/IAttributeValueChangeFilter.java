package org.sidiff.revision.editrules.generation.difference.configuration.filters.changes;

import org.sidiff.revision.difference.AttributeValueChange;

public interface IAttributeValueChangeFilter {

	public static final IAttributeValueChangeFilter FILTER_NONE = new IAttributeValueChangeFilter() {
		
		@Override
		public boolean filter(AttributeValueChange attributeValueChange) {
			return false;
		}
	};
	
	public static final IAttributeValueChangeFilter FILTER_ALL = new IAttributeValueChangeFilter() {
		
		@Override
		public boolean filter(AttributeValueChange attributeValueChange) {
			return true;
		}
	};
	
	boolean filter(AttributeValueChange attributeValueChange);
}
