package org.sidiff.integration.eclipse.logging;

import java.text.SimpleDateFormat;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.sidiff.common.logging.ILogChannel;
import org.sidiff.common.logging.LogEvent;

public class EclipseConsoleLogChannel implements ILogChannel {

	private  MessageConsole console;
	
	private MessageConsoleStream mcStream;
	
	public EclipseConsoleLogChannel() {
		console = findConsole("SiDiff Console");
		mcStream = console.newMessageStream();
	}

	@Override
	public void log(String message, LogEvent event) {
		mcStream.println(message);
	}

	@Override
	public SimpleDateFormat createDateFormat() {
		return new SimpleDateFormat("EE dd.MM.yy hh:mm:ss ");
	}

	@Override
	public boolean includeTimeStamp() {
		return true;
	}

	@Override
	public boolean includeLogEvent() {
		return true;
	}

	@Override
	public boolean doIndentation() {
		return true;
	}

	private static MessageConsole findConsole(String name){
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager consoleManager = plugin.getConsoleManager();
		IConsole[] existingConsoles = consoleManager.getConsoles();
		for (int i = 0; i < existingConsoles.length; i++)
			if (name.equals(existingConsoles[i].getName()))
				return (MessageConsole) existingConsoles[i];
		// no console found, so create a new one
		MessageConsole console = new MessageConsole(name, null);
		consoleManager.addConsoles(new IConsole[] { console });
		return console;
	}
	
	@Override
	public String getKey() {
		return getClass().getSimpleName();
	}
}
