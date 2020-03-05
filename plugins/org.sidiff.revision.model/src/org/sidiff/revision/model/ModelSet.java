package org.sidiff.revision.model;

/**
 * A collection of models.
 * 
 * @author Manuel Ohrndorf
 */
public interface ModelSet extends Iterable<ModelASG> {
	
	/**
	 * @param model The abstract syntax graph of a model.
	 * @return <code>true</code> if the new model is added; <code>false</code>
	 *         otherwise, e.g., if the model is already contained in the set.
	 */
	boolean add(ModelASG model);
	
	/**
	 * @param model The abstract syntax graph of a model.
	 * @return <code>true</code> if the model is removed; <code>false</code>
	 *         otherwise, e.g., if the model is not contained in the set.
	 */
	boolean remove(ModelASG model);
	
	/**
	 * @param model The abstract syntax graph of a model.
	 * @return <code>true</code> if the model is contained in the set;
	 *         <code>false</code> otherwise.
	 */
	boolean contains(ModelASG model);

}
