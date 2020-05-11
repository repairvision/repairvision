package org.sidiff.validation.laguage.fol.generator

import java.util.Map
import java.util.regex.Pattern
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EStructuralFeature
import org.sidiff.validation.laguage.fol.firstOrderLogic.And
import org.sidiff.validation.laguage.fol.firstOrderLogic.AsClassifier
import org.sidiff.validation.laguage.fol.firstOrderLogic.AsDataType
import org.sidiff.validation.laguage.fol.firstOrderLogic.BoolConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Capitalize
import org.sidiff.validation.laguage.fol.firstOrderLogic.Classifier
import org.sidiff.validation.laguage.fol.firstOrderLogic.ClassifierConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Concatenate
import org.sidiff.validation.laguage.fol.firstOrderLogic.Constraint
import org.sidiff.validation.laguage.fol.firstOrderLogic.DataType
import org.sidiff.validation.laguage.fol.firstOrderLogic.DataTypeConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Equals
import org.sidiff.validation.laguage.fol.firstOrderLogic.Exists
import org.sidiff.validation.laguage.fol.firstOrderLogic.FeatureConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.ForAll
import org.sidiff.validation.laguage.fol.firstOrderLogic.Formula
import org.sidiff.validation.laguage.fol.firstOrderLogic.Get
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetClosure
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetContainer
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetContainments
import org.sidiff.validation.laguage.fol.firstOrderLogic.Greater
import org.sidiff.validation.laguage.fol.firstOrderLogic.GreaterEqual
import org.sidiff.validation.laguage.fol.firstOrderLogic.If
import org.sidiff.validation.laguage.fol.firstOrderLogic.Iff
import org.sidiff.validation.laguage.fol.firstOrderLogic.IndexOf
import org.sidiff.validation.laguage.fol.firstOrderLogic.IntConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.IsEmpty
import org.sidiff.validation.laguage.fol.firstOrderLogic.IsInstanceOf
import org.sidiff.validation.laguage.fol.firstOrderLogic.IsValueLiteralOf
import org.sidiff.validation.laguage.fol.firstOrderLogic.Not
import org.sidiff.validation.laguage.fol.firstOrderLogic.Or
import org.sidiff.validation.laguage.fol.firstOrderLogic.Size
import org.sidiff.validation.laguage.fol.firstOrderLogic.Smaller
import org.sidiff.validation.laguage.fol.firstOrderLogic.SmallerEqual
import org.sidiff.validation.laguage.fol.firstOrderLogic.StringConstant
import org.sidiff.validation.laguage.fol.firstOrderLogic.Variable
import org.sidiff.validation.laguage.fol.firstOrderLogic.VariableRef
import org.sidiff.validation.laguage.fol.firstOrderLogic.Xor

class FirstOrderLogicGeneratorConstraint {
	
	val META_TYPE_SEPERATION_PATTERN = Pattern.compile("(?<=[a-z])(?=[A-Z])");
	
	Map<Object, String> names = newHashMap
	
	Map<String, String> domains
	
	new(Map<String, String> domains) {
		this.domains = domains
	}
	
	def String doGenerate(Constraint constraint) {
		'''		
		public static IConstraint create«constraint.name»Constraint() {
			
			«FOR variable : constraint.eAllContents.filter(typeof(Variable)).toIterable»
			«compileVariable(variable)»
			«ENDFOR»
			
			«FOR getTerm : constraint.eAllContents.filter(typeof(VariableRef)).toIterable»
			«if (getTerm.get !== null) compileVariableRef(getTerm)»
			«ENDFOR»
			
			«compileConstraint(constraint.formula)»
			
			«var constraintName = newName(constraint, 'constraint_' + constraint.name)»
			IConstraint «constraintName» = new Constraint(«compileType(constraint.variable.type)», «names.get(constraint.variable)», «names.get(constraint.formula)»);
			«constraintName».setName("«constraint.name»");
			«constraintName».setMessage("«constraint.message»");
			
			return «constraintName»;
		}
		'''
	}
	
	private def String toMetaLiteralName(ENamedElement namedElement) {
		// Convert first character of name to upper case because of features like eType
		val matcher = META_TYPE_SEPERATION_PATTERN.matcher(namedElement.name.toFirstUpper)
		return matcher.replaceAll('_').toUpperCase
	}

	private def String toQualifiedPackageClass(EClassifier classifier) {
		return domains.get(classifier.EPackage.nsURI)
	}
	
	private def String newName(Object astNode, String name) {
		var newName = name
		var i = 0
		
		while (names.containsValue(newName)) {
			i++
			newName = name + '_' + i
		}
		
		names.put(astNode, newName)
		return newName
	}
		
	private def String compileConstraint(Formula formula) {
		var name = newName(formula, 'formula');
 		return 'Formula ' + name + ' = ' + compileFormula(formula) + ';'
	}
	
	private def String compileVariable(Variable variable) {
		var name = newName(variable, 'v_' + variable.name);
		return '''Variable «name» = new Variable(«compileType(variable.type)», "«variable.name»");'''
	}
	
	private def String compileVariableRef(VariableRef path) {
		
		// Term t1_m_receiveEvent_covered =
		var name = newName(path, '''t_«path.eAllContents.filter(typeof(Get)).map[name.name].join('_')»''');

		var getVariable = 'Term ' + name + ' = '
		
		//new Get(new Get(m, DOMAIN.getMessage_ReceiveEvent()), DOMAIN.getInteractionFragment_Covered());
		var code = new StringBuffer('new Get(' + names.get(path.name) + ', ' + compileFeature(path.get.name) + ')')
		compileGet(path.get.next, code)
		
		return getVariable + code + ';'
	}
	
	private def void compileGet(Get get, StringBuffer code) {
		
		if (get !== null) {
			code.insert(0, 'new Get(')
			code.append(', ' + compileFeature(get.name) + ')')
		
			compileGet(get.next, code)
		}
	}
	
	private def String compileType(Classifier type) {
		if (type instanceof ClassifierConstant) {
			return compileType(type.constant)
		} else if (type instanceof AsClassifier) {
			return compileFormula(type.term)
		}
	}
	
	private def String compileType(DataType type) {
		if (type instanceof DataTypeConstant) {
			return compileType(type.constant)
		} else if (type instanceof AsDataType) {
			return compileFormula(type.term)
		}
	}
	
	private def String compileType(EClassifier type) {
		if(type === null) {
			'null'
		} else {
			'''«type.toQualifiedPackageClass».Literals.«type.toMetaLiteralName»'''
		}
	}
	
	private def dispatch String compileFeature(FeatureConstant feature) {
		compileFeature(feature.constant)
	}

	private def dispatch String compileFeature(EStructuralFeature feature) {
		'''«feature.EContainingClass.toQualifiedPackageClass».Literals.«feature.EContainingClass.toMetaLiteralName»__«feature.toMetaLiteralName»'''
	}

	// TODO: Support EEnumLiteral navigation
//	private def String compileEnumLiteral(EEnumLiteral literal) {
//		'''«literal.EEnum.toQualifiedPackageClass».Literals.«literal.EEnum.toMetaLiteralName».getEEnumLiteral(«literal.value»)'''
//	}
	
	private def dispatch String compileFormula(Formula formula) {
		return 'MISSING_FORMULA'
	}
	
	private def dispatch String compileFormula(Iff iff) {
		return 'new Iff(' + compileFormula(iff.left) + ', ' + compileFormula(iff.right) + ')'
	}

	private def dispatch String compileFormula(If ifFormula) {
		return 'new If(' + compileFormula(ifFormula.left) + ', ' + compileFormula(ifFormula.right)  + ')'
	}
	
	private def dispatch String compileFormula(Xor xor) {
		return 'new Xor(' + compileFormula(xor.left) + ', ' + compileFormula(xor.right)  + ')'
	}
	
	private def dispatch String compileFormula(Or or) {
		return 'new Or(' + compileFormula(or.left) + ', ' + compileFormula(or.right)  + ')'
	}
	
	private def dispatch String compileFormula(And and) {
		return 'new And(' + compileFormula(and.left) + ', ' + compileFormula(and.right)  + ')'
	}
	
	private def dispatch String compileFormula(Not not) {
		return 'new Not(' + compileFormula(not.not) + ')'
	}
	
	private def dispatch String compileFormula(IsEmpty isEmpty) {
		return 'new IsEmpty(' + compileFormula(isEmpty.term) + ')'
	}
	
	private def dispatch String compileFormula(Equals equals) {			
		return 'new Equality(' + compileFormula(equals.left) + ', ' + compileFormula(equals.right) + ')'
	}
	
	private def dispatch String compileFormula(Greater greater) {
		return 'new IsGreater(' + compileFormula(greater.left) + ', ' + compileFormula(greater.right)  + ')'
	}
	
	private def dispatch String compileFormula(GreaterEqual greaterEqual) {
		return 'new IsGreaterEqual(' + compileFormula(greaterEqual.left) + ', ' + compileFormula(greaterEqual.right)  + ')'
	}
	
	private def dispatch String compileFormula(Smaller smaller) {
		return 'new IsSmaller(' + compileFormula(smaller.left) + ', ' + compileFormula(smaller.right)  + ')'
	}
	
	private def dispatch String compileFormula(SmallerEqual smallerEqual) {
		return 'new IsSmallerEqual(' + compileFormula(smallerEqual.left) + ', ' + compileFormula(smallerEqual.right)  + ')'
	}
	
	private def dispatch String compileFormula(IsInstanceOf isInstanceOf) {
		return 'new IsInstanceOf(' + compileFormula(isInstanceOf.term) + ', ' + compileType(isInstanceOf.type)  + ')'
	}
	
	private def dispatch String compileFormula(IsValueLiteralOf isValueLiteralOf) {
		return 'new IsValueLiteralOf(' + compileFormula(isValueLiteralOf.term) + ', ' + compileType(isValueLiteralOf.type)  + ')'
	}
	
	private def dispatch String compileFormula(ForAll forAll) {
		return 'new ForAll(' + compileFormula(forAll.name) + ', ' + compileFormula(forAll.iteration) +  ', '  + compileFormula(forAll.formula) + ')'
	}
	
	private def dispatch String compileFormula(Exists exists) {
		return 'new Exists(' + compileFormula(exists.name) + ', ' + compileFormula(exists.iteration) +  ', '  + compileFormula(exists.formula) + ')'
	}
	
	private def dispatch String compileFormula(IntConstant integer) {
		return 'new Constant(' + integer.value + ')'
	}
	
	private def dispatch String compileFormula(StringConstant string) {
		return 'new Constant("' + string.value + '")'
	}
	
	private def dispatch String compileFormula(BoolConstant bool) {
		if (bool.value) {
			return 'BoolConstant.TRUE'
		} else {
			return 'BoolConstant.FALSE'
		}
	}
	
	private def dispatch String compileFormula(Capitalize capitalize) {
		return 'new Capitalize(' + compileFormula(capitalize.string) + ')'
	}
	
	private def dispatch String compileFormula(Concatenate concatenate) {
		return 'new Concatenate(' + compileFormula(concatenate.left) + ', ' + compileFormula(concatenate.right) + ')'
	}
	
	private def dispatch String compileFormula(GetClosure getClosure) {
		return 'new GetClosure(' + compileFormula(getClosure.element) + ', ' + compileFeature(getClosure.feature) + ')'
	}
	
	private def dispatch String compileFormula(GetContainer getContainer) {
		return 'new GetContainer(' + compileFormula(getContainer.element) + ')'
	}
	
	private def dispatch String compileFormula(GetContainments getContainments) {
		return 'new GetContainments(' + compileFormula(getContainments.element) + ')'
	}
	
	private def dispatch String compileFormula(Size size) {
		return 'new Size(' + compileFormula(size.elements) + ')'
	}
	
	private def dispatch String compileFormula(IndexOf indexOf) {
		return 'new IndexOf(' + compileFormula(indexOf.container) + ", " + compileFeature(indexOf.feature) + ", " + compileFormula(indexOf.element) + ')'
	}
	
	private def dispatch String compileFormula(VariableRef variable) {
		if (variable.get !== null) {
			return names.get(variable)
		} else {
			return names.get(variable.name)			
		}
	}
	
	private def dispatch String compileFormula(Variable variable) {
		return names.get(variable)
	}
	 
}
