package org.sidiff.ecore.constraints;

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

public class EcoreConsistencyRules implements IConstraintLibrary {
	
	private String name = "Ecore Consistency Rules";
	
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
			 
			addDomain("http://www.eclipse.org/emf/2002/Ecore");
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
			
			addDocumentType("http://www.eclipse.org/emf/2002/Ecore");
		}
		
		return documentTypes;
	}
	
	private void addDocumentType(String documentType) {
		documentTypes.add(documentType);
	}
	
	public Map<String, IConstraint> getConstraintEntries() {
		
		if (constraints == null) {
			constraints = new LinkedHashMap<>();
		
			addConstraint(createTheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializableConstraint());
			addConstraint(createAClassThatIsAnInterfaceMustAlsoBeAbstractConstraint());
			addConstraint(createAContainerReferenceMustHaveUpperBoundOfNotConstraint());
			addConstraint(createAContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFromConstraint());
			addConstraint(createAContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulatedConstraint());
			addConstraint(createTheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesTypeConstraint());
			addConstraint(createTheOppositeOfAContainmentReferenceMustNotBeAContainmentReferenceConstraint());
			addConstraint(createTheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolvingConstraint());
			addConstraint(createTheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOneConstraint());
			addConstraint(createTheOppositeMayNotBeItsOwnOppositeConstraint());
			addConstraint(createThereMayNotBeTwoOperationsAndWithTheSameSignatureConstraint());
			addConstraint(createThereMayNotBeTwoParametersNamedConstraint());
			addConstraint(createThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeatureConstraint());
			addConstraint(createThereMayNotBeTwoFeaturesNamedConstraint());
			addConstraint(createTwoFeaturesCannotBothBeIDsConstraint());
			addConstraint(createThereMayNotBeTwoClassifiersNamedConstraint());
			addConstraint(createTheTypedElementMustHaveATypeConstraint());
			addConstraint(createTheRequiredFeatureOfMustBeSetConstraint());
			addConstraint(createTheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifierConstraint());
			addConstraint(createTheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParametersConstraint());
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
	
	public static IConstraint createTheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializableConstraint() {
		
		Variable v_attribute = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EATTRIBUTE, "attribute");
		
		Term t_transient = new Get(v_attribute, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT);
		Term t_eType = new Get(v_attribute, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		Term t_eType_serializable = new Get(new Get(v_attribute, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE), org.eclipse.emf.ecore.EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE);
		
		Formula formula = new If(new And(new Equality(t_transient, BoolConstant.FALSE), new IsInstanceOf(t_eType, org.eclipse.emf.ecore.EcorePackage.Literals.EDATA_TYPE)), new Equality(t_eType_serializable, BoolConstant.TRUE));
		
		IConstraint constraint_TheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializable = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EATTRIBUTE, v_attribute, formula);
		constraint_TheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializable.setName("TheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializable");
		constraint_TheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializable.setMessage("The attribute is not transient so it must have a data type that is serializable");
		
		return constraint_TheAttributeIsNotTransientSoItMustHaveADataTypeThatIsSerializable;
	}
	
	public static IConstraint createAClassThatIsAnInterfaceMustAlsoBeAbstractConstraint() {
		
		Variable v_eClass = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS, "eClass");
		
		Term t_interface = new Get(v_eClass, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__INTERFACE);
		Term t_abstract = new Get(v_eClass, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ABSTRACT);
		
		Formula formula = new If(new Equality(t_interface, BoolConstant.TRUE), new Equality(t_abstract, BoolConstant.TRUE));
		
		IConstraint constraint_AClassThatIsAnInterfaceMustAlsoBeAbstract = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS, v_eClass, formula);
		constraint_AClassThatIsAnInterfaceMustAlsoBeAbstract.setName("AClassThatIsAnInterfaceMustAlsoBeAbstract");
		constraint_AClassThatIsAnInterfaceMustAlsoBeAbstract.setMessage("A class that is an interface must also be abstract");
		
		return constraint_AClassThatIsAnInterfaceMustAlsoBeAbstract;
	}
	
	public static IConstraint createAContainerReferenceMustHaveUpperBoundOfNotConstraint() {
		
		Variable v_ref = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, "ref");
		
		Term t_eOpposite_containment = new Get(new Get(v_ref, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__EOPPOSITE), org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__CONTAINMENT);
		Term t_upperBound = new Get(v_ref, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__UPPER_BOUND);
		
		Formula formula = new If(new Equality(t_eOpposite_containment, BoolConstant.TRUE), new Equality(t_upperBound, new Constant(1)));
		
		IConstraint constraint_AContainerReferenceMustHaveUpperBoundOfNot = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, v_ref, formula);
		constraint_AContainerReferenceMustHaveUpperBoundOfNot.setName("AContainerReferenceMustHaveUpperBoundOfNot");
		constraint_AContainerReferenceMustHaveUpperBoundOfNot.setMessage("A container reference must have upper bound of 1");
		
		return constraint_AContainerReferenceMustHaveUpperBoundOfNot;
	}
	
	public static IConstraint createAContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFromConstraint() {
		
		Variable v_ref = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, "ref");
		
		Term t_containment = new Get(v_ref, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__CONTAINMENT);
		Term t_eOpposite = new Get(v_ref, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__EOPPOSITE);
		Term t_upperBound = new Get(v_ref, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__UPPER_BOUND);
		Term t_unique = new Get(v_ref, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__UNIQUE);
		
		Formula formula = new If(new And(new Or(new Equality(t_containment, BoolConstant.TRUE), new Not(new IsEmpty(t_eOpposite))), new Not(new Equality(t_upperBound, new Constant(1)))), new Equality(t_unique, BoolConstant.TRUE));
		
		IConstraint constraint_AContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFrom = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, v_ref, formula);
		constraint_AContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFrom.setName("AContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFrom");
		constraint_AContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFrom.setMessage("A containment or bidirectional reference must be unique if its upper bound is different from 1");
		
		return constraint_AContainmentOrBidirectionalReferenceMustBeUniqueIfItsUpperBoundIsDifferentFrom;
	}
	
	public static IConstraint createAContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulatedConstraint() {
		
		Variable v_ref = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, "ref");
		Variable v_typeClosure = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS, "typeClosure");
		Variable v_feature = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE, "feature");
		
		Term t_containment = new Get(v_ref, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__CONTAINMENT);
		Term t_eType = new Get(v_ref, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		Term t_eType_1 = new Get(v_ref, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		Term t_eStructuralFeatures = new Get(v_typeClosure, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		Term t_eOpposite_containment = new Get(new Get(v_feature, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__EOPPOSITE), org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__CONTAINMENT);
		Term t_lowerBound = new Get(v_feature, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__LOWER_BOUND);
		Term t_eOpposite = new Get(v_feature, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__EOPPOSITE);
		
		Formula formula = new If(new Equality(t_containment, BoolConstant.TRUE), new If(new IsInstanceOf(t_eType, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS), new ForAll(v_typeClosure, new GetClosure(t_eType_1, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESUPER_TYPES), new ForAll(v_feature, t_eStructuralFeatures, new If(new And(new IsInstanceOf(v_feature, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE), new Equality(t_eOpposite_containment, BoolConstant.TRUE)), new Or(new Equality(t_lowerBound, new Constant(0)), new Equality(t_eOpposite, v_ref)))))));
		
		IConstraint constraint_AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, v_ref, formula);
		constraint_AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated.setName("AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated");
		constraint_AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated.setMessage("A containment reference of a type with a container feature that requires instances to be contained elsewhere cannot be populated");
		
		return constraint_AContainmentReferenceOfATypeWithAContainerFeaturethatRequiresInstancesToBeContainedElsewhereCannotBePopulated;
	}
	
	public static IConstraint createTheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesTypeConstraint() {
		
		Variable v_eStructuralFeature = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE, "eStructuralFeature");
		Variable v_literal = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EENUM_LITERAL, "literal");
		
		Term t_eType = new Get(v_eStructuralFeature, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		Term t_defaultValueLiteral = new Get(v_eStructuralFeature, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL);
		Term t_eType_1 = new Get(v_eStructuralFeature, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		Term t_eType_eLiterals = new Get(new Get(v_eStructuralFeature, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE), org.eclipse.emf.ecore.EcorePackage.Literals.EENUM__ELITERALS);
		Term t_defaultValueLiteral_1 = new Get(v_eStructuralFeature, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL);
		Term t_literal = new Get(v_literal, org.eclipse.emf.ecore.EcorePackage.Literals.EENUM_LITERAL__LITERAL);
		Term t_eType_2 = new Get(v_eStructuralFeature, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		Term t_defaultValueLiteral_2 = new Get(v_eStructuralFeature, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL);
		Term t_eType_3 = new Get(v_eStructuralFeature, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		
		Formula formula = new And(new And(new If(new Not(new IsInstanceOf(t_eType, org.eclipse.emf.ecore.EcorePackage.Literals.EDATA_TYPE)), new IsEmpty(t_defaultValueLiteral)), new If(new IsInstanceOf(t_eType_1, org.eclipse.emf.ecore.EcorePackage.Literals.EENUM), new Exists(v_literal, t_eType_eLiterals, new Equality(t_defaultValueLiteral_1, t_literal)))), new If(new IsInstanceOf(t_eType_2, org.eclipse.emf.ecore.EcorePackage.Literals.EDATA_TYPE), new IsValueLiteralOf(t_defaultValueLiteral_2, t_eType_3)));
		
		IConstraint constraint_TheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesType = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE, v_eStructuralFeature, formula);
		constraint_TheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesType.setName("TheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesType");
		constraint_TheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesType.setMessage("The default value literal must be a valid literal of the attributes type");
		
		return constraint_TheDefaultValueLiteralMustBeAValidLiteralOfTheAttributesType;
	}
	
	public static IConstraint createTheOppositeOfAContainmentReferenceMustNotBeAContainmentReferenceConstraint() {
		
		Variable v_eReference = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, "eReference");
		
		Term t_eOpposite = new Get(v_eReference, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__EOPPOSITE);
		Term t_containment = new Get(v_eReference, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__CONTAINMENT);
		Term t_eOpposite_containment = new Get(new Get(v_eReference, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__EOPPOSITE), org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__CONTAINMENT);
		
		Formula formula = new If(new Not(new IsEmpty(t_eOpposite)), new Or(new Equality(t_containment, BoolConstant.FALSE), new Equality(t_eOpposite_containment, BoolConstant.FALSE)));
		
		IConstraint constraint_TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, v_eReference, formula);
		constraint_TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference.setName("TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference");
		constraint_TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference.setMessage("The opposite of a containment reference must not be a containment reference");
		
		return constraint_TheOppositeOfAContainmentReferenceMustNotBeAContainmentReference;
	}
	
	public static IConstraint createTheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolvingConstraint() {
		
		Variable v_reference = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, "reference");
		
		Term t_transient = new Get(v_reference, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT);
		Term t_eOpposite_resolveProxies = new Get(new Get(v_reference, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__EOPPOSITE), org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES);
		Term t_eOpposite_transient = new Get(new Get(v_reference, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__EOPPOSITE), org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT);
		
		Formula formula = new If(new Equality(t_transient, BoolConstant.TRUE), new Or(new Equality(t_eOpposite_resolveProxies, BoolConstant.FALSE), new Equality(t_eOpposite_transient, BoolConstant.TRUE)));
		
		IConstraint constraint_TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, v_reference, formula);
		constraint_TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving.setName("TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving");
		constraint_TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving.setMessage("The opposite of a transient reference must be transient if it is proxy resolving");
		
		return constraint_TheOppositeOfATransientReferenceMustBeTransientIfItIsProxyResolving;
	}
	
	public static IConstraint createTheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOneConstraint() {
		
		Variable v_reference = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, "reference");
		
		Term t_eOpposite = new Get(v_reference, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__EOPPOSITE);
		Term t_eOpposite_eOpposite = new Get(new Get(v_reference, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__EOPPOSITE), org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__EOPPOSITE);
		
		Formula formula = new If(new Not(new IsEmpty(t_eOpposite)), new Equality(t_eOpposite_eOpposite, v_reference));
		
		IConstraint constraint_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, v_reference, formula);
		constraint_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne.setName("TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne");
		constraint_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne.setMessage("The opposite of the opposite may not be a reference different from this one");
		
		return constraint_TheOppositeOfTheOppositeMayNotBeAReferenceDifferentFromThisOne;
	}
	
	public static IConstraint createTheOppositeMayNotBeItsOwnOppositeConstraint() {
		
		Variable v_reference = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, "reference");
		
		Term t_eOpposite = new Get(v_reference, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE__EOPPOSITE);
		
		Formula formula = new Not(new Equality(t_eOpposite, v_reference));
		
		IConstraint constraint_TheOppositeMayNotBeItsOwnOpposite = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE, v_reference, formula);
		constraint_TheOppositeMayNotBeItsOwnOpposite.setName("TheOppositeMayNotBeItsOwnOpposite");
		constraint_TheOppositeMayNotBeItsOwnOpposite.setMessage("The opposite may not be its own opposite");
		
		return constraint_TheOppositeMayNotBeItsOwnOpposite;
	}
	
	public static IConstraint createThereMayNotBeTwoOperationsAndWithTheSameSignatureConstraint() {
		
		Variable v_eOperation = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION, "eOperation");
		Variable v_typeClosure = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS, "typeClosure");
		Variable v_otherEOpperation = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION, "otherEOpperation");
		Variable v_eParameter = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EPARAMETER, "eParameter");
		Variable v_otherEParameter = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EPARAMETER, "otherEParameter");
		
		Term t_eContainingClass = new Get(v_eOperation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__ECONTAINING_CLASS);
		Term t_eOperations = new Get(v_typeClosure, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__EOPERATIONS);
		Term t_name = new Get(v_eOperation, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_name_1 = new Get(v_otherEOpperation, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_eParameters = new Get(v_eOperation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_eParameters_1 = new Get(v_otherEOpperation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_eParameters_2 = new Get(v_eOperation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_eParameters_3 = new Get(v_otherEOpperation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_eParameters_4 = new Get(v_eOperation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_eParameters_5 = new Get(v_otherEOpperation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_eType = new Get(v_eParameter, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		Term t_eType_1 = new Get(v_otherEParameter, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		
		Formula formula = new Not(new Exists(v_typeClosure, new GetClosure(t_eContainingClass, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESUPER_TYPES), new Exists(v_otherEOpperation, t_eOperations, new And(new And(new And(new Not(new Equality(v_eOperation, v_otherEOpperation)), new Equality(t_name, t_name_1)), new Equality(new Size(t_eParameters), new Size(t_eParameters_1))), new Or(new And(new IsEmpty(t_eParameters_2), new IsEmpty(t_eParameters_3)), new Exists(v_eParameter, t_eParameters_4, new Exists(v_otherEParameter, t_eParameters_5, new And(new And(new Not(new Equality(v_eParameter, v_otherEParameter)), new Equality(t_eType, t_eType_1)), new Equality(new IndexOf(v_eOperation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS, v_eParameter), new IndexOf(v_otherEOpperation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS, v_otherEParameter))))))))));
		
		IConstraint constraint_ThereMayNotBeTwoOperationsAndWithTheSameSignature = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION, v_eOperation, formula);
		constraint_ThereMayNotBeTwoOperationsAndWithTheSameSignature.setName("ThereMayNotBeTwoOperationsAndWithTheSameSignature");
		constraint_ThereMayNotBeTwoOperationsAndWithTheSameSignature.setMessage("There may not be two operations with the same signature");
		
		return constraint_ThereMayNotBeTwoOperationsAndWithTheSameSignature;
	}
	
	public static IConstraint createThereMayNotBeTwoParametersNamedConstraint() {
		
		Variable v_eParameter = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EPARAMETER, "eParameter");
		Variable v_otherEParameter = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EPARAMETER, "otherEParameter");
		
		Term t_eOperation_eParameters = new Get(new Get(v_eParameter, org.eclipse.emf.ecore.EcorePackage.Literals.EPARAMETER__EOPERATION), org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_name = new Get(v_eParameter, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_name_1 = new Get(v_otherEParameter, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		
		Formula formula = new Not(new Exists(v_otherEParameter, t_eOperation_eParameters, new And(new Not(new Equality(v_eParameter, v_otherEParameter)), new Equality(t_name, t_name_1))));
		
		IConstraint constraint_ThereMayNotBeTwoParametersNamed = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EPARAMETER, v_eParameter, formula);
		constraint_ThereMayNotBeTwoParametersNamed.setName("ThereMayNotBeTwoParametersNamed");
		constraint_ThereMayNotBeTwoParametersNamed.setMessage("There may not be two parameters with the same name");
		
		return constraint_ThereMayNotBeTwoParametersNamed;
	}
	
	public static IConstraint createThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeatureConstraint() {
		
		Variable v_operation = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION, "operation");
		Variable v_annotation = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EANNOTATION, "annotation");
		Variable v_detail = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, "detail");
		Variable v_typeClosure = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS, "typeClosure");
		Variable v_feature = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE, "feature");
		Variable v_parameter = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EPARAMETER, "parameter");
		
		Term t_eAnnotations = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS);
		Term t_source = new Get(v_annotation, org.eclipse.emf.ecore.EcorePackage.Literals.EANNOTATION__SOURCE);
		Term t_details = new Get(v_annotation, org.eclipse.emf.ecore.EcorePackage.Literals.EANNOTATION__DETAILS);
		Term t_key = new Get(v_detail, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__KEY);
		Term t_value = new Get(v_detail, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__VALUE);
		Term t_eContainingClass = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__ECONTAINING_CLASS);
		Term t_eStructuralFeatures = new Get(v_typeClosure, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		Term t_eParameters = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_eParameters_1 = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_eType = new Get(v_parameter, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		Term t_eType_1 = new Get(v_feature, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		Term t_name = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_name_1 = new Get(v_feature, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_eParameters_2 = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_name_2 = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_name_3 = new Get(v_feature, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_eParameters_3 = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_name_4 = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_name_5 = new Get(v_feature, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_eParameters_4 = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_name_6 = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_name_7 = new Get(v_feature, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_eParameters_5 = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION__EPARAMETERS);
		Term t_name_8 = new Get(v_operation, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_name_9 = new Get(v_feature, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		
		Formula formula = new Or(new Exists(v_annotation, t_eAnnotations, new And(new Equality(t_source, new Constant("http://www.eclipse.org/emf/2002/GenModel")), new Exists(v_detail, t_details, new And(new Equality(t_key, new Constant("suppressedVisibility")), new Equality(t_value, new Constant("true")))))), new ForAll(v_typeClosure, new GetClosure(t_eContainingClass, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESUPER_TYPES), new ForAll(v_feature, t_eStructuralFeatures, new And(new And(new And(new And(new If(new And(new Equality(new Size(t_eParameters), new Constant(1)), new ForAll(v_parameter, t_eParameters_1, new Equality(t_eType, t_eType_1))), new Not(new Equality(t_name, new Concatenate(new Constant("set"), new Capitalize(t_name_1))))), new If(new Equality(new Size(t_eParameters_2), new Constant(0)), new Not(new Equality(t_name_2, new Concatenate(new Constant("get"), new Capitalize(t_name_3)))))), new If(new Equality(new Size(t_eParameters_3), new Constant(0)), new Not(new Equality(t_name_4, new Concatenate(new Constant("is"), new Capitalize(t_name_5)))))), new If(new Equality(new Size(t_eParameters_4), new Constant(0)), new Not(new Equality(t_name_6, new Concatenate(new Constant("isSet"), new Capitalize(t_name_7)))))), new If(new Equality(new Size(t_eParameters_5), new Constant(0)), new Not(new Equality(t_name_8, new Concatenate(new Constant("unset"), new Capitalize(t_name_9)))))))));
		
		IConstraint constraint_ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION, v_operation, formula);
		constraint_ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature.setName("ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature");
		constraint_ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature.setMessage("There may not be an operation with the same signature as an accessor method for a feature");
		
		return constraint_ThereMayNotBeAnOperationWithTheSameSignatureAsAnAccessorMethodForFeature;
	}
	
	public static IConstraint createThereMayNotBeTwoFeaturesNamedConstraint() {
		
		Variable v_eClass = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS, "eClass");
		Variable v_featureA = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE, "featureA");
		Variable v_featureB = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE, "featureB");
		Variable v_eClassX = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS, "eClassX");
		Variable v_eClassY = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS, "eClassY");
		Variable v_featureX = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE, "featureX");
		Variable v_featureY = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE, "featureY");
		
		Term t_eStructuralFeatures = new Get(v_eClass, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		Term t_eStructuralFeatures_1 = new Get(v_eClass, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		Term t_name = new Get(v_featureA, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_name_1 = new Get(v_featureB, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_eStructuralFeatures_2 = new Get(v_eClassX, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		Term t_eStructuralFeatures_3 = new Get(v_eClassY, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		Term t_name_2 = new Get(v_featureX, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_name_3 = new Get(v_featureY, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		
		Formula formula = new And(new ForAll(v_featureA, t_eStructuralFeatures, new ForAll(v_featureB, t_eStructuralFeatures_1, new If(new Not(new Equality(v_featureA, v_featureB)), new Not(new Equality(t_name, t_name_1))))), new ForAll(v_eClassX, new GetClosure(v_eClass, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESUPER_TYPES), new ForAll(v_eClassY, new GetClosure(v_eClass, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESUPER_TYPES), new If(new Not(new Equality(v_eClassX, v_eClassY)), new ForAll(v_featureX, t_eStructuralFeatures_2, new ForAll(v_featureY, t_eStructuralFeatures_3, new Not(new Equality(t_name_2, t_name_3))))))));
		
		IConstraint constraint_ThereMayNotBeTwoFeaturesNamed = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS, v_eClass, formula);
		constraint_ThereMayNotBeTwoFeaturesNamed.setName("ThereMayNotBeTwoFeaturesNamed");
		constraint_ThereMayNotBeTwoFeaturesNamed.setMessage("There may not be two features with the same name");
		
		return constraint_ThereMayNotBeTwoFeaturesNamed;
	}
	
	public static IConstraint createTwoFeaturesCannotBothBeIDsConstraint() {
		
		Variable v_attribute = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EATTRIBUTE, "attribute");
		Variable v_typeClosure = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS, "typeClosure");
		Variable v_feature = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE, "feature");
		
		Term t_iD = new Get(v_attribute, org.eclipse.emf.ecore.EcorePackage.Literals.EATTRIBUTE__ID);
		Term t_eContainingClass = new Get(v_attribute, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRUCTURAL_FEATURE__ECONTAINING_CLASS);
		Term t_eStructuralFeatures = new Get(v_typeClosure, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		Term t_iD_1 = new Get(v_feature, org.eclipse.emf.ecore.EcorePackage.Literals.EATTRIBUTE__ID);
		
		Formula formula = new If(new Equality(t_iD, BoolConstant.TRUE), new ForAll(v_typeClosure, new GetClosure(t_eContainingClass, org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS__ESUPER_TYPES), new ForAll(v_feature, t_eStructuralFeatures, new If(new And(new IsInstanceOf(v_feature, org.eclipse.emf.ecore.EcorePackage.Literals.EATTRIBUTE), new Not(new Equality(v_feature, v_attribute))), new Not(new Equality(t_iD_1, BoolConstant.TRUE))))));
		
		IConstraint constraint_TwoFeaturesCannotBothBeIDs = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EATTRIBUTE, v_attribute, formula);
		constraint_TwoFeaturesCannotBothBeIDs.setName("TwoFeaturesCannotBothBeIDs");
		constraint_TwoFeaturesCannotBothBeIDs.setMessage("The features cannot both be IDs");
		
		return constraint_TwoFeaturesCannotBothBeIDs;
	}
	
	public static IConstraint createThereMayNotBeTwoClassifiersNamedConstraint() {
		
		Variable v_package = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EPACKAGE, "package");
		Variable v_classA = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS, "classA");
		Variable v_classB = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ECLASS, "classB");
		
		Term t_eClassifiers = new Get(v_package, org.eclipse.emf.ecore.EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		Term t_eClassifiers_1 = new Get(v_package, org.eclipse.emf.ecore.EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		Term t_name = new Get(v_classA, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		Term t_name_1 = new Get(v_classB, org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		
		Formula formula = new ForAll(v_classA, t_eClassifiers, new Not(new Exists(v_classB, t_eClassifiers_1, new And(new Equality(t_name, t_name_1), new Not(new Equality(v_classA, v_classB))))));
		
		IConstraint constraint_ThereMayNotBeTwoClassifiersNamed = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EPACKAGE, v_package, formula);
		constraint_ThereMayNotBeTwoClassifiersNamed.setName("ThereMayNotBeTwoClassifiersNamed");
		constraint_ThereMayNotBeTwoClassifiersNamed.setMessage("There may not be two classifiers with the same name");
		
		return constraint_ThereMayNotBeTwoClassifiersNamed;
	}
	
	public static IConstraint createTheTypedElementMustHaveATypeConstraint() {
		
		Variable v_eTypedElement = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT, "eTypedElement");
		
		Term t_eType = new Get(v_eTypedElement, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		
		Formula formula = new Or(new IsInstanceOf(v_eTypedElement, org.eclipse.emf.ecore.EcorePackage.Literals.EOPERATION), new Not(new IsEmpty(t_eType)));
		
		IConstraint constraint_TheTypedElementMustHaveAType = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT, v_eTypedElement, formula);
		constraint_TheTypedElementMustHaveAType.setName("TheTypedElementMustHaveAType");
		constraint_TheTypedElementMustHaveAType.setMessage("The typed element must have a type");
		
		return constraint_TheTypedElementMustHaveAType;
	}
	
	public static IConstraint createTheRequiredFeatureOfMustBeSetConstraint() {
		
		Variable v_eModelElement = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EMODEL_ELEMENT, "eModelElement");
		
		Term t_eType = new Get(v_eModelElement, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		Term t_ePackage = new Get(v_eModelElement, org.eclipse.emf.ecore.EcorePackage.Literals.EFACTORY__EPACKAGE);
		Term t_eFactoryInstance = new Get(v_eModelElement, org.eclipse.emf.ecore.EcorePackage.Literals.EPACKAGE__EFACTORY_INSTANCE);
		Term t_eType_1 = new Get(v_eModelElement, org.eclipse.emf.ecore.EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		
		Formula formula = new And(new And(new And(new If(new IsInstanceOf(v_eModelElement, org.eclipse.emf.ecore.EcorePackage.Literals.EATTRIBUTE), new Not(new IsEmpty(t_eType))), new If(new IsInstanceOf(v_eModelElement, org.eclipse.emf.ecore.EcorePackage.Literals.EFACTORY), new Not(new IsEmpty(t_ePackage)))), new If(new IsInstanceOf(v_eModelElement, org.eclipse.emf.ecore.EcorePackage.Literals.EPACKAGE), new Not(new IsEmpty(t_eFactoryInstance)))), new If(new IsInstanceOf(v_eModelElement, org.eclipse.emf.ecore.EcorePackage.Literals.EREFERENCE), new Not(new IsEmpty(t_eType_1))));
		
		IConstraint constraint_TheRequiredFeatureOfMustBeSet = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EMODEL_ELEMENT, v_eModelElement, formula);
		constraint_TheRequiredFeatureOfMustBeSet.setName("TheRequiredFeatureOfMustBeSet");
		constraint_TheRequiredFeatureOfMustBeSet.setMessage("The required feature must be set");
		
		return constraint_TheRequiredFeatureOfMustBeSet;
	}
	
	public static IConstraint createTheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifierConstraint() {
		
		Variable v_eType = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EGENERIC_TYPE, "eType");
		
		Term t_eClassifier_eTypeParameters = new Get(new Get(v_eType, org.eclipse.emf.ecore.EcorePackage.Literals.EGENERIC_TYPE__ECLASSIFIER), org.eclipse.emf.ecore.EcorePackage.Literals.ECLASSIFIER__ETYPE_PARAMETERS);
		Term t_eTypeArguments = new Get(v_eType, org.eclipse.emf.ecore.EcorePackage.Literals.EGENERIC_TYPE__ETYPE_ARGUMENTS);
		
		Formula formula = new Equality(new Size(t_eClassifier_eTypeParameters), new Size(t_eTypeArguments));
		
		IConstraint constraint_TheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifier = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EGENERIC_TYPE, v_eType, formula);
		constraint_TheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifier.setName("TheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifier");
		constraint_TheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifier.setMessage("The generic type associated with the classifier is missing type arguments to match the number of type parameters of the classifier");
		
		return constraint_TheGenericTypeAssociatedWithTheClassifierShouldHaveTypeArgumentsToMatchTheNumberOfTypeParametersOfTheClassifier;
	}
	
	public static IConstraint createTheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParametersConstraint() {
		
		Variable v_eType = new Variable(org.eclipse.emf.ecore.EcorePackage.Literals.EGENERIC_TYPE, "eType");
		
		Term t_eClassifier_eTypeParameters = new Get(new Get(v_eType, org.eclipse.emf.ecore.EcorePackage.Literals.EGENERIC_TYPE__ECLASSIFIER), org.eclipse.emf.ecore.EcorePackage.Literals.ECLASSIFIER__ETYPE_PARAMETERS);
		Term t_eTypeArguments = new Get(v_eType, org.eclipse.emf.ecore.EcorePackage.Literals.EGENERIC_TYPE__ETYPE_ARGUMENTS);
		
		Formula formula = new Equality(new Size(t_eClassifier_eTypeParameters), new Size(t_eTypeArguments));
		
		IConstraint constraint_TheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParameters = new Constraint(org.eclipse.emf.ecore.EcorePackage.Literals.EGENERIC_TYPE, v_eType, formula);
		constraint_TheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParameters.setName("TheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParameters");
		constraint_TheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParameters.setMessage("The generic type associated with the classifier must not have more arguments then the classifier has type parameters");
		
		return constraint_TheGenericTypeAssociatedWithTheClassifierMustNotHaveArgumentsWhenTheClassifierHasTypeParameters;
	}
	
}
