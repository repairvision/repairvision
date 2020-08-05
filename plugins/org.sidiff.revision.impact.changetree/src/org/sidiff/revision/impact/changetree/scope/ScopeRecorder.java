package org.sidiff.revision.impact.changetree.scope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class ScopeRecorder implements IScopeRecorder {

	protected Set<EObject> scope = new HashSet<>();
	
	protected Map<EObject, List<ReferenceScope>> referenceScope = new HashMap<>();
	
	protected Map<EObject, List<AttributeScope>> attributeScope = new HashMap<>();
	
	protected List<AttributeScope> equalityTests = new ArrayList<>();
	
	public void addScope(ScopeRecorder scope) {
		scope.scope.forEach(this.scope::add);
		scope.referenceScope.forEach(this.referenceScope::put);
		scope.attributeScope.forEach(this.attributeScope::put);
		scope.equalityTests.forEach(this.equalityTests::add);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void addElement(Object element) {
		if (element instanceof EObject) {
			scope.add((EObject) element);
		} else if (element instanceof Collection<?>) {
			addElements((Collection<Object>) element);
		}
	}
	
	public void addElements(Collection<Object> elements) {
		for (Object element : elements) {
			addElement(element);
		}
	}
	
	@Override
	public Set<EObject> getScope() {
		return scope;
	}
	
	public void addReference(EObject source, EObject target, EReference type) {
		List<ReferenceScope> outgoings = referenceScope.getOrDefault(source, new ArrayList<>());
		referenceScope.put(source, outgoings);
		
		ReferenceScope reference = new ReferenceScope(source, target, type);
		outgoings.add(reference);
	}
	
	@Override
	public List<ReferenceScope> getOutgoings(EObject source) {
		return referenceScope.getOrDefault(source, Collections.emptyList());
	}
	
	@Override
	public void addAttribute(EObject object, Object value, EAttribute type) {
		List<AttributeScope> attributes = attributeScope.getOrDefault(object, new ArrayList<>());
		attributeScope.put(object, attributes);
		
		AttributeScope attribute = new AttributeScope(object, value, type);
		attributes.add(attribute);
	}

	@Override
	public List<AttributeScope> getAttributes(EObject object) {
		return attributeScope.getOrDefault(object, Collections.emptyList());
	}
	
	@Override
	public void addEqualityTest(EObject object, Object value, EAttribute type) {
		equalityTests.add(new AttributeScope(object, value, type));
	}

	@Override
	public List<AttributeScope> getEqualityTests() {
		return equalityTests;
	}
	
	public String toString(int indent) {
		StringBuffer string = new StringBuffer();
		
		// Scope tree:
		if (!scope.isEmpty()) {
			boolean first = true;
			
			for (EObject element : scope) {
				if (!first) {
					string.append("\n");
				} else {
					first = false;
				}
				appendIndent(indent, string);
				string.append(element);
			}
		} else {
			appendIndent(indent, string);
			string.append("<empty>");
		}
		
		// Equality tests:
		string.append("\n");
		
		for (AttributeScope attributeScope : equalityTests) {
			string.append("\n" + attributeScope);
		}
		
		return string.toString();
	}
	
	private void appendIndent(int indent, StringBuffer print) {
		for (int i = 0; i < indent; i++) {
			print.append(" ");
		}
	}
	
	@Override
	public String toString() {
		return toString(0);
	}
}
