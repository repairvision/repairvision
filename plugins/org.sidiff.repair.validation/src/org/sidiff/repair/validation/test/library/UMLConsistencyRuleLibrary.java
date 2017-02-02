package org.sidiff.repair.validation.test.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.uml2.uml.UMLPackage;
import org.sidiff.repair.validation.ConsistencyRule;
import org.sidiff.repair.validation.formulas.binary.And;
import org.sidiff.repair.validation.formulas.binary.Formula;
import org.sidiff.repair.validation.formulas.predicates.Equality;
import org.sidiff.repair.validation.formulas.predicates.IsEmpty;
import org.sidiff.repair.validation.formulas.quantifiers.Exists;
import org.sidiff.repair.validation.formulas.quantifiers.ForAll;
import org.sidiff.repair.validation.formulas.unary.Not;
import org.sidiff.repair.validation.terms.Term;
import org.sidiff.repair.validation.terms.Variable;
import org.sidiff.repair.validation.terms.functions.Get;

public class UMLConsistencyRuleLibrary extends ConsistencyRuleLibrary {

	private static String documentType = UMLPackage.eINSTANCE.getNsURI();
	
	private static UMLPackage UML = UMLPackage.eINSTANCE;

	private static Map<String, ConsistencyRule> rules = new HashMap<>();
	
	static {
		addConsistencyRule(createMessageBasedOnOperationRule());
		addConsistencyRule(createTransitionWithoutTriggerRule());
		addConsistencyRule(createUnimplementedRealizationRule());
	}
	
	private static void addConsistencyRule(ConsistencyRule rule) {
		rules.put(rule.getName(), rule);
	}
	
	@Override
	public String getDocumentType() {
		return documentType;
	}
	
	@Override
	public List<ConsistencyRule> getConsistencyRules() {
		return new ArrayList<>(rules.values());
	}

	@Override
	public ConsistencyRule getConsistencyRule(String name) {
		return rules.get(name);
	}
	
	public static ConsistencyRule createMessageBasedOnOperationRule() {
		
		// Create consistency rule:
		Variable m = new Variable("m");
		Variable l1 = new Variable("l1");
		Variable l2 = new Variable("l2");
		Variable l = new Variable("l");
		Variable a = new Variable("a");
		Variable o = new Variable("o");
		
		Term c1_m_receiveEvent_covered = new Get(new Get(m, 
				UML.getMessage_ReceiveEvent()), 
				UML.getInteractionFragment_Covered());
		
		Term c2_m_receiveEvent_covered = new Get(new Get(m, 
				UML.getMessage_ReceiveEvent()), 
				UML.getInteractionFragment_Covered());
		
		Term m_sendEvent_covered = new Get(new Get(m, 
				UML.getMessage_SendEvent()), 
				UML.getInteractionFragment_Covered());
		
		Term l2_represents_type_ownedAttribute = new Get(new Get(new Get(l2, 
				UML.getLifeline_Represents()),
				UML.getTypedElement_Type()), 
				UML.getStructuredClassifier_OwnedAttribute()); 
		
		Term l1_represents_type = new Get(new Get(l1,
				UML.getLifeline_Represents()),
				UML.getTypedElement_Type());
		
		Term a_type = new Get(a, 
				UML.getTypedElement_Type());
		
		Term l_represents_type_ownedOperation = new Get(new Get(new Get(l,
				UML.getLifeline_Represents()),
				UML.getTypedElement_Type()), 
				UML.getClass_OwnedOperation());
		
		Term m_name = new Get(m, 
				UML.getNamedElement_Name());
		
		Term o_name = new Get(o, 
				UML.getNamedElement_Name());

		Formula checkAssoziation = 
				new Exists(l1, c1_m_receiveEvent_covered, 
				new Exists(l2, m_sendEvent_covered,
				new Exists(a, l2_represents_type_ownedAttribute, 
				new Equality(a_type, l1_represents_type))));
		
		Formula checkNames = 
				new ForAll(l, c2_m_receiveEvent_covered, 
				new Exists(o, l_represents_type_ownedOperation, 
				new Equality(o_name, m_name)));
		
		Formula validation = new And(checkAssoziation, checkNames);
		
		ConsistencyRule messageBasedOnOperation = new ConsistencyRule(
				UML.getMessage(), m, validation);
		
		messageBasedOnOperation.setName("messageBasedOnOperation");
		
		return messageBasedOnOperation;
	}
	
	public static ConsistencyRule createTransitionWithoutTriggerRule() {
		
		// Create consistency rule:
		Variable transition = new Variable("transition");
		Variable trigger = new Variable("trigger");
		
		Formula validation = new Exists(
				trigger, 
				new Get(transition, UML.getTransition_Trigger()),
				new Not(new IsEmpty(transition))); 
		
		ConsistencyRule transitionWithoutTrigger = new ConsistencyRule(
				UML.getTransition(), transition, validation);
		
		transitionWithoutTrigger.setName("transitionWithoutTrigger");
		
		return transitionWithoutTrigger;
	}

	/**
	 * OCL:
	 * 
	 * context Realization inv: 
	 *   self.supplier.ownedOperation -> forAll (op_interface |
	 *   self.client.ownedOperation -> exists (op_class | op_interface.name = op_class.name))
	 * 
	 * @return The FOL consistency-rule.
	 */
	public static ConsistencyRule createUnimplementedRealizationRule() {
		
		// Create consistency rule:
		Variable realization = new Variable("realization");
		Variable op_interface = new Variable("op_interface");
		Variable op_class = new Variable("op_class");
		Variable supplier = new Variable("supplier");
		Variable client = new Variable("client");
		
		Formula validation = 
				new ForAll(supplier, new Get(realization, UML.getDependency_Supplier()),
						new ForAll(op_interface, new Get(supplier, UML.getInterface_OwnedOperation()),
								new ForAll(client, new Get(realization, UML.getDependency_Client()),
										new Exists(op_class, new Get(client, UML.getClass_OwnedOperation()),
												new Equality(
														new Get(op_interface, UML.getNamedElement_Name()), 
														new Get(op_class, UML.getNamedElement_Name())))))); 
		
		ConsistencyRule unimplementedRealization = new ConsistencyRule(
				UML.getRealization(), realization, validation);
		
		unimplementedRealization.setName("unimplementedRealization");
		
		return unimplementedRealization;
	}
}
