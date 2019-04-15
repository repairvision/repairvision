package org.sidiff.common.emf.ocl;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.exceptions.SiDiffRuntimeException;

/**
 * Utility to check OCL conditions on models.
 * 
 * @author wenzel
 *
 */
public class OCLUtil {

	/**
	 * Selects all elements from the given resource that fulfill the given condition.
	 * @param model
	 * @param expression
	 * @param contextClassifier Optional. Defines the context class of the OCL expression.
	 * @return
	 */
	public static Collection<EObject> selectFrom(Resource model, String expression, EClassifier contextClassifier) {
		return selectFrom(EMFUtil.createListFromEAllContents(model), expression, contextClassifier);
	}
	
	/**
	 * Selects all elements from the given collection of elements that fulfill the given condition.
	 * @param elements
	 * @param expression
	 * @param contextClassifier Optional. Defines the context class of the OCL expression.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Collection<EObject> selectFrom(Collection<EObject> elements, String expression, EClassifier contextClassifier) {
		OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();
		EObjectCondition condition;
		try {
			condition = new BooleanOCLCondition<EClassifier, EClass, EObject>(
			    ocl.getEnvironment(),
			    expression,
			    contextClassifier);
		} catch (ParserException e) {
			throw new SiDiffRuntimeException("Unable to create OCL condition '"+expression+"'",e);
		}

		SELECT statement = new SELECT(new FROM(elements), new WHERE(condition));
		IQueryResult results = statement.execute();
		Exception e = results.getException();
		if (e != null) {
			throw new SiDiffRuntimeException("Unable to query model (SELECT with '"+expression+"'",e);
		}
		
		return Collections.unmodifiableCollection(results.getEObjects());
	}
	
	/**
	 * Creates an OCLCondition which can be evaluated on different EObjects.
	 * @param expression
	 * @param contextClassifier Optional. Defines the context class of the OCL expression.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static OCLCondition createCondition(String expression, EClassifier contextClassifier) {
		OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();
		EObjectCondition condition;
		try {
			condition = new BooleanOCLCondition<EClassifier, EClass, EObject>(
			    ocl.getEnvironment(),
			    expression,
			    contextClassifier);
		} catch (ParserException e) {
			throw new SiDiffRuntimeException("Unable to create OCL condition '"+expression+"'",e);
		}
		return new OCLCondition(expression, condition);
	}

	/**
	 * Checks whether the given element fulfills the given condition.
	 * @param object
	 * @param expression
	 * @param contextClassifier Optional. Defines the context class of the OCL expression.
	 * @return
	 */
	public static boolean checkCondition(EObject object, String expression, EClassifier contextClassifier) {
		return createCondition(expression, contextClassifier).check(object);
	}
	
}
