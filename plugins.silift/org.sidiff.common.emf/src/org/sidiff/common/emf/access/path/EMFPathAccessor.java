package org.sidiff.common.emf.access.path;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Accessor-API-Interface to encapsulate specific path-engines.  
 */
public interface EMFPathAccessor {

	/**
	 * Causes the translation of a (may engine specific) textual path description into
	 * a Engine specific EMFPath-Object-Instance for futher usage.
	 *  
	 * @param eClass Starting point of the path description.
	 * @param path An engine specific, textual path description.
	 * @return A engine specific handle to the path semantic.
	 */
	public EMFPath translatePath(EClass eClass, String path);
	
	/**
	 * Trys to infer the result type of a given EMF-Path.
	 * The Method may returns null if no common type could be found or the
	 * underlaying engine is still not able to infer a result type.
	 * 
	 * @param path The Path witchs resultype shoult be inferd.
	 * @return a type (may a supertype) of all objects that could be returned as a evaluation result of the given Path.
	 */
	public EClass inferResultType(EMFPath path);
	
	/**
	 * Evaluates the Path on a given Node.
	 * 
	 * @param context The context node the evaluation starts.
	 * @param path Handle to a translated path expression.
	 * @param strategy the Evaluation strategy used to evaluate the Path.
	 * 
	 * @return A result, depending on the given strategy (type and semantic) 
	 */
	public <T> T evaluatePath(EObject context,EMFPath path,Class<? extends PathEvaluationStrategy<T>> strategy);
	
}
