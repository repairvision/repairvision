package org.sidiff.common.collections;

import java.io.Serializable;
import java.util.*;

/**
 * Die ValueMap ist eine effiziente, Surjektive Abbildung von
 * Objekten auf Werte. Die Abfrage der Objekte eines Wertes kann daher
 * eine Menge zurueckliefern.
 * 
 * Objekte wie Werte sollten dabei das Compareble-Interface Implementieren.
 * Falls dies nicht moeglich ist muss ein entsprechender Comperator
 * uebergeben werden. Wird kein eigener Comperator bereitgestellt, kann in 
 * jedem Fall der DefaultObjectComperator verwendet werden!
 * 
 * @see Comparator
 * @see DefaultComparators
 * 
 * @author Maik Schmidt
 *
 * @param <V> Typ der Werte
 * @param <O> Typ der Objekte
 */
@SuppressWarnings("serial")
public class ValueMap<V, O> implements Serializable {

	private Map<V, Collection<O>> value2objects = null;
	private Map<O, V> objects2value = null;

	/**
	 * Default Konstruktor; Beide Maps werden als Hashmaps ausgefuehrt,
	 *  ein Komparator wird nicht benoetigt und verwendet.
	 */
	public ValueMap() {
		this.objects2value = new HashMap<O, V>();
		this.value2objects = new HashMap<V, Collection<O>>();
	}

	
	/**
	 * Konstruktor mit der Moeglichkeit Comperatoren{@link Comparator} fuer Value und
	 * Object zu uebergeben.
	 * 
	 * @param valueComparator Comperator fuer Values des Typs V
	 * @param objectComperator Comperator fuer Objects des Typs O
	 */
	public ValueMap(Comparator<V> valueComparator,Comparator<O> objectComperator) {
		this.objects2value = new TreeMap<O, V>(objectComperator);
		this.value2objects = new TreeMap<V, Collection<O>>(valueComparator);
	}	

	/**
	 * Konstruktor mit der Moeglichkeit einen Komparator {@link Comparator} fuer Object zu uebergeben.
	 * Values werden auf Basis Ihrer natuerlichen Ordnung geordnet.
	 * 
	 * @param objectComperator Comperator fuer Objects des Typs O
	 */
	public ValueMap(Comparator<O> objectComperator) {
		
			this.objects2value = new TreeMap<O, V>(objectComperator);
			this.value2objects = new TreeMap<V, Collection<O>>();
	}
	
	/**
	 * Bestimmt die Menge aller aktuellen Werte der ValueMap.
	 * 
	 * @return Menge aller aktuellen Werte
	 */
	public Set<V> getValues() {
		
		return value2objects.keySet();
	}

	/**
	 * Bestimmt den Wert eines Objekt.
	 * 
	 * @param object
	 * @return Wert fuer das uebergebene Objekt!
	 */
	public V getValue(O object) {

		return objects2value.get(object);
	}

	/**
	 * Bestimmt die Menge der Objekte eines bestimmten Wertes.
	 * 
	 * @param value 
	 * @return Objekte der Map mit Wert value
	 */
	public Collection<O> getObjects(V value) {
		
		if (value2objects.containsKey(value))
			return Collections.unmodifiableCollection(value2objects.get(value));
		else
			return Collections.emptyList();
	}

	public Set<O> getValuedObjects() {
		return Collections.unmodifiableSet(objects2value.keySet());
	}

	public boolean isUnique(V value) {
		Collection<O> objects = value2objects.get(value);
		return (objects != null && objects.size() == 1);
	}
	
	public boolean containsValue(V value){
		
		return this.value2objects.containsKey(value);
	}
	
	public boolean containsObject(O object){
		
		return this.objects2value.containsKey(object);
	}

	/**
	 * Fuegt eine neue Abbildung hinzu.
	 * 
	 * @param object Das neue, abzubildende Objekt
	 * @param value Der Wert, auf den das Objekt abgebildet werden soll.
	 */
	public void put(O object, V value) {

		Collection<O> objects = value2objects.get(value);
		if (objects == null) {
			if(value.equals("Customer")) 
				System.out.println();
			objects = new LinkedList<O>();
			value2objects.put(value, objects);
		}
		objects.add(object);

		if (objects2value.put(object, value)!=null) {
			throw new IllegalArgumentException(object + " has already a value! (old="+objects2value.get(object)+", new="+value);
		}
	}

	/**
	 * Entfernt einen bestimmten Wert aus der Map und mit ihm alle dazugeh�rigen Objekte.
	 * 
	 * @param value Zu entfernender Wert
	 */
	public void remove(V value) {
		
		Collection<O> objects = value2objects.remove(value);
		if(objects!=null){
			for (O object : objects) {
				objects2value.remove(object);
			}
		}
	}
	
	/**
	 * Entfernt einen bestimmtes Objekt aus der Map und mit ihm ggf. den
	 * dazugehoerenden Wert.
	 * 
	 * @param value Zu entfernender Wert
	 */
	public void removeObject(O object) {
		
		V value = this.objects2value.remove(object);
		
		Collection<O> objects = this.value2objects.get(value);
		objects.remove(object);
		if(objects.isEmpty()){
			this.value2objects.remove(value);
		}
	}

	/**
	 * Fuegt den Inhalt einer ValueMap hinzu.
	 * 
	 * @param otherMap ValueMap deren Inhalt hinzugef�gt werden soll.
	 */
	public void insert(ValueMap<V, O> otherMap) {
		
		for (O otherNode : otherMap.objects2value.keySet()) {
			put(otherNode, otherMap.objects2value.get(otherNode));
		}
	}

	/**
	 * Betimmt die Werte, denen mindestens "minimalFillSize" Objekte zugeordnet sind.
	 * 
	 * @param minimalFillSize
	 * @return 
	 */
	public Set<V> getFilledValues(int minimalFillSize) {
		
		HashSet<V> values = new HashSet<V>(value2objects.keySet());
		for (V value : value2objects.keySet()) {
			Collection<O> elements = this.getObjects(value);
			if (elements.size() < minimalFillSize) {
				values.remove(value);
			}
		}
		return values;
	}
}
