package UMLConsistencyRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.uml2.uml.UMLPackage;

import org.sidiff.validation.constraint.api.library.*;

import org.sidiff.validation.constraint.interpreter.*;
import org.sidiff.validation.constraint.interpreter.formulas.binary.*;
import org.sidiff.validation.constraint.interpreter.formulas.predicates.*;
import org.sidiff.validation.constraint.interpreter.formulas.quantifiers.*;
import org.sidiff.validation.constraint.interpreter.formulas.unary.*;
import org.sidiff.validation.constraint.interpreter.terms.*;
import org.sidiff.validation.constraint.interpreter.terms.functions.*;

public class ConstraintLibraryUMLPackage implements IConstraintLibrary {
	
	private static String documentType = UMLPackage.eINSTANCE.getNsURI();
		
	private static UMLPackage DOMAIN = UMLPackage.eINSTANCE;
	
	private static Map<String, IConstraint> rules = new HashMap<>();
		
	static {
		addConstraint(createInconsistency_MessageSignatureRule());
		addConstraint(createInconsistency_MessageConnectionRule());
		addConstraint(createInconsistency_UnimplementedRealizationRule());
		addConstraint(createInconsistency_DanglingTransitionRule());
		addConstraint(createInconsistency_TransitionWithoutTriggerRule());
		addConstraint(createInconsistency_UntypedLifelineRule());
		addConstraint(createInconsistency_UntypedPropertyRule());
		addConstraint(createMissingFeature_CallEvent_OperationRule());
		addConstraint(createMissingFeature_Trigger_EventRule());
	}
	
	private static void addConstraint(IConstraint rule) {
		rules.put(rule.getName(), rule);
	}
	
	@Override	
	public String getDocumentType() {
		return documentType;
	}
	
	@Override
	public List<IConstraint> getConstraints() {
		return new ArrayList<>(rules.values());
	}
	
	@Override
	public IConstraint getConstraint(String name) {
		return rules.get(name);
	}
	
	public static IConstraint createInconsistency_MessageSignatureRule() {
		
		Variable v0_m = new Variable("m");
		Variable v1_o1 = new Variable("o1");
		Variable v2_l = new Variable("l");
		Variable v3_o2 = new Variable("o2");
	
		Term t0_signature = new Get(v0_m, DOMAIN.getMessage_Signature());
		Term t1_name = new Get(v1_o1, DOMAIN.getNamedElement_Name());
		Term t2_name = new Get(v0_m, DOMAIN.getNamedElement_Name());
		Term t3_receiveEvent_covered = new Get(new Get(v0_m, DOMAIN.getMessage_ReceiveEvent()), DOMAIN.getInteractionFragment_Covered());
		Term t4_represents_type_ownedOperation = new Get(new Get(new Get(v2_l, DOMAIN.getLifeline_Represents()), DOMAIN.getTypedElement_Type()), DOMAIN.getClass_OwnedOperation());
		Term t5_signature = new Get(v0_m, DOMAIN.getMessage_Signature());
	
		Formula constraint0_Inconsistency_MessageSignature = new And(new Exists(v1_o1, t0_signature, new Equality(t1_name, t2_name)), new ForAll(v2_l, t3_receiveEvent_covered, new Exists(v3_o2, t4_represents_type_ownedOperation, new Equality(v3_o2, t5_signature))));
		
		IConstraint rule_Inconsistency_MessageSignature = new Constraint(DOMAIN.getMessage(), v0_m, constraint0_Inconsistency_MessageSignature);
		rule_Inconsistency_MessageSignature.setName("Inconsistency_MessageSignature");
		rule_Inconsistency_MessageSignature.setMessage("Message without operation signature in the receiving class");
		
		return rule_Inconsistency_MessageSignature;
	}
	
	public static IConstraint createInconsistency_MessageConnectionRule() {
		
		Variable v4_m = new Variable("m");
		Variable v5_l1 = new Variable("l1");
		Variable v6_l2 = new Variable("l2");
		Variable v7_a = new Variable("a");
	
		Term t6_receiveEvent_covered = new Get(new Get(v4_m, DOMAIN.getMessage_ReceiveEvent()), DOMAIN.getInteractionFragment_Covered());
		Term t7_sendEvent_covered = new Get(new Get(v4_m, DOMAIN.getMessage_SendEvent()), DOMAIN.getInteractionFragment_Covered());
		Term t8_represents_type_ownedAttribute = new Get(new Get(new Get(v6_l2, DOMAIN.getLifeline_Represents()), DOMAIN.getTypedElement_Type()), DOMAIN.getStructuredClassifier_OwnedAttribute());
		Term t9_type = new Get(v7_a, DOMAIN.getTypedElement_Type());
		Term t10_represents_type = new Get(new Get(v5_l1, DOMAIN.getLifeline_Represents()), DOMAIN.getTypedElement_Type());
	
		Formula constraint1_Inconsistency_MessageConnection = new Exists(v5_l1, t6_receiveEvent_covered, new Exists(v6_l2, t7_sendEvent_covered, new Exists(v7_a, t8_represents_type_ownedAttribute, new Equality(t9_type, t10_represents_type))));
		
		IConstraint rule_Inconsistency_MessageConnection = new Constraint(DOMAIN.getMessage(), v4_m, constraint1_Inconsistency_MessageConnection);
		rule_Inconsistency_MessageConnection.setName("Inconsistency_MessageConnection");
		rule_Inconsistency_MessageConnection.setMessage("A message can only be send between lifelines which are connected by an association");
		
		return rule_Inconsistency_MessageConnection;
	}
	
	public static IConstraint createInconsistency_UnimplementedRealizationRule() {
		
		Variable v8_realization = new Variable("realization");
		Variable v9_supplier = new Variable("supplier");
		Variable v10_op_interface = new Variable("op_interface");
		Variable v11_client = new Variable("client");
		Variable v12_op_class = new Variable("op_class");
	
		Term t11_supplier = new Get(v8_realization, DOMAIN.getDependency_Supplier());
		Term t12_ownedOperation = new Get(v9_supplier, DOMAIN.getInterface_OwnedOperation());
		Term t13_client = new Get(v8_realization, DOMAIN.getDependency_Client());
		Term t14_ownedOperation = new Get(v11_client, DOMAIN.getClass_OwnedOperation());
		Term t15_name = new Get(v10_op_interface, DOMAIN.getNamedElement_Name());
		Term t16_name = new Get(v12_op_class, DOMAIN.getNamedElement_Name());
	
		Formula constraint2_Inconsistency_UnimplementedRealization = new ForAll(v9_supplier, t11_supplier, new ForAll(v10_op_interface, t12_ownedOperation, new ForAll(v11_client, t13_client, new Exists(v12_op_class, t14_ownedOperation, new Equality(t15_name, t16_name)))));
		
		IConstraint rule_Inconsistency_UnimplementedRealization = new Constraint(DOMAIN.getRealization(), v8_realization, constraint2_Inconsistency_UnimplementedRealization);
		rule_Inconsistency_UnimplementedRealization.setName("Inconsistency_UnimplementedRealization");
		rule_Inconsistency_UnimplementedRealization.setMessage("Unimplemented realization");
		
		return rule_Inconsistency_UnimplementedRealization;
	}
	
	public static IConstraint createInconsistency_DanglingTransitionRule() {
		
		Variable v13_t = new Variable("t");
	
		Term t17_source = new Get(v13_t, DOMAIN.getTransition_Source());
		Term t18_target = new Get(v13_t, DOMAIN.getTransition_Target());
	
		Formula constraint3_Inconsistency_DanglingTransition = new And(new Not(new IsEmpty(t17_source)), new Not(new IsEmpty(t18_target)));
		
		IConstraint rule_Inconsistency_DanglingTransition = new Constraint(DOMAIN.getTransition(), v13_t, constraint3_Inconsistency_DanglingTransition);
		rule_Inconsistency_DanglingTransition.setName("Inconsistency_DanglingTransition");
		rule_Inconsistency_DanglingTransition.setMessage("A transition must have a source and a target state");
		
		return rule_Inconsistency_DanglingTransition;
	}
	
	public static IConstraint createInconsistency_TransitionWithoutTriggerRule() {
		
		Variable v14_t = new Variable("t");
	
		Term t19_source = new Get(v14_t, DOMAIN.getTransition_Source());
		Term t20_target = new Get(v14_t, DOMAIN.getTransition_Target());
		Term t21_trigger = new Get(v14_t, DOMAIN.getTransition_Trigger());
	
		Formula constraint4_Inconsistency_TransitionWithoutTrigger = new If(new And(new Not(new IsInstanceOf(t19_source, DOMAIN.getPseudostate())), new Not(new IsInstanceOf(t20_target, DOMAIN.getFinalState()))), new Not(new IsEmpty(t21_trigger)));
		
		IConstraint rule_Inconsistency_TransitionWithoutTrigger = new Constraint(DOMAIN.getTransition(), v14_t, constraint4_Inconsistency_TransitionWithoutTrigger);
		rule_Inconsistency_TransitionWithoutTrigger.setName("Inconsistency_TransitionWithoutTrigger");
		rule_Inconsistency_TransitionWithoutTrigger.setMessage("Transition without trigger");
		
		return rule_Inconsistency_TransitionWithoutTrigger;
	}
	
	public static IConstraint createInconsistency_UntypedLifelineRule() {
		
		Variable v15_l = new Variable("l");
	
		Term t22_represents = new Get(v15_l, DOMAIN.getLifeline_Represents());
	
		Formula constraint5_Inconsistency_UntypedLifeline = new Not(new IsEmpty(t22_represents));
		
		IConstraint rule_Inconsistency_UntypedLifeline = new Constraint(DOMAIN.getLifeline(), v15_l, constraint5_Inconsistency_UntypedLifeline);
		rule_Inconsistency_UntypedLifeline.setName("Inconsistency_UntypedLifeline");
		rule_Inconsistency_UntypedLifeline.setMessage("A lifeline must represent a type");
		
		return rule_Inconsistency_UntypedLifeline;
	}
	
	public static IConstraint createInconsistency_UntypedPropertyRule() {
		
		Variable v16_p = new Variable("p");
	
		Term t23_type = new Get(v16_p, DOMAIN.getTypedElement_Type());
	
		Formula constraint6_Inconsistency_UntypedProperty = new Not(new IsEmpty(t23_type));
		
		IConstraint rule_Inconsistency_UntypedProperty = new Constraint(DOMAIN.getProperty(), v16_p, constraint6_Inconsistency_UntypedProperty);
		rule_Inconsistency_UntypedProperty.setName("Inconsistency_UntypedProperty");
		rule_Inconsistency_UntypedProperty.setMessage("A propery must have a type");
		
		return rule_Inconsistency_UntypedProperty;
	}
	
	public static IConstraint createMissingFeature_CallEvent_OperationRule() {
		
		Variable v17_ce = new Variable("ce");
	
		Term t24_operation = new Get(v17_ce, DOMAIN.getCallEvent_Operation());
	
		Formula constraint7_MissingFeature_CallEvent_Operation = new Not(new IsEmpty(t24_operation));
		
		IConstraint rule_MissingFeature_CallEvent_Operation = new Constraint(DOMAIN.getCallEvent(), v17_ce, constraint7_MissingFeature_CallEvent_Operation);
		rule_MissingFeature_CallEvent_Operation.setName("MissingFeature_CallEvent_Operation");
		rule_MissingFeature_CallEvent_Operation.setMessage("The required feature 'operation' of <Call Event> must be set");
		
		return rule_MissingFeature_CallEvent_Operation;
	}
	
	public static IConstraint createMissingFeature_Trigger_EventRule() {
		
		Variable v18_t = new Variable("t");
	
		Term t25_event = new Get(v18_t, DOMAIN.getTrigger_Event());
	
		Formula constraint8_MissingFeature_Trigger_Event = new Not(new IsEmpty(t25_event));
		
		IConstraint rule_MissingFeature_Trigger_Event = new Constraint(DOMAIN.getTrigger(), v18_t, constraint8_MissingFeature_Trigger_Event);
		rule_MissingFeature_Trigger_Event.setName("MissingFeature_Trigger_Event");
		rule_MissingFeature_Trigger_Event.setMessage("The required feature 'event' of <Trigger> must be set");
		
		return rule_MissingFeature_Trigger_Event;
	}
}
