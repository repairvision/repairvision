package org.sidiff.common.emf.derivation;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.sidiff.common.collections.DefaultComparators;

/**
 * Dieses Util dient der modularen Verwaltung und Organisation modelltypspezifischer, abgeleiteter Informationen im Anwendungskontext von ECore/EMF.
 * 
 * Zu diesem Zweck koennen Determinatoren definiert werden, die die Ableitung entsprechender Features uebernehmen. Anschliessend ist eine Entsprechende Instanz dieses Utilities zu bilden, bei der die Determinatoren registriert werde. Ueber diese instanz
 * koennen dann die abgeleiteten werte bestimmt werden.
 * 
 * Beispiel:
 * 
 * public class SimulinkDerivation extends AbstractFeatureDerivation {
 * 
 * public final static SimulinkDerivation INSTANCE = new SimulinkDerivation();
 * 
 * protected SimulinkDerivation(){ super(); registerDeterminator(FedByDeterminator.class); } }
 * 
 * @author Maik Schmidt
 * 
 */
public abstract class AbstractFeatureDerivation {

	private Map<EPackage, Map<Integer, Map<Integer, FeatureDeterminator<?, ?>>>> featureDeterminators = null;

	/**
	 * Erstellt eine neue "FeatureDerivation"-Instanz.
	 */
	protected AbstractFeatureDerivation() {
		this.featureDeterminators = new TreeMap<EPackage, Map<Integer, Map<Integer, FeatureDeterminator<?, ?>>>>(DefaultComparators.getHashComparator(EPackage.class));
	}

	/**
	 * Registriert eine bestimmte Determinatorklasse.
	 * 
	 * @param determinatorclass
	 *            zu registirierende Determinator Klasse.
	 */
	protected FeatureDeterminator<?,?> registerDeterminator(Class<? extends FeatureDeterminator<?, ?>> determinatorclass) {
		assert (determinatorclass != null) : "determinatorclass must not be null!";

		// Create determinator
		FeatureDeterminator<?, ?> origDeterminator = null;
		try {
			Constructor<? extends FeatureDeterminator<?, ?>> constructor = determinatorclass.getConstructor();
			origDeterminator = constructor.newInstance();
		} catch (Exception e) {
			assert (false) : "Determinator has to define a public, argumentless constructor!";
		}

		FeatureDeterminator<?, ?> determinator = null;
		if (determinatorclass.isAnnotationPresent(FeatureDeterminator.Cached.class)) {
			determinator = new CachedFeatureDeterminator(origDeterminator);
		} else {
			determinator = origDeterminator;
		}

		// Go to the right index entry
		Map<Integer, Map<Integer, FeatureDeterminator<?, ?>>> determinatorsForPackage = this.featureDeterminators.get(determinator.getPackage());
		if (determinatorsForPackage == null) {
			determinatorsForPackage = new TreeMap<Integer, Map<Integer, FeatureDeterminator<?, ?>>>();
			this.featureDeterminators.put(determinator.getPackage(), determinatorsForPackage);
		}

		Map<Integer, FeatureDeterminator<?, ?>> determinatorsForClassifier = determinatorsForPackage.get(determinator.getClassifierID());
		if (determinatorsForClassifier == null) {
			determinatorsForClassifier = new TreeMap<Integer, FeatureDeterminator<?, ?>>();
			determinatorsForPackage.put(determinator.getClassifierID(), determinatorsForClassifier);
		}

		// Store derivation for derived feature
		assert (!determinatorsForClassifier.containsKey(determinator.getFeatureID())) : 
			"Derivation for feature ID " + determinator.getFeatureID() 
			+ " of classifier ID " + determinator.getClassifierID() 
			+ " in package " + determinator.getPackage().getNsURI() 
			+ " already defined!";
		determinatorsForClassifier.put(determinator.getFeatureID(), determinator);
		
		return origDeterminator;
	}

	/**
	 * Bestimmt einen abgeleiteten Wert anhand des Metaobjektes, des Features und der Instanz.
	 * 
	 * @param metaObjectID
	 *            Die vom Package vergebene ID des Meta-Objektes (z.B. ModelPackage.IN_PORT).
	 * @param featureID
	 *            Die vom Package vergebene ID des Features (z.B. ModelPackage.IN_PORT__FED_BY).
	 * @param instance
	 *            die Instanz fuer die ein entsprechender Wert abgeleitet werden soll.
	 * @param resultType
	 *            Typ des abgeleiteten Wertes.
	 * @param ePackage
	 *            Das Package, für den der Derivator registriert ist. Notwendig, wenn Vererbung über die Paketgrenzen hinausgeht!
	 * @return Der abgeleitete Wert.
	 */
	@SuppressWarnings("unchecked")
	public <F extends EObject, T> T derive(int metaObjectID, int featureID, F instance, Class<T> resultType, EPackage ePackage) {
		assert (instance != null) : "Must provide a instance for derivation! (null)";
		assert (resultType != null) : "Must provide a type thats to derive! (null)";

		assert (featureDeterminators.containsKey(ePackage)) : "No derivation for package registered! " + ePackage.getNsURI() + " (unknown)";
		Map<Integer, Map<Integer, FeatureDeterminator<?, ?>>> determinatorsForPackage = this.featureDeterminators.get(ePackage);

		assert (determinatorsForPackage.containsKey(metaObjectID)) : "No derivation for meta-object (" + metaObjectID + ") in package (" + ePackage.getNsURI() + ") registered!";
		Map<Integer, FeatureDeterminator<?, ?>> determinatorsForClassifier = determinatorsForPackage.get(metaObjectID);

		assert (determinatorsForClassifier.containsKey(featureID)) : "No derivation for feature (" + featureID + ") of meta-object (" + metaObjectID + ") in package (" + ePackage.getNsURI() + ") registered!";
		return (T) ((FeatureDeterminator<F, T>) determinatorsForClassifier.get(featureID)).compute(instance);
	}

	/**
	 * Bestimmt einen abgeleiteten Wert anhand des Metaobjektes, des Features und der Instanz.
	 * 
	 * @param metaObjectID
	 *            Die vom Package vergebene ID des Meta-Objektes (z.B. ModelPackage.IN_PORT).
	 * @param featureID
	 *            Die vom Package vergebene ID des Features (z.B. ModelPackage.IN_PORT__FED_BY).
	 * @param instance
	 *            die Instanz fuer die ein entsprechender Wert abgeleitet werden soll.
	 * @param resultType
	 *            Typ des abgeleiteten wertes.
	 * @return Der abgeleitete Wert.
	 */
	public <F extends EObject, T> T derive(int metaObjectID, int featureID, F instance, Class<T> resultType) {
		return derive(metaObjectID, featureID, instance, resultType, instance.eClass().getEPackage());
	}
}
