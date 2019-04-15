package org.sidiff.common.logging.internal;

import java.text.SimpleDateFormat;
import java.util.*;

import org.sidiff.common.logging.ILogChannel;
import org.sidiff.common.logging.LogEvent;

/**
 * LogChannel that forwards log messages to multiple other log channels at a time.
 */
public class TeePipeChannel implements ILogChannel {
	
	private static final String PROPERTY_NAME_LOGCHANNELS = "TEEPIPECHANNELS";
	private static final String CHANNEL_PREFIX = "org.sidiff.common.logging.internal.";
	private static final String CHANNEL_SEPARATOR = ";";
	private static final String EVENT_DECLARATOR = ":";
	private static final String EVENT_SEPARATOR = ",";
	
	private HashMap<ILogChannel, Set<LogEvent>> channelEvents = null;
		
	boolean doIndentationFlag = false;
	boolean includeLogEventFlag = false;
	boolean includeTimeStampFlag = false;
	
	
	public TeePipeChannel() {
		
		this.channelEvents = new HashMap<ILogChannel, Set<LogEvent>>();
		
		String logChannelsString = System.getProperty(PROPERTY_NAME_LOGCHANNELS);
		
		if	(logChannelsString == null || logChannelsString == ""){ 			
			System.err.println("invalid TEEPIPECHANNELS Property");
			System.exit(-1);
		}
			
		String[] logChannelTokens = logChannelsString.split(CHANNEL_SEPARATOR);
		for (String channelToken : logChannelTokens) {
			
			String nameEvents[] = channelToken.split(EVENT_DECLARATOR);	
			
			ILogChannel outputChannel = 	getOutputChannel(nameEvents[0]);
			
			Set<LogEvent> events = new TreeSet<LogEvent>();
			if(nameEvents.length>2){
				System.err.println("invalid TEEPIPECHANNELS argument "+channelToken);
			}else if(nameEvents.length>1) {	
				String[] eventNames = nameEvents[1].split(EVENT_SEPARATOR);
				for(String eventName : eventNames){
					try{
						events.add(LogEvent.valueOf(eventName));
					} catch (Exception e) {
						System.err.println("invalid LogEvent : \"" + eventName + "\"");
					}
				}
			} else {
				for(LogEvent event : LogEvent.values()){
					events.add(event);
				}
			}
			
			channelEvents.put(outputChannel, events);
			
		}
		
		setFormatting();
		
	}
	
	@SuppressWarnings("unchecked")
	private ILogChannel getOutputChannel(String channelName) {
		
		if (channelName.indexOf(".")==-1)
			channelName = CHANNEL_PREFIX + channelName;
		
		try {
			
			Class channelClass = Class.forName(channelName);
			return (ILogChannel)channelClass.getConstructor().newInstance();
			
		} catch (Exception e) {
			
			System.out.println("Cannot get output Channel:" + channelName);
			System.exit(1);
		}
		return null;
	}
	
	
	
	private void setFormatting() {

		doIndentationFlag = false;
		for (ILogChannel channel : channelEvents.keySet()) {

			if (channel.doIndentation()) {
				doIndentationFlag = true;
				break;
			}
		}

		includeLogEventFlag = false;
		for (ILogChannel channel : channelEvents.keySet()) {

			if (channel.includeLogEvent()) {
				includeLogEventFlag = true;
				break;
			}
		}

		includeTimeStampFlag = false;
		for (ILogChannel channel : channelEvents.keySet()) {

			if (channel.includeTimeStamp()) {
				includeTimeStampFlag = true;
				break;
			}
		}
	}

	@Override
	public SimpleDateFormat createDateFormat() {
		
		return new SimpleDateFormat("EE dd.MM.yy hh:mm:ss ");
	}

	@Override
	public boolean doIndentation() {

		return doIndentationFlag;
	}

	@Override
	public boolean includeLogEvent() {

		return includeLogEventFlag;
	}

	@Override
	public boolean includeTimeStamp() {
		
		return includeTimeStampFlag;
	}

	@Override
	public void log(String message, LogEvent event) {
		
		for (ILogChannel channel : channelEvents.keySet()) {
			Set<LogEvent> events = channelEvents.get(channel);
			if (events.contains(event)) 
				channel.log(message, event);		
		}
	}
	
	@Override
	public String getKey() {
		return getClass().getSimpleName();
	}
}