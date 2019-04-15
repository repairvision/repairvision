package org.sidiff.common.collections;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * <p>A queue with unique entries. Elements offered to this queue
 * are only accepted if they are not already enqueued.</p>
 * <p>This queue allows offering elements while iterating over
 * it using a for-each loop, as new elements are only added
 * at the end of the queue. Note that iterating over the queue
 * also dequeues the elements, however the queue will remember
 * all previously enqueued elements and not accept them again.</p>
 * @author Robert Müller
 * @param <T> the type of the elements
 */
public class UniqueQueue<T> extends AbstractQueue<T> {

	private Set<T> set;
	private Queue<T> queue;

	/**
	 * Creates a new, empty queue using a {@link LinkedHashSet}
	 * and a {@link LinkedList}.
	 */
	public UniqueQueue() {
		this(new LinkedHashSet<>(), new LinkedList<>());
	}

	/**
	 * Creates a new unique queue using a {@link LinkedHashSet}
	 * and a {@link LinkedList}.
	 * @param initialQueue the initial elements of the queue
	 */
	public UniqueQueue(Collection<? extends T> initialQueue) {
		this();
		offerAll(initialQueue);
	}

	/**
	 * Creates a new unique queue.
	 * @param set the underlying set implementation
	 * @param queue the underlying queue implementation
	 * (may already contain the initial elements)
	 */
	public UniqueQueue(Set<T> set, Queue<T> queue) {
		this.set = Objects.requireNonNull(set, "set is null");
		this.queue = Objects.requireNonNull(queue, "queue is null");
	}

	/**
	 * Offers the element to this queue, rejecting elements
	 * that have already been enqueued.
	 */
	@Override
	public boolean offer(T e) {
		if(set.add(e)) {
			return queue.offer(e);
		}
		return false;
	}

	/**
	 * {@link #offer(Object) Offers} all elements to this queue
	 * and returns <code>true</code> iff all elements were accepted.
	 * @param elements collection of elements
	 * @return <code>true</code> if all elements were accepted, <code>false</code> if not
	 */
	public boolean offerAll(Collection<? extends T> elements) {
		return elements.stream()
			.map(this::offer)
			.reduce(Boolean::logicalAnd).orElse(true);
	}

	@Override
	public T poll() {
		return queue.poll();
	}

	@Override
	public T peek() {
		return queue.peek();
	}

	/**
	 * Returns an iterator to iterate over all enqueued elements in order.
	 * The iterator dequeues the elements from the queue, and allows offering
	 * elements to the queue while iterating.
	 */
	@Override
	public Iterator<T> iterator() {
		return new UniqueQueueIterator();
	}

	@Override
	public int size() {
		return queue.size();
	}

	private class UniqueQueueIterator implements Iterator<T> {

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		@Override
		public T next() {
			return queue.poll();
		}
	}
}
