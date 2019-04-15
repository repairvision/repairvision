package org.sidiff.matcher.events;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.event.IEvent;

/**
 * Event class for throwing events if elements are matched or if matches are
 * revoked.
 *
 */
public class MatchEvent extends IEvent {

	private static final long serialVersionUID = 1L;

	public final static int MATCH_CREATED_EVENT = createNewEvent();
	public final static int MATCH_REVOKED_EVENT = createNewEvent();

	public final static int MATCHED_ELEMENT_A_FEATURE = 0;
	public final static int MATCHED_ELEMENT_B_FEATURE = 1;
	public final static int MATCHER_FEATURE = 2;

	public MatchEvent(Object source, int eventID, Object... objects) {
		super(source, eventID,objects);

		if (eventID == MATCH_CREATED_EVENT || eventID == MATCH_REVOKED_EVENT) {
			assert (LogUtil.log(LogEvent.EVENT, "Matching performed " + objects[0] + "<-->" + objects[1]));
			assert (objects.length >= 2 && objects[0] != null && objects[1] != null) : "Illegal Matching Event! (null)";
			assert (objects[0] instanceof EObject && objects[1] instanceof EObject) : "Illegal matched Objects!";
		}
	}
}
