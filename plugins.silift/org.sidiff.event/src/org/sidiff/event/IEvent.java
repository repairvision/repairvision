package org.sidiff.event;

import java.util.EventObject;

import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;

/**
 * Abstract super class for events which can be fired for communication between
 * services of a {@link ServiceContext}
 * 
 * @author wenzel
 *
 */
public abstract class IEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private static int EVENT_ID =0;
	
	private int eventID =-1;
	private Object[] objects = null;
	
	public IEvent(Object source, int eventID, Object...objects) {
		super(source);
		this.eventID=eventID;
		this.objects=objects;

		assert(source!=null);
		assert(this.eventID>0);
		
		assert(LogUtil.log(LogEvent.EVENT, getClass().getName(), eventID, objects));
		
	}
	
	public int getEventID(){
		return this.eventID;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getObject(int featureID,Class<T> type){
		
		return (T)this.objects[featureID];
	}

	protected static int createNewEvent() {
		return ++EVENT_ID;
	}
}
