package org.sidiff.common.emf.derivation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE; 
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * Definition der Determinator-Schnittstelle.
 * Ein Determinator adressiert die ableitung eines einzelnen wertes auf der Grundlage einer Instanz, fuer die
 * ein entsprechender Wert zu berechnen ist.
 * 
 * Falls der berechnete wert statisch ist kann der berechnete wert mittels der Annotation \@Cached als zu cached 
 * gekennzeichnet werden.
 *  
 * @author Maik Schmidt
 *
 * @param <T> Typ des berechneten (Abgeleiteten) Wertes.
 */
public interface FeatureDeterminator<F extends EObject,T> {
	
	/**
	 * Defines the Package thats addressed by the Determinator.
	 * @return The addressed EPackage.
	 */
	public EPackage getPackage();
	
	/**
	 * Identifies the Classifier, thats Feature will be derived by the Determinator.
	 * @return the classifier ID thats provided by the Classifiers Package.
	 */
	public int getClassifierID();
	
	/**
	 * Identifies the Feature, that will be derived by the Determinator.
	 * @return the Feature ID of the derived value as provided by the Classifiers Package.
	 */
	public int getFeatureID();
	
	/**
	 * computes der derived value.
	 * @param holder
	 * @return
	 */
	public T compute(F holder);
	
	@Target(TYPE)
	@Retention(RUNTIME) 
	public @interface Cached {}
}
