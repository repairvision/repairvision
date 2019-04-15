package org.sidiff.event;

import java.util.HashSet;
import java.util.Set;

/**
 * Manages the listeners for a certain type of events. Each event comes with its
 * own event dispatcher in order to avoid the bottleneck of a single event bus.
 * 
 * @author wenzel
 *
 */
public class EventUtil {

	private static Class<?> eventClass = null;
	private static Set<IEventListener> listeners = null;

//	public EventServiceUtil(Class<? extends IEvent> eventClass) {
//		eventClass = eventClass;
//	}

	public static boolean addEventListener(IEventListener listener) {
		//TODO realize it with the service stuff..search for the services that implements IEventListener
		assert (listener != null);

		if (listeners == null) {
			listeners = new HashSet<IEventListener>();
		}

		return listeners.add(listener);
	}

	public boolean removeEventListener(IEventListener listener) {

		if (listeners != null) {
			boolean removed = listeners.remove(listener);
			if (removed && listeners.size() == 0) {
				// Disable Propagation
				listeners = null;
			}
			return removed;
		} else {
			return false;
		}

	}

	public static boolean fireEvent(IEvent event) {

		assert (event != null) : "Dispatched event cannot be null!";
		assert (eventClass == null || event.getClass() == eventClass) : "Dispatcher was not designed to perform given event!";

		if (listeners != null) {
			for (IEventListener listener : listeners) {
				listener.eventDispatched(event);
			}
			return true;
		}

		return false;
	}

	public boolean isEmpty() {
		return listeners == null;
	}

}
