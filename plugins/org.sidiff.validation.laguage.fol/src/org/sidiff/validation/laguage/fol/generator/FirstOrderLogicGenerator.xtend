/*
 * generated by Xtext 2.10.0
 */
package org.sidiff.validation.laguage.fol.generator

import java.util.Collections
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil.Copier
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.sidiff.validation.laguage.fol.firstOrderLogic.And
import org.sidiff.validation.laguage.fol.firstOrderLogic.BoolConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Capitalize
import org.sidiff.validation.laguage.fol.firstOrderLogic.Concatenate
import org.sidiff.validation.laguage.fol.firstOrderLogic.Constraint
import org.sidiff.validation.laguage.fol.firstOrderLogic.ConstraintLibrary
import org.sidiff.validation.laguage.fol.firstOrderLogic.Equals
import org.sidiff.validation.laguage.fol.firstOrderLogic.Exists
import org.sidiff.validation.laguage.fol.firstOrderLogic.ForAll
import org.sidiff.validation.laguage.fol.firstOrderLogic.Formula
import org.sidiff.validation.laguage.fol.firstOrderLogic.Get
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetClosure
import org.sidiff.validation.laguage.fol.firstOrderLogic.Greater
import org.sidiff.validation.laguage.fol.firstOrderLogic.GreaterEqual
import org.sidiff.validation.laguage.fol.firstOrderLogic.If
import org.sidiff.validation.laguage.fol.firstOrderLogic.Iff
import org.sidiff.validation.laguage.fol.firstOrderLogic.IntConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.IsEmpty
import org.sidiff.validation.laguage.fol.firstOrderLogic.IsInstanceOf
import org.sidiff.validation.laguage.fol.firstOrderLogic.Not
import org.sidiff.validation.laguage.fol.firstOrderLogic.Or
import org.sidiff.validation.laguage.fol.firstOrderLogic.Smaller
import org.sidiff.validation.laguage.fol.firstOrderLogic.SmallerEqual
import org.sidiff.validation.laguage.fol.firstOrderLogic.StringConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Variable
import org.sidiff.validation.laguage.fol.firstOrderLogic.VariableRef
import org.sidiff.validation.laguage.fol.firstOrderLogic.Xor
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetContainer
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetContainments
import org.sidiff.validation.laguage.fol.firstOrderLogic.Size
import org.sidiff.validation.laguage.fol.firstOrderLogic.IndexOf
import org.sidiff.validation.laguage.fol.firstOrderLogic.ClassifierConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Classifier
import org.sidiff.validation.laguage.fol.firstOrderLogic.AsClassifier
import org.sidiff.validation.laguage.fol.firstOrderLogic.IsValueLiteralOf
import org.sidiff.validation.laguage.fol.firstOrderLogic.DataType
import org.sidiff.validation.laguage.fol.firstOrderLogic.AsDataType
import org.sidiff.validation.laguage.fol.firstOrderLogic.DataTypeConstant

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
 // FIXME: Bind scope of variables to quantifiers!
class FirstOrderLogicGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var names = new HashMap<Object, String>();
		
		var constraintCounter = 0
		var variableCounter = 0
		var pathCounter = 0
		
		var ruleBase = getRuleBase(resource)
		var packageImportClass = getPackageImportClass(ruleBase.packageImport)
		
		var packageName = resource.URI.trimFileExtension.lastSegment
		var className = 'ConstraintLibrary' + packageImportClass

		var code = 
			'''
			package «packageName»;
			
			import java.util.ArrayList;
			import java.util.HashMap;
			import java.util.List;
			import java.util.Map;
			
			import «ruleBase.packageImport»;
			
			import org.sidiff.validation.constraint.api.library.*;
			
			import org.sidiff.validation.constraint.interpreter.*;
			import org.sidiff.validation.constraint.interpreter.formulas.binary.*;
			import org.sidiff.validation.constraint.interpreter.formulas.predicates.*;
			import org.sidiff.validation.constraint.interpreter.formulas.quantifiers.*;
			import org.sidiff.validation.constraint.interpreter.formulas.unary.*;
			import org.sidiff.validation.constraint.interpreter.terms.*;
			import org.sidiff.validation.constraint.interpreter.terms.functions.*;
			
			public class «className» implements IConstraintLibrary {
				
				private static String documentType = «packageImportClass».eINSTANCE.getNsURI();
					
				private static «packageImportClass» DOMAIN = «packageImportClass».eINSTANCE;
				
				private static Map<String, IConstraint> rules = new HashMap<>();
					
				static {
					«FOR constraint : ruleBase.constraints»
						addConstraint(create«constraint.name»Rule());
					«ENDFOR»
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
				«FOR constraint : ruleBase.constraints»
				
				public static IConstraint create«constraint.name»Rule() {
					
					«FOR variable : constraint.eAllContents.filter(typeof(Variable)).toIterable»
						«compileVariable(variable, variableCounter++, names)»
					«ENDFOR»
				
					«FOR getTerm : constraint.eAllContents.filter(typeof(VariableRef)).toIterable»
						«if (getTerm.get !== null) compileVariableRef(getTerm, pathCounter++, names)»
					«ENDFOR»
				
					«compileConstraint(constraint, constraintCounter++, names)»
					
					«var ruleName = 'rule_' + constraint.name»
					IConstraint «ruleName» = new Constraint(«compileType(constraint.variable.type)», «names.get(constraint.variable)», «names.get(constraint)»);
					«ruleName».setName("«constraint.name»");
					«ruleName».setMessage("«constraint.message»");
					
					return «ruleName»;
				}
				«ENDFOR»
			}
			'''
		
		fsa.generateFile(packageName + '/' + className + '.java', code)
		saveAsXMI(resource);
	}
	
	def String getPackageImportClass(String packageImport) {
		return packageImport.subSequence(packageImport.lastIndexOf('.') + 1, packageImport.length) as String 
	}
	
	def ConstraintLibrary getRuleBase(Resource resource) {
		return (resource.contents.get(0) as ConstraintLibrary)
	}
	
	def String newName(HashMap<Object, String> names, Object astNode, String name) {
		var newName = name
		var i = 0
		
		while (names.containsKey(newName)) {
			i++
			newName = name + i
		}
		
		names.put(astNode, newName)
		return name
	}
		
	def String compileConstraint(Constraint constraint, int constraintCounter, HashMap<Object, String> names) {
		var name = 'constraint' + constraintCounter + '_' + constraint.name
		name = newName(names, constraint, name);
		
 		return 'Formula ' + name + ' = ' + compileFormula(constraint.formula, names) + ';'
	}
	
	def String compileVariable(Variable variable, int counter, HashMap<Object, String> names) {
		var name = 'v' + counter + '_' + variable.name;
		name = newName(names, variable, name);
		
		return '''Variable «name» = new Variable("«variable.name»");'''
	}
	
	def String compileVariableRef(VariableRef path, int counter, HashMap<Object, String> names) {
		
		// Term t1_m_receiveEvent_covered =
		var name = '''t«counter»_«path.eAllContents.filter(typeof(Get)).map[name.name].join('_')»'''
		name = newName(names, path, name);

		var getVariable = 'Term ' + name + ' = '
		
		//new Get(new Get(m, DOMAIN.getMessage_ReceiveEvent()), DOMAIN.getInteractionFragment_Covered());
		var code = new StringBuffer('new Get(' + names.get(path.name) + ', ' + compileFeature(path.get.name) + ')')
		compileGet(path.get.next, code)
		
		return getVariable + code + ';'
	}
	
	def void compileGet(Get get, StringBuffer code) {
		
		if (get !== null) {
			code.insert(0, 'new Get(')
			code.append(', ' + compileFeature(get.name) + ')')
		
			compileGet(get.next, code)
		}
	}
	
	def String compileType(EClassifier type) {
		return 'DOMAIN.get' + type.name + '()'
	}
	
	def String compileType(Classifier type, HashMap<Object, String> names) {
		if (type instanceof ClassifierConstant) {
			return compileType(type.constant)
		} else if (type instanceof AsClassifier) {
			return compileFormula(type.term, names)
		}
	}
	
	def String compileType(DataType type, HashMap<Object, String> names) {
		if (type instanceof DataTypeConstant) {
			return compileType(type.constant)
		} else if (type instanceof AsDataType) {
			return compileFormula(type.term, names)
		}
	}
	
	def String compileFeature(EStructuralFeature feature) {
		return 'DOMAIN.get' + feature.EContainingClass.name + '_' + feature.name.toFirstUpper + '()'
	}
	
	def dispatch String compileFormula(Formula formula, HashMap<Object, String> names) {
		return 'MISSING_FORMULA'
	}
	
	def dispatch String compileFormula(Iff iff, HashMap<Object, String> names) {
		return 'new Iff(' + compileFormula(iff.left, names) + ', ' + compileFormula(iff.right, names) + ')'
	}

	def dispatch String compileFormula(If ifFormula, HashMap<Object, String> names) {
		return 'new If(' + compileFormula(ifFormula.left, names) + ', ' + compileFormula(ifFormula.right, names)  + ')'
	}
	
	def dispatch String compileFormula(Xor xor, HashMap<Object, String> names) {
		return 'new Xor(' + compileFormula(xor.left, names) + ', ' + compileFormula(xor.right, names)  + ')'
	}
	
	def dispatch String compileFormula(Or or, HashMap<Object, String> names) {
		return 'new Or(' + compileFormula(or.left, names) + ', ' + compileFormula(or.right, names)  + ')'
	}
	
	def dispatch String compileFormula(And and, HashMap<Object, String> names) {
		return 'new And(' + compileFormula(and.left, names) + ', ' + compileFormula(and.right, names)  + ')'
	}
	
	def dispatch String compileFormula(Not not, HashMap<Object, String> names) {
		return 'new Not(' + compileFormula(not.not, names) + ')'
	}
	
	def dispatch String compileFormula(IsEmpty isEmpty, HashMap<Object, String> names) {
		return 'new IsEmpty(' + compileFormula(isEmpty.term, names) + ')'
	}
	
	def dispatch String compileFormula(Equals equals, HashMap<Object, String> names) {			
		return 'new Equality(' + compileFormula(equals.left, names) + ', ' + compileFormula(equals.right, names) + ')'
	}
	
	def dispatch String compileFormula(Greater greater, HashMap<Object, String> names) {
		return 'new IsGreater(' + compileFormula(greater.left, names) + ', ' + compileFormula(greater.right, names)  + ')'
	}
	
	def dispatch String compileFormula(GreaterEqual greaterEqual, HashMap<Object, String> names) {
		return 'new IsGreaterEqual(' + compileFormula(greaterEqual.left, names) + ', ' + compileFormula(greaterEqual.right, names)  + ')'
	}
	
	def dispatch String compileFormula(Smaller smaller, HashMap<Object, String> names) {
		return 'new IsSmaller(' + compileFormula(smaller.left, names) + ', ' + compileFormula(smaller.right, names)  + ')'
	}
	
	def dispatch String compileFormula(SmallerEqual smallerEqual, HashMap<Object, String> names) {
		return 'new IsSmallerEqual(' + compileFormula(smallerEqual.left, names) + ', ' + compileFormula(smallerEqual.right, names)  + ')'
	}
	
	def dispatch String compileFormula(IsInstanceOf isInstanceOf, HashMap<Object, String> names) {
		return 'new IsInstanceOf(' + compileFormula(isInstanceOf.term, names) + ', ' + compileType(isInstanceOf.type, names)  + ')'
	}
	
	def dispatch String compileFormula(IsValueLiteralOf isValueLiteralOf, HashMap<Object, String> names) {
		return 'new IsValueLiteralOf(' + compileFormula(isValueLiteralOf.term, names) + ', ' + compileType(isValueLiteralOf.type, names)  + ')'
	}
	
	def dispatch String compileFormula(ForAll forAll, HashMap<Object, String> names) {
		return 'new ForAll(' + compileFormula(forAll.name, names) + ', ' + compileFormula(forAll.iteration, names) +  ', '  + compileFormula(forAll.formula, names) + ')'
	}
	
	def dispatch String compileFormula(Exists exists, HashMap<Object, String> names) {
		return 'new Exists(' + compileFormula(exists.name, names) + ', ' + compileFormula(exists.iteration, names) +  ', '  + compileFormula(exists.formula, names) + ')'
	}
	
	def dispatch String compileFormula(IntConstant integer, HashMap<Object, String> names) {
		return 'new Constant(' + integer.value + ')'
	}
	
	def dispatch String compileFormula(StringConstant string, HashMap<Object, String> names) {
		return 'new Constant("' + string.value + '")'
	}
	
	def dispatch String compileFormula(BoolConstant bool, HashMap<Object, String> names) {
		if (bool.value.equalsIgnoreCase('true')) {
			return 'BoolConstant.TRUE'
		} else {
			return 'BoolConstant.FALSE'
		}
	}
	
	def dispatch String compileFormula(Capitalize capitalize, HashMap<Object, String> names) {
		return 'new Capitalize(' + compileFormula(capitalize.string, names) + ')'
	}
	
	def dispatch String compileFormula(Concatenate concatenate, HashMap<Object, String> names) {
		return 'new Concatenate(' + compileFormula(concatenate.left, names) + ', ' + compileFormula(concatenate.right, names) + ')'
	}
	
	def dispatch String compileFormula(GetClosure getClosure, HashMap<Object, String> names) {
		return 'new GetClosure(' + compileFormula(getClosure.element, names) + ', ' + compileFeature(getClosure.feature) + ')'
	}
	
	def dispatch String compileFormula(GetContainer getContainer, HashMap<Object, String> names) {
		return 'new GetContainer(' + compileFormula(getContainer.element, names) + ')'
	}
	
	def dispatch String compileFormula(GetContainments getContainments, HashMap<Object, String> names) {
		return 'new GetContainments(' + compileFormula(getContainments.element, names) + ')'
	}
	
	def dispatch String compileFormula(Size size, HashMap<Object, String> names) {
		return 'new Size(' + compileFormula(size.elements, names) + ')'
	}
	
		def dispatch String compileFormula(IndexOf indexOf, HashMap<Object, String> names) {
		return 'new IndexOf(' + compileFormula(indexOf.container, names) + ", " + compileFeature(indexOf.feature) + ", " + compileFormula(indexOf.element, names) + ')'
	}
	
	def dispatch String compileFormula(VariableRef variable, HashMap<Object, String> names) {
		if (variable.get !== null) {
			return names.get(variable)
		} else {
			return names.get(variable.name)			
		}
	}
	
	def dispatch String compileFormula(Variable variable, HashMap<Object, String> names) {
		return names.get(variable)
	}
	 
	def static void saveAsXMI(Resource resource) {
		var root = resource.contents.get(0)
		var trace = deepCopy(root)
		
		var copyRoot = trace.get(root)
		var resourceSet = new ResourceSetImpl();
		
	 	var xmiResource = resourceSet.createResource(resource.URI.trimFileExtension.appendFileExtension("xmi"));
		xmiResource.contents.add(copyRoot);
		
		xmiResource.save(Collections.emptyMap());
	}
	
	/**
	 * Creates a deep copy (i.e. full tree content) of the given object.
	 * 
	 * @param original
	 *            The root object which will be copied.
	 * @return The copy trace: Original -> Copy
	 */
	def static Map<EObject, EObject> deepCopy(EObject original) {

		// Copier = Map: Original -> Copy
		var copier = new Copier();

		// Root:
		copier.copy(original);

		// References:
		copier.copyReferences();

		return copier;
	}
}
