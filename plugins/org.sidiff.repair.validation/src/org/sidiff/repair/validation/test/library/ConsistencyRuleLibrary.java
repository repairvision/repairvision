package org.sidiff.repair.validation.test.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sidiff.repair.validation.Constraint;

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
	
	public abstract List<Constraint> getConsistencyRules();
	
	public abstract Constraint getConsistencyRule(String name);
}
