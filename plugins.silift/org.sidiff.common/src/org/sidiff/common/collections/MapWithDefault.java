package org.sidiff.common.collections;

import java.util.*;

import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;

/**
 * This map decorated another map by extending it with a default value that is
 * returned for undefined keys.
 */
public class MapWithDefault<K, V> implements Map<K, V> {

	private V defaultValue = null;
	private Map<K, V> decoratedMap = null;
	
	/**
	 * Decorates the given map.
	 * 
	 * @param decorated The map to be decorated.
	 */
	public MapWithDefault(Map<K, V> decorated) {
		if (decorated != null) {
			this.decoratedMap = decorated;
		} else {
			throw new IllegalArgumentException("Decorated Map cannot be null!");
		}
	}

	/**
	 * Sets the default value.
	 * 
	 * @param defaultValue der zu verwendende defaultwert der Map.
	 * @return true, falls sich der default wert der map ge�ndert hat.
	 */
	public boolean setDefaultValue(V defaultValue) {
		if (this.defaultValue != defaultValue) {
			this.defaultValue = defaultValue;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Bestimmt den aktuellen Defaultwert der Map.
	 * 
	 * @return der defaultwert der map oder null, falls keiner gesetzt wurde.
	 */
	public V getDefaultValue() {
		return defaultValue;
	}

	@Override
	public void clear() {
		this.decoratedMap.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		if (defaultValue != null) {
			return true;
		} else {
			return this.decoratedMap.containsKey(key);
		}
	}

	@Override
	public boolean containsValue(Object value) {
		return this.decoratedMap.containsValue(value);
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return this.decoratedMap.entrySet();
	}

	@Override
	public V get(Object key) {
		if (!this.decoratedMap.containsKey(key) && this.defaultValue != null) {
			V result = this.defaultValue;

			assert(LogUtil.log(LogEvent.MESSAGE, "Using default value '" + result + "' for key '" + key + "'"));
			return result;
		} else {
			return this.decoratedMap.get(key);
		}
	}

	@Override
	public boolean isEmpty() {
		return this.defaultValue == null && this.decoratedMap.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return this.decoratedMap.keySet();
	}

	@Override
	public V put(K key, V value) {
		return this.decoratedMap.put(key, value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		this.decoratedMap.putAll(map);
		if (map instanceof MapWithDefault) {
			V default_value = ((MapWithDefault<? extends K, ? extends V>) map).getDefaultValue();
			if (default_value != null) {
				this.defaultValue = default_value;
			}
		}
	}

	@Override
	public V remove(Object key) {
		return this.decoratedMap.remove(key);
	}

	@Override
	public int size() {
		return this.decoratedMap.size();
	}

	@Override
	public Collection<V> values() {
		return this.decoratedMap.values();
	}

	@Override
	public boolean equals(Object obj) {
		return this.decoratedMap.equals(obj);
	}

	@Override
	public int hashCode() {
		return this.decoratedMap.hashCode();
	}

	@Override
	public String toString() {
		return this.decoratedMap.toString() + ", Defaultvalue:" + ((this.defaultValue != null) ? this.defaultValue.toString() : "-none-");
	}

}
