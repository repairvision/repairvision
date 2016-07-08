package org.sidiff.consistency.repair.validation.test.library;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.consistency.repair.validation.ConsistencyRule;

public abstract class ConsistencyRuleLibrary {

	private static Map<String, ConsistencyRuleLibrary> libraries = new HashMap<>();
	
	static {
		// UML:
		UMLConsistencyRuleLibrary uml = new UMLConsistencyRuleLibrary();
		libraries.put(uml.getDocumentType(), uml);
	}
	
	public static ConsistencyRuleLibrary getConsistencyRuleLibrary(String documentType) {
		return libraries.get(documentType);
	}
	
	public abstract String getDocumentType();
	
	public abstract ConsistencyRule getConsistencyRule(String name);
}
