package org.sidiff.common.logging;

/**
 * Types of log messages.
 */
public enum LogEvent {
		
	// MESSAGE,ERROR,WARNING,NOTICE,EVENT,SIGNAL,DEBUG
	/**
	 * Aktive Mitteilungen an den Nutzer. Der Nutzer sollte diese Nachricht wahrnehmen.
	 */
	MESSAGE("MESSAGE"), 
	/**
	 * Fehlermeldung. z.B. 'Konfigurationsdatei nicht gefunden.'
	 */
	ERROR  ("ERROR  "),
	/**
	 * Potentielle Fehlersituation 'summe gewichte !=1, Zugriff auf attribut fehlgeschlagen, etc.'
	 */
	WARNING("WARNING"), 
	/**
	 * Informationen zum Programmablauf. z.B. 'Lade Modell X', Berechne x,y,z, etc.
	 */
	NOTICE ("NOTICE "), 
	/**
	 * Java-Events.
	 */
	EVENT  ("EVENT  "), 
	/**
	 * Native Calls. z.B. Methodenaufrufe, etc.
	 */
	SIGNAL ("SIGNAL "), 
	/**
	 * Debug Output. Diese Ausgaben sollten in Asserts gekapselt werden.
	 */
	DEBUG  ("DEBUG  "), 
	
	/**
	 * Configuration output.
	 */
	CONFIG	("CONFIG  "),
	
	/**
	 * Information output.
	 */
	INFO	("INFO  ");
	
	private String eventstring = null;

	private LogEvent(String eventstring) {
		this.eventstring = eventstring;
	}

	public String toString() {
		return eventstring;
	}
}
