package org.sidiff.validation.constraint.uml;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

import org.sidiff.validation.constraint.project.registry.*;

import org.sidiff.validation.constraint.interpreter.*;
import org.sidiff.validation.constraint.interpreter.formulas.*;
import org.sidiff.validation.constraint.interpreter.formulas.binary.*;
import org.sidiff.validation.constraint.interpreter.formulas.predicates.*;
import org.sidiff.validation.constraint.interpreter.formulas.predicates.collections.*;
import org.sidiff.validation.constraint.interpreter.formulas.predicates.integers.*;
import org.sidiff.validation.constraint.interpreter.formulas.predicates.types.*;
import org.sidiff.validation.constraint.interpreter.formulas.quantifiers.*;
import org.sidiff.validation.constraint.interpreter.formulas.unary.*;
import org.sidiff.validation.constraint.interpreter.terms.*;
import org.sidiff.validation.constraint.interpreter.terms.constants.*;
import org.sidiff.validation.constraint.interpreter.terms.functions.*;
import org.sidiff.validation.constraint.interpreter.terms.functions.collections.*;
import org.sidiff.validation.constraint.interpreter.terms.functions.navigation.*;
import org.sidiff.validation.constraint.interpreter.terms.functions.strings.*;

public class UMLConsistencyRules implements IConstraintLibrary {
	
	private String name = "UMLConsistency Rules";
	
	private Set<String> domains;
	
	private Set<String> documentTypes;
	
	private Map<String, IConstraint> constraints;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Set<String> getDomains() {
		
		if (domains == null) {
			this.domains = new LinkedHashSet<>();
			 
			addDomain("http://www.eclipse.org/uml2/5.0.0/UML");
		}
		
		return domains;
	}
	
	private void addDomain(String domain) {
		domains.add(domain);
	}
	
	@Override
	public Set<String> getDocumentTypes() {
		
		if (documentTypes == null) {
			documentTypes = new LinkedHashSet<>();
			
			addDocumentType("http://www.eclipse.org/uml2/5.0.0/UML");
		}
		
		return documentTypes;
	}
	
	private void addDocumentType(String documentType) {
		documentTypes.add(documentType);
	}
	
	public Map<String, IConstraint> getConstraintEntries() {
		
		if (constraints == null) {
			constraints = new LinkedHashMap<>();
		
			addConstraint(createInconsistency_MessageSignatureConstraint());
			addConstraint(createInconsistency_MessageConnectionConstraint());
			addConstraint(createInconsistency_UnimplementedRealizationConstraint());
			addConstraint(createInconsistency_DanglingTransitionConstraint());
			addConstraint(createInconsistency_TransitionWithoutTriggerConstraint());
			addConstraint(createInconsistency_UntypedLifelineConstraint());
			addConstraint(createInconsistency_UntypedPropertyConstraint());
			addConstraint(createMissingFeature_CallEvent_OperationConstraint());
			addConstraint(createMissingFeature_Trigger_EventConstraint());
			addConstraint(createMissingFeature_ActionExecutionSpecification_actionConstraint());
		}
		
		return constraints;
	}
	
	private void addConstraint(IConstraint rule) {
		constraints.put(rule.getName(), rule);
	}
	
	@Override
	public List<IConstraint> getConstraints() {
		return new ArrayList<>(getConstraintEntries().values());
	}
	
	@Override
	public IConstraint getConstraint(String name) {
		return getConstraintEntries().get(name);
	}
	
	public static IConstraint createInconsistency_MessageSignatureConstraint() {
		
		Variable v_m = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.MESSAGE, "m");
		Variable v_o1 = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.OPERATION, "o1");
		Variable v_l = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.LIFELINE, "l");
		Variable v_o2 = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.OPERATION, "o2");
		
		Term t_signature = new Get(v_m, org.eclipse.uml2.uml.UMLPackage.Literals.MESSAGE__SIGNATURE);
		Term t_name = new Get(v_o1, org.eclipse.uml2.uml.UMLPackage.Literals.NAMED_ELEMENT__NAME);
		Term t_name_1 = new Get(v_m, org.eclipse.uml2.uml.UMLPackage.Literals.NAMED_ELEMENT__NAME);
		Term t_receiveEvent_covered = new Get(new Get(v_m, org.eclipse.uml2.uml.UMLPackage.Literals.MESSAGE__RECEIVE_EVENT), org.eclipse.uml2.uml.UMLPackage.Literals.INTERACTION_FRAGMENT__COVERED);
		Term t_represents_type_ownedOperation = new Get(new Get(new Get(v_l, org.eclipse.uml2.uml.UMLPackage.Literals.LIFELINE__REPRESENTS), org.eclipse.uml2.uml.UMLPackage.Literals.TYPED_ELEMENT__TYPE), org.eclipse.uml2.uml.UMLPackage.Literals.CLASS__OWNED_OPERATION);
		Term t_signature_1 = new Get(v_m, org.eclipse.uml2.uml.UMLPackage.Literals.MESSAGE__SIGNATURE);
		
		Formula formula = new And(new Exists(v_o1, t_signature, new Equality(t_name, t_name_1)), new ForAll(v_l, t_receiveEvent_covered, new Exists(v_o2, t_represents_type_ownedOperation, new Equality(v_o2, t_signature_1))));
		
		IConstraint constraint_Inconsistency_MessageSignature = new Constraint(org.eclipse.uml2.uml.UMLPackage.Literals.MESSAGE, v_m, formula);
		constraint_Inconsistency_MessageSignature.setName("Inconsistency_MessageSignature");
		constraint_Inconsistency_MessageSignature.setMessage("Message without operation signature in the receiving class");
		
		return constraint_Inconsistency_MessageSignature;
	}
	
	public static IConstraint createInconsistency_MessageConnectionConstraint() {
		
		Variable v_m = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.MESSAGE, "m");
		Variable v_l1 = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.LIFELINE, "l1");
		Variable v_l2 = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.LIFELINE, "l2");
		Variable v_a = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.TYPED_ELEMENT, "a");
		
		Term t_receiveEvent_covered = new Get(new Get(v_m, org.eclipse.uml2.uml.UMLPackage.Literals.MESSAGE__RECEIVE_EVENT), org.eclipse.uml2.uml.UMLPackage.Literals.INTERACTION_FRAGMENT__COVERED);
		Term t_sendEvent_covered = new Get(new Get(v_m, org.eclipse.uml2.uml.UMLPackage.Literals.MESSAGE__SEND_EVENT), org.eclipse.uml2.uml.UMLPackage.Literals.INTERACTION_FRAGMENT__COVERED);
		Term t_represents_type_ownedAttribute = new Get(new Get(new Get(v_l2, org.eclipse.uml2.uml.UMLPackage.Literals.LIFELINE__REPRESENTS), org.eclipse.uml2.uml.UMLPackage.Literals.TYPED_ELEMENT__TYPE), org.eclipse.uml2.uml.UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE);
		Term t_type = new Get(v_a, org.eclipse.uml2.uml.UMLPackage.Literals.TYPED_ELEMENT__TYPE);
		Term t_represents_type = new Get(new Get(v_l1, org.eclipse.uml2.uml.UMLPackage.Literals.LIFELINE__REPRESENTS), org.eclipse.uml2.uml.UMLPackage.Literals.TYPED_ELEMENT__TYPE);
		
		Formula formula = new Exists(v_l1, t_receiveEvent_covered, new Exists(v_l2, t_sendEvent_covered, new Exists(v_a, t_represents_type_ownedAttribute, new Equality(t_type, t_represents_type))));
		
		IConstraint constraint_Inconsistency_MessageConnection = new Constraint(org.eclipse.uml2.uml.UMLPackage.Literals.MESSAGE, v_m, formula);
		constraint_Inconsistency_MessageConnection.setName("Inconsistency_MessageConnection");
		constraint_Inconsistency_MessageConnection.setMessage("A message can only be send between lifelines which are connected by an association");
		
		return constraint_Inconsistency_MessageConnection;
	}
	
	public static IConstraint createInconsistency_UnimplementedRealizationConstraint() {
		
		Variable v_realization = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.REALIZATION, "realization");
		Variable v_supplier = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.INTERFACE, "supplier");
		Variable v_op_interface = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.OPERATION, "op_interface");
		Variable v_client = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.CLASS, "client");
		Variable v_op_class = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.OPERATION, "op_class");
		
		Term t_supplier = new Get(v_realization, org.eclipse.uml2.uml.UMLPackage.Literals.DEPENDENCY__SUPPLIER);
		Term t_ownedOperation = new Get(v_supplier, org.eclipse.uml2.uml.UMLPackage.Literals.INTERFACE__OWNED_OPERATION);
		Term t_client = new Get(v_realization, org.eclipse.uml2.uml.UMLPackage.Literals.DEPENDENCY__CLIENT);
		Term t_ownedOperation_1 = new Get(v_client, org.eclipse.uml2.uml.UMLPackage.Literals.CLASS__OWNED_OPERATION);
		Term t_name = new Get(v_op_interface, org.eclipse.uml2.uml.UMLPackage.Literals.NAMED_ELEMENT__NAME);
		Term t_name_1 = new Get(v_op_class, org.eclipse.uml2.uml.UMLPackage.Literals.NAMED_ELEMENT__NAME);
		
		Formula formula = new ForAll(v_supplier, t_supplier, new ForAll(v_op_interface, t_ownedOperation, new ForAll(v_client, t_client, new Exists(v_op_class, t_ownedOperation_1, new Equality(t_name, t_name_1)))));
		
		IConstraint constraint_Inconsistency_UnimplementedRealization = new Constraint(org.eclipse.uml2.uml.UMLPackage.Literals.REALIZATION, v_realization, formula);
		constraint_Inconsistency_UnimplementedRealization.setName("Inconsistency_UnimplementedRealization");
		constraint_Inconsistency_UnimplementedRealization.setMessage("Unimplemented realization");
		
		return constraint_Inconsistency_UnimplementedRealization;
	}
	
	public static IConstraint createInconsistency_DanglingTransitionConstraint() {
		
		Variable v_t = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.TRANSITION, "t");
		
		Term t_source = new Get(v_t, org.eclipse.uml2.uml.UMLPackage.Literals.TRANSITION__SOURCE);
		Term t_target = new Get(v_t, org.eclipse.uml2.uml.UMLPackage.Literals.TRANSITION__TARGET);
		
		Formula formula = new And(new Not(new IsEmpty(t_source)), new Not(new IsEmpty(t_target)));
		
		IConstraint constraint_Inconsistency_DanglingTransition = new Constraint(org.eclipse.uml2.uml.UMLPackage.Literals.TRANSITION, v_t, formula);
		constraint_Inconsistency_DanglingTransition.setName("Inconsistency_DanglingTransition");
		constraint_Inconsistency_DanglingTransition.setMessage("A transition must have a source and a target state");
		
		return constraint_Inconsistency_DanglingTransition;
	}
	
	public static IConstraint createInconsistency_TransitionWithoutTriggerConstraint() {
		
		Variable v_t = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.TRANSITION, "t");
		
		Term t_source = new Get(v_t, org.eclipse.uml2.uml.UMLPackage.Literals.TRANSITION__SOURCE);
		Term t_target = new Get(v_t, org.eclipse.uml2.uml.UMLPackage.Literals.TRANSITION__TARGET);
		Term t_trigger = new Get(v_t, org.eclipse.uml2.uml.UMLPackage.Literals.TRANSITION__TRIGGER);
		
		Formula formula = new If(new And(new Not(new IsInstanceOf(t_source, org.eclipse.uml2.uml.UMLPackage.Literals.PSEUDOSTATE)), new Not(new IsInstanceOf(t_target, org.eclipse.uml2.uml.UMLPackage.Literals.FINAL_STATE))), new Not(new IsEmpty(t_trigger)));
		
		IConstraint constraint_Inconsistency_TransitionWithoutTrigger = new Constraint(org.eclipse.uml2.uml.UMLPackage.Literals.TRANSITION, v_t, formula);
		constraint_Inconsistency_TransitionWithoutTrigger.setName("Inconsistency_TransitionWithoutTrigger");
		constraint_Inconsistency_TransitionWithoutTrigger.setMessage("Transition without trigger");
		
		return constraint_Inconsistency_TransitionWithoutTrigger;
	}
	
	public static IConstraint createInconsistency_UntypedLifelineConstraint() {
		
		Variable v_l = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.LIFELINE, "l");
		
		Term t_represents = new Get(v_l, org.eclipse.uml2.uml.UMLPackage.Literals.LIFELINE__REPRESENTS);
		
		Formula formula = new Not(new IsEmpty(t_represents));
		
		IConstraint constraint_Inconsistency_UntypedLifeline = new Constraint(org.eclipse.uml2.uml.UMLPackage.Literals.LIFELINE, v_l, formula);
		constraint_Inconsistency_UntypedLifeline.setName("Inconsistency_UntypedLifeline");
		constraint_Inconsistency_UntypedLifeline.setMessage("A lifeline must represent a type");
		
		return constraint_Inconsistency_UntypedLifeline;
	}
	
	public static IConstraint createInconsistency_UntypedPropertyConstraint() {
		
		Variable v_p = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.PROPERTY, "p");
		
		Term t_type = new Get(v_p, org.eclipse.uml2.uml.UMLPackage.Literals.TYPED_ELEMENT__TYPE);
		
		Formula formula = new Not(new IsEmpty(t_type));
		
		IConstraint constraint_Inconsistency_UntypedProperty = new Constraint(org.eclipse.uml2.uml.UMLPackage.Literals.PROPERTY, v_p, formula);
		constraint_Inconsistency_UntypedProperty.setName("Inconsistency_UntypedProperty");
		constraint_Inconsistency_UntypedProperty.setMessage("A propery must have a type");
		
		return constraint_Inconsistency_UntypedProperty;
	}
	
	public static IConstraint createMissingFeature_CallEvent_OperationConstraint() {
		
		Variable v_ce = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.CALL_EVENT, "ce");
		
		Term t_operation = new Get(v_ce, org.eclipse.uml2.uml.UMLPackage.Literals.CALL_EVENT__OPERATION);
		
		Formula formula = new Not(new IsEmpty(t_operation));
		
		IConstraint constraint_MissingFeature_CallEvent_Operation = new Constraint(org.eclipse.uml2.uml.UMLPackage.Literals.CALL_EVENT, v_ce, formula);
		constraint_MissingFeature_CallEvent_Operation.setName("MissingFeature_CallEvent_Operation");
		constraint_MissingFeature_CallEvent_Operation.setMessage("The required feature 'operation' of <Call Event> must be set");
		
		return constraint_MissingFeature_CallEvent_Operation;
	}
	
	public static IConstraint createMissingFeature_Trigger_EventConstraint() {
		
		Variable v_t = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.TRIGGER, "t");
		
		Term t_event = new Get(v_t, org.eclipse.uml2.uml.UMLPackage.Literals.TRIGGER__EVENT);
		
		Formula formula = new Not(new IsEmpty(t_event));
		
		IConstraint constraint_MissingFeature_Trigger_Event = new Constraint(org.eclipse.uml2.uml.UMLPackage.Literals.TRIGGER, v_t, formula);
		constraint_MissingFeature_Trigger_Event.setName("MissingFeature_Trigger_Event");
		constraint_MissingFeature_Trigger_Event.setMessage("The required feature 'event' of <Trigger> must be set");
		
		return constraint_MissingFeature_Trigger_Event;
	}
	
	public static IConstraint createMissingFeature_ActionExecutionSpecification_actionConstraint() {
		
		Variable v_a = new Variable(org.eclipse.uml2.uml.UMLPackage.Literals.ACTION_EXECUTION_SPECIFICATION, "a");
		
		Term t_action = new Get(v_a, org.eclipse.uml2.uml.UMLPackage.Literals.ACTION_EXECUTION_SPECIFICATION__ACTION);
		
		Formula formula = new Not(new IsEmpty(t_action));
		
		IConstraint constraint_MissingFeature_ActionExecutionSpecification_action = new Constraint(org.eclipse.uml2.uml.UMLPackage.Literals.ACTION_EXECUTION_SPECIFICATION, v_a, formula);
		constraint_MissingFeature_ActionExecutionSpecification_action.setName("MissingFeature_ActionExecutionSpecification_action");
		constraint_MissingFeature_ActionExecutionSpecification_action.setMessage("The required feature 'action' of <Action Execution Specification> must be set");
		
		return constraint_MissingFeature_ActionExecutionSpecification_action;
	}
	
}
