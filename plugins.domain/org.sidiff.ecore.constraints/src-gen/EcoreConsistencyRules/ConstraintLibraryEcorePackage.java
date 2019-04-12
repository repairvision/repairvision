package EcoreConsistencyRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EcorePackage;

import org.sidiff.validation.constraint.api.library.*;

import org.sidiff.validation.constraint.interpreter.*;
import org.sidiff.validation.constraint.interpreter.formulas.binary.*;
import org.sidiff.validation.constraint.interpreter.formulas.predicates.*;
import org.sidiff.validation.constraint.interpreter.formulas.quantifiers.*;
import org.sidiff.validation.constraint.interpreter.formulas.unary.*;
import org.sidiff.validation.constraint.interpreter.terms.*;
import org.sidiff.validation.constraint.interpreter.terms.functions.*;

public class ConstraintLibraryEcorePackage implements IConstraintLibrary {
	
	private static String documentType = EcorePackage.eINSTANCE.getNsURI();
		
	private static EcorePackage DOMAIN = EcorePackage.eINSTANCE;
	
	private static Map<String, IConstraint> rules = new HashMap<>();
		
	static {
		addConstraint(createTheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializableRule());
		addConstraint(createAClassThatIsAnInterfaceMustAlsoBeAbstractRule());
		addConstraint(createAContainerReferenceMustHaveUpperBoundOfNotRule());
		addConstraint(createAContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFromRule());
		addConstraint(createAContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulatedRule());
		addConstraint(createTheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesTypeRule());
		addConstraint(createTheOppositeOfAContainmentReferenceMustNotBeAContainmentReferenceRule());
		addConstraint(createTheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolvingRule());
		addConstraint(createTheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOneRule());
		addConstraint(createTheOppositeMayNotBeItsOwnOppositeRule());
		addConstraint(createThereMayNotBeTwoOperationsAndWithTheSameSignatureRule());
		addConstraint(createThereMayNotBeTwoParametersNamedRule());
		addConstraint(createThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeatureRule());
		addConstraint(createThereMayNotBeTwoFeaturesNamedRule());
		addConstraint(createTwoFeaturesCannotBothBeIDsRule());
		addConstraint(createThereMayNotBeTwoClassifiersNamedRule());
		addConstraint(createTheTypedElementMustHaveATypeRule());
		addConstraint(createTheRequiredFeatureOfMustBeSetRule());
		addConstraint(createTheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifierRule());
		addConstraint(createTheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParametersRule());
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
	
	public static IConstraint createTheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializableRule() {
		
		Variable v0_attribute = new Variable("attribute");
	
		Term t0_transient = new Get(v0_attribute, DOMAIN.getEStructuralFeature_Transient());
		Term t1_eType = new Get(v0_attribute, DOMAIN.getETypedElement_EType());
		Term t2_eType_serializable = new Get(new Get(v0_attribute, DOMAIN.getETypedElement_EType()), DOMAIN.getEDataType_Serializable());
	
		Formula constraint0_TheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializable = new If(new And(new Equality(t0_transient, BoolConstant.FALSE), new IsInstanceOf(t1_eType, DOMAIN.getEDataType())), new Equality(t2_eType_serializable, BoolConstant.TRUE));
		
		IConstraint rule_TheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializable = new Constraint(DOMAIN.getEAttribute(), v0_attribute, constraint0_TheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializable);
		rule_TheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializable.setName("TheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializable");
		rule_TheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializable.setMessage("The attribute is not transient so it must have a data type that is serializable");
		
		return rule_TheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializable;
	}
	
	public static IConstraint createAClassThatIsAnInterfaceMustAlsoBeAbstractRule() {
		
		Variable v1_eClass = new Variable("eClass");
	
		Term t3_interface = new Get(v1_eClass, DOMAIN.getEClass_Interface());
		Term t4_abstract = new Get(v1_eClass, DOMAIN.getEClass_Abstract());
	
		Formula constraint1_AClassThatIsAnInterfaceMustAlsoBeAbstract = new If(new Equality(t3_interface, BoolConstant.TRUE), new Equality(t4_abstract, BoolConstant.TRUE));
		
		IConstraint rule_AClassThatIsAnInterfaceMustAlsoBeAbstract = new Constraint(DOMAIN.getEClass(), v1_eClass, constraint1_AClassThatIsAnInterfaceMustAlsoBeAbstract);
		rule_AClassThatIsAnInterfaceMustAlsoBeAbstract.setName("AClassThatIsAnInterfaceMustAlsoBeAbstract");
		rule_AClassThatIsAnInterfaceMustAlsoBeAbstract.setMessage("A class that is an interface must also be abstract");
		
		return rule_AClassThatIsAnInterfaceMustAlsoBeAbstract;
	}
	
	public static IConstraint createAContainerReferenceMustHaveUpperBoundOfNotRule() {
		
		Variable v2_ref = new Variable("ref");
	
		Term t5_eOpposite_containment = new Get(new Get(v2_ref, DOMAIN.getEReference_EOpposite()), DOMAIN.getEReference_Containment());
		Term t6_upperBound = new Get(v2_ref, DOMAIN.getETypedElement_UpperBound());
	
		Formula constraint2_AContainerReferenceMustHaveUpperBoundOfNot = new If(new Equality(t5_eOpposite_containment, BoolConstant.TRUE), new Equality(t6_upperBound, new Constant(1)));
		
		IConstraint rule_AContainerReferenceMustHaveUpperBoundOfNot = new Constraint(DOMAIN.getEReference(), v2_ref, constraint2_AContainerReferenceMustHaveUpperBoundOfNot);
		rule_AContainerReferenceMustHaveUpperBoundOfNot.setName("AContainerReferenceMustHaveUpperBoundOfNot");
		rule_AContainerReferenceMustHaveUpperBoundOfNot.setMessage(" A container reference must have upper bound of 1");
		
		return rule_AContainerReferenceMustHaveUpperBoundOfNot;
	}
	
	public static IConstraint createAContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFromRule() {
		
		Variable v3_ref = new Variable("ref");
	
		Term t7_containment = new Get(v3_ref, DOMAIN.getEReference_Containment());
		Term t8_eOpposite = new Get(v3_ref, DOMAIN.getEReference_EOpposite());
		Term t9_upperBound = new Get(v3_ref, DOMAIN.getETypedElement_UpperBound());
		Term t10_unique = new Get(v3_ref, DOMAIN.getETypedElement_Unique());
	
		Formula constraint3_AContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFrom = new If(new And(new Or(new Equality(t7_containment, BoolConstant.TRUE), new Not(new IsEmpty(t8_eOpposite))), new Not(new Equality(t9_upperBound, new Constant(1)))), new Equality(t10_unique, BoolConstant.TRUE));
		
		IConstraint rule_AContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFrom = new Constraint(DOMAIN.getEReference(), v3_ref, constraint3_AContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFrom);
		rule_AContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFrom.setName("AContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFrom");
		rule_AContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFrom.setMessage("A containment or bidirectional reference must be unique if its upper bound is different from 1");
		
		return rule_AContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFrom;
	}
	
	public static IConstraint createAContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulatedRule() {
		
		Variable v4_ref = new Variable("ref");
		Variable v5_typeClosure = new Variable("typeClosure");
		Variable v6_feature = new Variable("feature");
	
		Term t11_containment = new Get(v4_ref, DOMAIN.getEReference_Containment());
		Term t12_eType = new Get(v4_ref, DOMAIN.getETypedElement_EType());
		Term t13_eType = new Get(v4_ref, DOMAIN.getETypedElement_EType());
		Term t14_eStructuralFeatures = new Get(v5_typeClosure, DOMAIN.getEClass_EStructuralFeatures());
		Term t15_eOpposite_containment = new Get(new Get(v6_feature, DOMAIN.getEReference_EOpposite()), DOMAIN.getEReference_Containment());
		Term t16_lowerBound = new Get(v6_feature, DOMAIN.getETypedElement_LowerBound());
		Term t17_eOpposite = new Get(v6_feature, DOMAIN.getEReference_EOpposite());
	
		Formula constraint4_AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated = new If(new Equality(t11_containment, BoolConstant.TRUE), new If(new IsInstanceOf(t12_eType, DOMAIN.getEClass()), new ForAll(v5_typeClosure, new GetClosure(t13_eType, DOMAIN.getEClass_ESuperTypes()), new ForAll(v6_feature, t14_eStructuralFeatures, new If(new And(new IsInstanceOf(v6_feature, DOMAIN.getEReference()), new Equality(t15_eOpposite_containment, BoolConstant.TRUE)), new Or(new Equality(t16_lowerBound, new Constant(0)), new Equality(t17_eOpposite, v4_ref)))))));
		
		IConstraint rule_AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated = new Constraint(DOMAIN.getEReference(), v4_ref, constraint4_AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated);
		rule_AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated.setName("AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated");
		rule_AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated.setMessage("A containment reference of a type with a container feature that requires instances to be contained elsewhere cannot be populated");
		
		return rule_AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated;
	}
	
	public static IConstraint createTheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesTypeRule() {
		
		Variable v7_eStructuralFeature = new Variable("eStructuralFeature");
		Variable v8_literal = new Variable("literal");
	
		Term t18_eType = new Get(v7_eStructuralFeature, DOMAIN.getETypedElement_EType());
		Term t19_defaultValueLiteral = new Get(v7_eStructuralFeature, DOMAIN.getEStructuralFeature_DefaultValueLiteral());
		Term t20_eType = new Get(v7_eStructuralFeature, DOMAIN.getETypedElement_EType());
		Term t21_eType_eLiterals = new Get(new Get(v7_eStructuralFeature, DOMAIN.getETypedElement_EType()), DOMAIN.getEEnum_ELiterals());
		Term t22_defaultValueLiteral = new Get(v7_eStructuralFeature, DOMAIN.getEStructuralFeature_DefaultValueLiteral());
		Term t23_name = new Get(v8_literal, DOMAIN.getENamedElement_Name());
		Term t24_eType = new Get(v7_eStructuralFeature, DOMAIN.getETypedElement_EType());
		Term t25_defaultValueLiteral = new Get(v7_eStructuralFeature, DOMAIN.getEStructuralFeature_DefaultValueLiteral());
		Term t26_eType = new Get(v7_eStructuralFeature, DOMAIN.getETypedElement_EType());
	
		Formula constraint5_TheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesType = new And(new And(new If(new Not(new IsInstanceOf(t18_eType, DOMAIN.getEDataType())), new IsEmpty(t19_defaultValueLiteral)), new If(new IsInstanceOf(t20_eType, DOMAIN.getEEnum()), new ForAll(v8_literal, t21_eType_eLiterals, new Equality(t22_defaultValueLiteral, t23_name)))), new If(new IsInstanceOf(t24_eType, DOMAIN.getEDataType()), new IsValueLiteralOf(t25_defaultValueLiteral, t26_eType)));
		
		IConstraint rule_TheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesType = new Constraint(DOMAIN.getEStructuralFeature(), v7_eStructuralFeature, constraint5_TheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesType);
		rule_TheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesType.setName("TheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesType");
		rule_TheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesType.setMessage("The default value literal must be a valid literal of the attributes type");
		
		return rule_TheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesType;
	}
	
	public static IConstraint createTheOppositeOfAContainmentReferenceMustNotBeAContainmentReferenceRule() {
		
		Variable v9_eReference = new Variable("eReference");
	
		Term t27_eOpposite = new Get(v9_eReference, DOMAIN.getEReference_EOpposite());
		Term t28_containment = new Get(v9_eReference, DOMAIN.getEReference_Containment());
		Term t29_eOpposite_containment = new Get(new Get(v9_eReference, DOMAIN.getEReference_EOpposite()), DOMAIN.getEReference_Containment());
	
		Formula constraint6_TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference = new If(new Not(new IsEmpty(t27_eOpposite)), new Or(new Equality(t28_containment, BoolConstant.FALSE), new Equality(t29_eOpposite_containment, BoolConstant.FALSE)));
		
		IConstraint rule_TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference = new Constraint(DOMAIN.getEReference(), v9_eReference, constraint6_TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference);
		rule_TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference.setName("TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference");
		rule_TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference.setMessage("The opposite of a containment reference must not be a containment reference");
		
		return rule_TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference;
	}
	
	public static IConstraint createTheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolvingRule() {
		
		Variable v10_reference = new Variable("reference");
	
		Term t30_transient = new Get(v10_reference, DOMAIN.getEStructuralFeature_Transient());
		Term t31_eOpposite_resolveProxies = new Get(new Get(v10_reference, DOMAIN.getEReference_EOpposite()), DOMAIN.getEReference_ResolveProxies());
		Term t32_eOpposite_transient = new Get(new Get(v10_reference, DOMAIN.getEReference_EOpposite()), DOMAIN.getEStructuralFeature_Transient());
	
		Formula constraint7_TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving = new If(new Equality(t30_transient, BoolConstant.TRUE), new Or(new Equality(t31_eOpposite_resolveProxies, BoolConstant.FALSE), new Equality(t32_eOpposite_transient, BoolConstant.TRUE)));
		
		IConstraint rule_TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving = new Constraint(DOMAIN.getEReference(), v10_reference, constraint7_TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving);
		rule_TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving.setName("TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving");
		rule_TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving.setMessage("The opposite of a transient reference must be transient if it is proxy resolving");
		
		return rule_TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving;
	}
	
	public static IConstraint createTheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOneRule() {
		
		Variable v11_reference = new Variable("reference");
	
		Term t33_eOpposite = new Get(v11_reference, DOMAIN.getEReference_EOpposite());
		Term t34_eOpposite_eOpposite = new Get(new Get(v11_reference, DOMAIN.getEReference_EOpposite()), DOMAIN.getEReference_EOpposite());
	
		Formula constraint8_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne = new If(new Not(new IsEmpty(t33_eOpposite)), new Equality(t34_eOpposite_eOpposite, v11_reference));
		
		IConstraint rule_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne = new Constraint(DOMAIN.getEReference(), v11_reference, constraint8_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne);
		rule_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne.setName("TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne");
		rule_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne.setMessage("The opposite of the opposite may not be a reference different from this one");
		
		return rule_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne;
	}
	
	public static IConstraint createTheOppositeMayNotBeItsOwnOppositeRule() {
		
		Variable v12_reference = new Variable("reference");
	
		Term t35_eOpposite = new Get(v12_reference, DOMAIN.getEReference_EOpposite());
	
		Formula constraint9_TheOppositeMayNotBeItsOwnOpposite = new Not(new Equality(t35_eOpposite, v12_reference));
		
		IConstraint rule_TheOppositeMayNotBeItsOwnOpposite = new Constraint(DOMAIN.getEReference(), v12_reference, constraint9_TheOppositeMayNotBeItsOwnOpposite);
		rule_TheOppositeMayNotBeItsOwnOpposite.setName("TheOppositeMayNotBeItsOwnOpposite");
		rule_TheOppositeMayNotBeItsOwnOpposite.setMessage("The opposite may not be its own opposite");
		
		return rule_TheOppositeMayNotBeItsOwnOpposite;
	}
	
	public static IConstraint createThereMayNotBeTwoOperationsAndWithTheSameSignatureRule() {
		
		Variable v13_eOperation = new Variable("eOperation");
		Variable v14_typeClosure = new Variable("typeClosure");
		Variable v15_otherEOpperation = new Variable("otherEOpperation");
		Variable v16_eParameter = new Variable("eParameter");
		Variable v17_otherEParameter = new Variable("otherEParameter");
	
		Term t36_eContainingClass = new Get(v13_eOperation, DOMAIN.getEOperation_EContainingClass());
		Term t37_eOperations = new Get(v14_typeClosure, DOMAIN.getEClass_EOperations());
		Term t38_name = new Get(v13_eOperation, DOMAIN.getENamedElement_Name());
		Term t39_name = new Get(v15_otherEOpperation, DOMAIN.getENamedElement_Name());
		Term t40_eParameters = new Get(v13_eOperation, DOMAIN.getEOperation_EParameters());
		Term t41_eParameters = new Get(v15_otherEOpperation, DOMAIN.getEOperation_EParameters());
		Term t42_eParameters = new Get(v13_eOperation, DOMAIN.getEOperation_EParameters());
		Term t43_eParameters = new Get(v15_otherEOpperation, DOMAIN.getEOperation_EParameters());
		Term t44_eParameters = new Get(v13_eOperation, DOMAIN.getEOperation_EParameters());
		Term t45_eParameters = new Get(v15_otherEOpperation, DOMAIN.getEOperation_EParameters());
		Term t46_eType = new Get(v16_eParameter, DOMAIN.getETypedElement_EType());
		Term t47_eType = new Get(v17_otherEParameter, DOMAIN.getETypedElement_EType());
	
		Formula constraint10_ThereMayNotBeTwoOperationsAndWithTheSameSignature = new Not(new Exists(v14_typeClosure, new GetClosure(t36_eContainingClass, DOMAIN.getEClass_ESuperTypes()), new Exists(v15_otherEOpperation, t37_eOperations, new And(new And(new And(new Not(new Equality(v13_eOperation, v15_otherEOpperation)), new Equality(t38_name, t39_name)), new Equality(new Size(t40_eParameters), new Size(t41_eParameters))), new Or(new And(new IsEmpty(t42_eParameters), new IsEmpty(t43_eParameters)), new Exists(v16_eParameter, t44_eParameters, new Exists(v17_otherEParameter, t45_eParameters, new And(new And(new Not(new Equality(v16_eParameter, v17_otherEParameter)), new Equality(t46_eType, t47_eType)), new Equality(new IndexOf(v13_eOperation, DOMAIN.getEOperation_EParameters(), v16_eParameter), new IndexOf(v15_otherEOpperation, DOMAIN.getEOperation_EParameters(), v17_otherEParameter))))))))));
		
		IConstraint rule_ThereMayNotBeTwoOperationsAndWithTheSameSignature = new Constraint(DOMAIN.getEOperation(), v13_eOperation, constraint10_ThereMayNotBeTwoOperationsAndWithTheSameSignature);
		rule_ThereMayNotBeTwoOperationsAndWithTheSameSignature.setName("ThereMayNotBeTwoOperationsAndWithTheSameSignature");
		rule_ThereMayNotBeTwoOperationsAndWithTheSameSignature.setMessage("There may not be two operations with the same signature");
		
		return rule_ThereMayNotBeTwoOperationsAndWithTheSameSignature;
	}
	
	public static IConstraint createThereMayNotBeTwoParametersNamedRule() {
		
		Variable v18_eParameter = new Variable("eParameter");
		Variable v19_otherEParameter = new Variable("otherEParameter");
	
		Term t48_eOperation_eParameters = new Get(new Get(v18_eParameter, DOMAIN.getEParameter_EOperation()), DOMAIN.getEOperation_EParameters());
		Term t49_name = new Get(v18_eParameter, DOMAIN.getENamedElement_Name());
		Term t50_name = new Get(v19_otherEParameter, DOMAIN.getENamedElement_Name());
	
		Formula constraint11_ThereMayNotBeTwoParametersNamed = new Not(new Exists(v19_otherEParameter, t48_eOperation_eParameters, new And(new Not(new Equality(v18_eParameter, v19_otherEParameter)), new Equality(t49_name, t50_name))));
		
		IConstraint rule_ThereMayNotBeTwoParametersNamed = new Constraint(DOMAIN.getEParameter(), v18_eParameter, constraint11_ThereMayNotBeTwoParametersNamed);
		rule_ThereMayNotBeTwoParametersNamed.setName("ThereMayNotBeTwoParametersNamed");
		rule_ThereMayNotBeTwoParametersNamed.setMessage("There may not be two parameters with the same name");
		
		return rule_ThereMayNotBeTwoParametersNamed;
	}
	
	public static IConstraint createThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeatureRule() {
		
		Variable v20_operation = new Variable("operation");
		Variable v21_annotation = new Variable("annotation");
		Variable v22_detail = new Variable("detail");
		Variable v23_typeClosure = new Variable("typeClosure");
		Variable v24_feature = new Variable("feature");
		Variable v25_parameter = new Variable("parameter");
	
		Term t51_eAnnotations = new Get(v20_operation, DOMAIN.getEModelElement_EAnnotations());
		Term t52_source = new Get(v21_annotation, DOMAIN.getEAnnotation_Source());
		Term t53_details = new Get(v21_annotation, DOMAIN.getEAnnotation_Details());
		Term t54_key = new Get(v22_detail, DOMAIN.getEStringToStringMapEntry_Key());
		Term t55_value = new Get(v22_detail, DOMAIN.getEStringToStringMapEntry_Value());
		Term t56_eContainingClass = new Get(v20_operation, DOMAIN.getEOperation_EContainingClass());
		Term t57_eStructuralFeatures = new Get(v23_typeClosure, DOMAIN.getEClass_EStructuralFeatures());
		Term t58_eParameters = new Get(v20_operation, DOMAIN.getEOperation_EParameters());
		Term t59_eParameters = new Get(v20_operation, DOMAIN.getEOperation_EParameters());
		Term t60_eType = new Get(v25_parameter, DOMAIN.getETypedElement_EType());
		Term t61_eType = new Get(v24_feature, DOMAIN.getETypedElement_EType());
		Term t62_name = new Get(v20_operation, DOMAIN.getENamedElement_Name());
		Term t63_name = new Get(v24_feature, DOMAIN.getENamedElement_Name());
		Term t64_eParameters = new Get(v20_operation, DOMAIN.getEOperation_EParameters());
		Term t65_name = new Get(v20_operation, DOMAIN.getENamedElement_Name());
		Term t66_name = new Get(v24_feature, DOMAIN.getENamedElement_Name());
		Term t67_eParameters = new Get(v20_operation, DOMAIN.getEOperation_EParameters());
		Term t68_name = new Get(v20_operation, DOMAIN.getENamedElement_Name());
		Term t69_name = new Get(v24_feature, DOMAIN.getENamedElement_Name());
		Term t70_eParameters = new Get(v20_operation, DOMAIN.getEOperation_EParameters());
		Term t71_name = new Get(v20_operation, DOMAIN.getENamedElement_Name());
		Term t72_name = new Get(v24_feature, DOMAIN.getENamedElement_Name());
		Term t73_eParameters = new Get(v20_operation, DOMAIN.getEOperation_EParameters());
		Term t74_name = new Get(v20_operation, DOMAIN.getENamedElement_Name());
		Term t75_name = new Get(v24_feature, DOMAIN.getENamedElement_Name());
	
		Formula constraint12_ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature = new Or(new Exists(v21_annotation, t51_eAnnotations, new And(new Equality(t52_source, new Constant("http://www.eclipse.org/emf/2002/GenModel")), new Exists(v22_detail, t53_details, new And(new Equality(t54_key, new Constant("suppressedVisibility")), new Equality(t55_value, new Constant("true")))))), new ForAll(v23_typeClosure, new GetClosure(t56_eContainingClass, DOMAIN.getEClass_ESuperTypes()), new ForAll(v24_feature, t57_eStructuralFeatures, new And(new And(new And(new And(new If(new And(new Equality(new Size(t58_eParameters), new Constant(1)), new ForAll(v25_parameter, t59_eParameters, new Equality(t60_eType, t61_eType))), new Not(new Equality(t62_name, new Concatenate(new Constant("set"), new Capitalize(t63_name))))), new If(new Equality(new Size(t64_eParameters), new Constant(0)), new Not(new Equality(t65_name, new Concatenate(new Constant("get"), new Capitalize(t66_name)))))), new If(new Equality(new Size(t67_eParameters), new Constant(0)), new Not(new Equality(t68_name, new Concatenate(new Constant("is"), new Capitalize(t69_name)))))), new If(new Equality(new Size(t70_eParameters), new Constant(0)), new Not(new Equality(t71_name, new Concatenate(new Constant("isSet"), new Capitalize(t72_name)))))), new If(new Equality(new Size(t73_eParameters), new Constant(0)), new Not(new Equality(t74_name, new Concatenate(new Constant("unset"), new Capitalize(t75_name)))))))));
		
		IConstraint rule_ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature = new Constraint(DOMAIN.getEOperation(), v20_operation, constraint12_ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature);
		rule_ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature.setName("ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature");
		rule_ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature.setMessage("There may not be an operation with the same signature as an accessor method for a feature");
		
		return rule_ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature;
	}
	
	public static IConstraint createThereMayNotBeTwoFeaturesNamedRule() {
		
		Variable v26_eClass = new Variable("eClass");
		Variable v27_featureA = new Variable("featureA");
		Variable v28_featureB = new Variable("featureB");
		Variable v29_eClassX = new Variable("eClassX");
		Variable v30_eClassY = new Variable("eClassY");
		Variable v31_featureX = new Variable("featureX");
		Variable v32_featureY = new Variable("featureY");
	
		Term t76_eStructuralFeatures = new Get(v26_eClass, DOMAIN.getEClass_EStructuralFeatures());
		Term t77_eStructuralFeatures = new Get(v26_eClass, DOMAIN.getEClass_EStructuralFeatures());
		Term t78_name = new Get(v27_featureA, DOMAIN.getENamedElement_Name());
		Term t79_name = new Get(v28_featureB, DOMAIN.getENamedElement_Name());
		Term t80_eStructuralFeatures = new Get(v29_eClassX, DOMAIN.getEClass_EStructuralFeatures());
		Term t81_eStructuralFeatures = new Get(v30_eClassY, DOMAIN.getEClass_EStructuralFeatures());
		Term t82_name = new Get(v31_featureX, DOMAIN.getENamedElement_Name());
		Term t83_name = new Get(v32_featureY, DOMAIN.getENamedElement_Name());
	
		Formula constraint13_ThereMayNotBeTwoFeaturesNamed = new And(new ForAll(v27_featureA, t76_eStructuralFeatures, new ForAll(v28_featureB, t77_eStructuralFeatures, new If(new Not(new Equality(v27_featureA, v28_featureB)), new Not(new Equality(t78_name, t79_name))))), new ForAll(v29_eClassX, new GetClosure(v26_eClass, DOMAIN.getEClass_ESuperTypes()), new ForAll(v30_eClassY, new GetClosure(v26_eClass, DOMAIN.getEClass_ESuperTypes()), new If(new Not(new Equality(v29_eClassX, v30_eClassY)), new ForAll(v31_featureX, t80_eStructuralFeatures, new ForAll(v32_featureY, t81_eStructuralFeatures, new Not(new Equality(t82_name, t83_name))))))));
		
		IConstraint rule_ThereMayNotBeTwoFeaturesNamed = new Constraint(DOMAIN.getEClass(), v26_eClass, constraint13_ThereMayNotBeTwoFeaturesNamed);
		rule_ThereMayNotBeTwoFeaturesNamed.setName("ThereMayNotBeTwoFeaturesNamed");
		rule_ThereMayNotBeTwoFeaturesNamed.setMessage("There may not be two features with the same name");
		
		return rule_ThereMayNotBeTwoFeaturesNamed;
	}
	
	public static IConstraint createTwoFeaturesCannotBothBeIDsRule() {
		
		Variable v33_attribute = new Variable("attribute");
		Variable v34_typeClosure = new Variable("typeClosure");
		Variable v35_feature = new Variable("feature");
	
		Term t84_iD = new Get(v33_attribute, DOMAIN.getEAttribute_ID());
		Term t85_eContainingClass = new Get(v33_attribute, DOMAIN.getEStructuralFeature_EContainingClass());
		Term t86_eStructuralFeatures = new Get(v34_typeClosure, DOMAIN.getEClass_EStructuralFeatures());
		Term t87_iD = new Get(v35_feature, DOMAIN.getEAttribute_ID());
	
		Formula constraint14_TwoFeaturesCannotBothBeIDs = new If(new Equality(t84_iD, BoolConstant.TRUE), new ForAll(v34_typeClosure, new GetClosure(t85_eContainingClass, DOMAIN.getEClass_ESuperTypes()), new ForAll(v35_feature, t86_eStructuralFeatures, new If(new And(new IsInstanceOf(v35_feature, DOMAIN.getEAttribute()), new Not(new Equality(v35_feature, v33_attribute))), new Not(new Equality(t87_iD, BoolConstant.TRUE))))));
		
		IConstraint rule_TwoFeaturesCannotBothBeIDs = new Constraint(DOMAIN.getEAttribute(), v33_attribute, constraint14_TwoFeaturesCannotBothBeIDs);
		rule_TwoFeaturesCannotBothBeIDs.setName("TwoFeaturesCannotBothBeIDs");
		rule_TwoFeaturesCannotBothBeIDs.setMessage("The features cannot both be IDs");
		
		return rule_TwoFeaturesCannotBothBeIDs;
	}
	
	public static IConstraint createThereMayNotBeTwoClassifiersNamedRule() {
		
		Variable v36_package = new Variable("package");
		Variable v37_classA = new Variable("classA");
		Variable v38_classB = new Variable("classB");
	
		Term t88_eClassifiers = new Get(v36_package, DOMAIN.getEPackage_EClassifiers());
		Term t89_eClassifiers = new Get(v36_package, DOMAIN.getEPackage_EClassifiers());
		Term t90_name = new Get(v37_classA, DOMAIN.getENamedElement_Name());
		Term t91_name = new Get(v38_classB, DOMAIN.getENamedElement_Name());
	
		Formula constraint15_ThereMayNotBeTwoClassifiersNamed = new ForAll(v37_classA, t88_eClassifiers, new Not(new Exists(v38_classB, t89_eClassifiers, new And(new Equality(t90_name, t91_name), new Not(new Equality(v37_classA, v38_classB))))));
		
		IConstraint rule_ThereMayNotBeTwoClassifiersNamed = new Constraint(DOMAIN.getEPackage(), v36_package, constraint15_ThereMayNotBeTwoClassifiersNamed);
		rule_ThereMayNotBeTwoClassifiersNamed.setName("ThereMayNotBeTwoClassifiersNamed");
		rule_ThereMayNotBeTwoClassifiersNamed.setMessage("There may not be two classifiers with the same name");
		
		return rule_ThereMayNotBeTwoClassifiersNamed;
	}
	
	public static IConstraint createTheTypedElementMustHaveATypeRule() {
		
		Variable v39_eTypedElement = new Variable("eTypedElement");
	
		Term t92_eType = new Get(v39_eTypedElement, DOMAIN.getETypedElement_EType());
	
		Formula constraint16_TheTypedElementMustHaveAType = new Or(new IsInstanceOf(v39_eTypedElement, DOMAIN.getEOperation()), new Not(new IsEmpty(t92_eType)));
		
		IConstraint rule_TheTypedElementMustHaveAType = new Constraint(DOMAIN.getETypedElement(), v39_eTypedElement, constraint16_TheTypedElementMustHaveAType);
		rule_TheTypedElementMustHaveAType.setName("TheTypedElementMustHaveAType");
		rule_TheTypedElementMustHaveAType.setMessage("The typed element must have a type");
		
		return rule_TheTypedElementMustHaveAType;
	}
	
	public static IConstraint createTheRequiredFeatureOfMustBeSetRule() {
		
		Variable v40_eModelElement = new Variable("eModelElement");
	
		Term t93_eType = new Get(v40_eModelElement, DOMAIN.getETypedElement_EType());
		Term t94_ePackage = new Get(v40_eModelElement, DOMAIN.getEFactory_EPackage());
		Term t95_eFactoryInstance = new Get(v40_eModelElement, DOMAIN.getEPackage_EFactoryInstance());
		Term t96_eType = new Get(v40_eModelElement, DOMAIN.getETypedElement_EType());
	
		Formula constraint17_TheRequiredFeatureOfMustBeSet = new And(new And(new And(new If(new IsInstanceOf(v40_eModelElement, DOMAIN.getEAttribute()), new Not(new IsEmpty(t93_eType))), new If(new IsInstanceOf(v40_eModelElement, DOMAIN.getEFactory()), new Not(new IsEmpty(t94_ePackage)))), new If(new IsInstanceOf(v40_eModelElement, DOMAIN.getEPackage()), new Not(new IsEmpty(t95_eFactoryInstance)))), new If(new IsInstanceOf(v40_eModelElement, DOMAIN.getEReference()), new Not(new IsEmpty(t96_eType))));
		
		IConstraint rule_TheRequiredFeatureOfMustBeSet = new Constraint(DOMAIN.getEModelElement(), v40_eModelElement, constraint17_TheRequiredFeatureOfMustBeSet);
		rule_TheRequiredFeatureOfMustBeSet.setName("TheRequiredFeatureOfMustBeSet");
		rule_TheRequiredFeatureOfMustBeSet.setMessage("The required feature must be set");
		
		return rule_TheRequiredFeatureOfMustBeSet;
	}
	
	public static IConstraint createTheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifierRule() {
		
		Variable v41_eType = new Variable("eType");
	
		Term t97_eClassifier_eTypeParameters = new Get(new Get(v41_eType, DOMAIN.getEGenericType_EClassifier()), DOMAIN.getEClassifier_ETypeParameters());
		Term t98_eTypeArguments = new Get(v41_eType, DOMAIN.getEGenericType_ETypeArguments());
	
		Formula constraint18_TheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifier = new Equality(new Size(t97_eClassifier_eTypeParameters), new Size(t98_eTypeArguments));
		
		IConstraint rule_TheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifier = new Constraint(DOMAIN.getEGenericType(), v41_eType, constraint18_TheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifier);
		rule_TheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifier.setName("TheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifier");
		rule_TheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifier.setMessage("The generic type associated with the classifier is missing type arguments to match the number of type parameters of the classifier");
		
		return rule_TheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifier;
	}
	
	public static IConstraint createTheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParametersRule() {
		
		Variable v42_eType = new Variable("eType");
	
		Term t99_eClassifier_eTypeParameters = new Get(new Get(v42_eType, DOMAIN.getEGenericType_EClassifier()), DOMAIN.getEClassifier_ETypeParameters());
		Term t100_eTypeArguments = new Get(v42_eType, DOMAIN.getEGenericType_ETypeArguments());
	
		Formula constraint19_TheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParameters = new Equality(new Size(t99_eClassifier_eTypeParameters), new Size(t100_eTypeArguments));
		
		IConstraint rule_TheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParameters = new Constraint(DOMAIN.getEGenericType(), v42_eType, constraint19_TheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParameters);
		rule_TheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParameters.setName("TheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParameters");
		rule_TheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParameters.setMessage("The generic type associated with the classifier must not have more arguments then the classifier has type parameters");
		
		return rule_TheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParameters;
	}
}
