package org.sidiff.common.collections;

import java.util.*;

/**
 * Das "ClassificationUtil" dient zu Klassifikation/Gruppierung einer gegebenen Menge (Collection) von Objekten nach einem gemeinsamen Merkmal. Das zur Klassifikation notwendige Merkmal muss dabei in Form eines Klassifikators (classifier) neben der
 * Collektion uebergeben werden. Das ergebniss ist jeweils eine Map, die zu jedem Merkmal die Menge der Objekte aus der uebergebenen Collection enthaelt, die dieses Merkmal besitzt.
 * 
 * Beispielsweise kann eine Menge von EObjects nach ihrer EClass Klassifiziert werden.
 * 
 * @author Maik Schmidt
 * 
 */
public class ClassificationUtil {

	/**
	 * Klassifiziert die Menge der im sinne der Klasse gleichen Objekte in Form einer Liste.
	 * 
	 * @see ClassificationUtil
	 * 
	 * @param <K>
	 *            Datentyp des Merkmals/Schl�ssels.
	 * @param <V>
	 *            Typ der zu Klassifizierenden Objekte.
	 * @param collection
	 *            Collection der zu Klassifizierenden Objekte.
	 * @param classifier
	 *            Klassifizierer, der zu jedem Objekt den entsprechenden Schluessel bestimmt.
	 * 
	 * @return Map, die entsprechend klassifizierte Objekte enthuelt.
	 */
	public static <K, V> Map<K, List<V>> classifiedLists(Collection<? extends V> collection, Classifier<K, V> classifier) {

		Map<K, List<V>> result = new HashMap<K, List<V>>();
		for (V item : collection) {
			K key = classifier.classify(item);
			List<V> list = result.get(key);
			if (list == null) {
				list = new LinkedList<V>();
				result.put(key, list);
			}
			list.add(item);
		}
		return result;
	}

	/**
	 * Klassifiziert die Menge der im sinne der Klasse gleichen Objekte in Form einer Menge; D.h. doppelte eintruege kuennen nicht vorkommen!
	 * 
	 * @see ClassificationUtil
	 * 
	 * @param <K>
	 *            Datentyp des Merkmals/Schluessels.
	 * @param <V>
	 *            Typ der zu Klassifizierenden Objekte.
	 * @param collection
	 *            Collection der zu Klassifizierenden Objekte.
	 * @param classifier
	 *            Klassifizierer, der zu jedem Objekt den entsprechenden Schluessel bestimmt.
	 * 
	 * @return Map, die entsprechend klassifizierte Objekte enthuelt.
	 */
	public static <K, V> Map<K, Set<V>> classifiedSets(Collection<? extends V> collection, Classifier<K, V> classifier) {

		Map<K, Set<V>> result = new HashMap<K, Set<V>>();
		for (V item : collection) {
			K key = classifier.classify(item);
			Set<V> list = result.get(key);
			if (list == null) {
				list = new HashSet<V>();
				result.put(key, list);
			}
			list.add(item);
		}
		return result;
	}

	/**
	 * Computes a map from a collection using a specified classfier to compute the corresponding keys.
	 * 
	 * @param <K>
	 *            Data type of the key.
	 * @param <V>
	 *            Data type of the objects to classify.
	 * @param collection
	 *            Collection containing the objects to classify.
	 * @param classifier
	 *            The classifier that computes for each object its key.
	 *          
	 * @return Map which holds all objects as value and their corresponding keys computed using the specified classifier.
	 * 
	 * @author Thomas Bender
	 */
	public static <K, V> Map<K, V> computeMap(Collection<? extends V> collection, Classifier<K, V> classifier) {

		Map<K, V> result = new HashMap<K, V>();
		for (V item : collection) {
			if (result.put(classifier.classify(item), item) != null) {
				throw new IllegalArgumentException("Key is not unique!");
			}
		}
		return result;
	}

	/**
	 * Klassifiziert die Menge der im sinne der Klasse gleichen Objekte in Form einer Liste. Die Schluessel der Map werden dabei gemueue des zu uebergebenden Comperators Sortiert.
	 * 
	 * @see ClassificationUtil
	 * 
	 * @param <K>
	 *            Datentyp des Merkmals/Schluessels.
	 * @param <V>
	 *            Typ der zu Klassifizierenden Objekte.
	 * @param collection
	 *            Collection der zu Klassifizierenden Objekte.
	 * @param classifier
	 *            Klassifizierer, der zu jedem Objekt den entsprechenden Schluessel bestimmt.
	 * @param comperator
	 *            zur sortierung der Schluessel.
	 * 
	 * @return Map, die entsprechend klassifizierte Objekte enthuelt.
	 */
	public static <K, V> SortedMap<K, List<V>> sortedClassifiedLists(Collection<? extends V> collection, Classifier<K, V> classifier, Comparator<K> comparator) {

		SortedMap<K, List<V>> result = new TreeMap<K, List<V>>(comparator);
		for (V item : collection) {
			K key = classifier.classify(item);
			List<V> list = result.get(key);
			if (list == null) {
				list = new LinkedList<V>();
				result.put(key, list);
			}
			list.add(item);
		}
		return result;
	}

	/**
	 * Klassifiziert die Menge der im sinne der Klasse gleichen Objekte in Form einer Menge; D.h. doppelte eintruege kuennen nicht vorkommen! Die Schluessel der Map werden dabei gemueue des zu uebergebenden Comperators Sortiert.
	 * 
	 * @see ClassificationUtil
	 * 
	 * @param <K>
	 *            Datentyp des Merkmals/Schluessels.
	 * @param <V>
	 *            Typ der zu Klassifizierenden Objekte.
	 * @param collection
	 *            Collection der zu Klassifizierenden Objekte.
	 * @param classifier
	 *            Klassifizierer, der zu jedem Objekt den entsprechenden Schluessel bestimmt.
	 * @param comperator
	 *            zur sortierung der Schluessel.
	 * 
	 * @return Map, die entsprechend klassifizierte Objekte enthuelt.
	 */
	public static <K, V> SortedMap<K, Set<V>> sortedClassifiedSets(Collection<? extends V> collection, Classifier<K, V> classifier, Comparator<K> comparator) {

		SortedMap<K, Set<V>> result = new TreeMap<K, Set<V>>(comparator);
		for (V item : collection) {
			K key = classifier.classify(item);
			Set<V> list = result.get(key);
			if (list == null) {
				list = new HashSet<V>();
				result.put(key, list);
			}
			list.add(item);
		}
		return result;
	}
}
