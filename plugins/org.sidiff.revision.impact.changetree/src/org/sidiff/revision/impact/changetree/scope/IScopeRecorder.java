package org.sidiff.revision.impact.changetree.scope;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface IScopeRecorder {
	
	public static final IScopeRecorder DUMMY = new IScopeRecorder() {
		
		@Override
		public void addElement(Object modelElement) {
		}
		
		@Override
		public Set<EObject> getScope() {
			return Collections.emptySet();
		}
		
		@Override
		public void addReference(EObject source, EObject target, EReference type) {
		}

		@Override
		public List<ReferenceScope> getOutgoings(EObject source) {
			return Collections.emptyList();
		}

		@Override
		public void addAttribute(EObject object, Object value, EAttribute type) {
		}

		@Override
		public List<AttributeScope> getAttributes(EObject object) {
			return Collections.emptyList();
		}

		@Override
		public void addEqualityTest(EObject object, Object value, EAttribute type) {
		}

		@Override
		public List<AttributeScope> getEqualityTests() {
			return Collections.emptyList();
		}
		
		@Override
		public String toString() {
			return "<DUMMY>";
		}
	};

	void addElement(Object modelElement);
	
	Set<EObject> getScope();
	
	void addReference(EObject source, EObject target, EReference type);
	
	List<ReferenceScope> getOutgoings(EObject source);
	
	void addAttribute(EObject object, Object value, EAttribute type);
	
	List<AttributeScope> getAttributes(EObject object);
	
	void addEqualityTest(EObject object, Object value, EAttribute type);
	
	List<AttributeScope> getEqualityTests();
}
