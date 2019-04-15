package org.sidiff.common.collections;

/**
 * Interface for classifiers according to the ClassificationUtil.
 * 
 * @author Maik Schmidt
 *
 * @param <K> Type of the classification criterions.
 * @param <V> Type of the elements to be classified.
 */
public interface Classifier<K, V> {

	public K classify(V item);
}
