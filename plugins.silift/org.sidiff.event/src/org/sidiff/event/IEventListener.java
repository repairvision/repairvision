package org.sidiff.event;


import java.util.EventListener;

import org.sidiff.service.IService;

/**
 * A listener which gets informed whenever the particular event is fired.
 * @author wenzel
 *
 */
public interface IEventListener extends EventListener,IService {
	
	public void eventDispatched(IEvent event);
}
