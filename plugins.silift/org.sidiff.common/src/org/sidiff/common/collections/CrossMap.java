package org.sidiff.common.collections;

import java.util.*;

import org.sidiff.common.util.ReflectionUtil;

/**
 * This map implements the management of unique bidirectional relationships between objects.
 * It is basically a map that points from one object to another and backwards.
 * It has been implemented by using two hash maps. 
 */
public class CrossMap<K, V> implements Map<K, V>{

	private Map<K, V> map = null;
	private Map<V, K> rMap = null;


	/**
	 * Neue Instanz einer CrossMap, implementiert als HashMap.
	 */
	public CrossMap() {
		map = new HashMap<K, V>();
		rMap = new HashMap<V, K>();
	}
	
	/**
	 * Neue Instanz einer CrossMap, implementiert durch eine zu �bergebende Klasse.
	 * 
	 * @param implClass Eine Map implementierende Klasse.
	 */
	@SuppressWarnings("unchecked")
	public CrossMap(Class<? extends Map> implClass) {
		map = ReflectionUtil.createInstance(implClass);
		rMap = ReflectionUtil.createInstance(implClass);
	}

	@Override
	public void clear() {
		map.clear();
		rMap.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}
	
	@Override
	public V get(Object key) {
		return map.get(key);
	}

	
	/**
	 * @param value
	 * @return
	 */
	public K getKey(Object value) {
		return rMap.get(value);
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public V put(K key, V value) {
		rMap.put(value, key);
		return map.put(key, value);
	}
	@Override
	public V remove(Object key) {
		V v = map.get(key);
		rMap.remove(v);
		return map.remove(key);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public String toString() {
		return map.toString();
	}
	
	@Override
	public Collection<V> values() {
		return map.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return map.entrySet();
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		if(m!=null){
			map.putAll(m);
			for(K key : m.keySet()){
				rMap.put(m.get(key), key);
			}
		}
	}
}
