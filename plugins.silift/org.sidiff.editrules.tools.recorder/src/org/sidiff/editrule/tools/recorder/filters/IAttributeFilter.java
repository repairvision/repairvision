package org.sidiff.editrule.tools.recorder.filters;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public interface IAttributeFilter {
	
	public static final IAttributeFilter DUMMY = new IAttributeFilter() {
		
		@Override
		public boolean filter(EObject object, Object value, EAttribute type) {
			return false;
		}
	};
	
	boolean filter(EObject object, Object value, EAttribute type);
}
