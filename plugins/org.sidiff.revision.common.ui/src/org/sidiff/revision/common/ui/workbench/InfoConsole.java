package org.sidiff.revision.common.ui.workbench;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class InfoConsole {
	
	public static final String CONSOLE_NAME = "Pattern Matching Engine";

	public static void printInfo(Object element) {
		printInfo(element, "");
	}
	
	public static void printInfo(Object element, String emptyMessage) {
		if (element == null) {
			printInfos(Collections.emptyList(), emptyMessage);
		} else {
			printInfos(Collections.singleton(element), emptyMessage);
		}
	}
	
	public static void printInfos(Collection<? extends Object> elements) {
		printInfos(elements, "");
	}
	
	public static void printInfos(Collection<? extends Object> elements, String emptyMessage) {
		try {
			Display.getDefault().syncExec(() -> internal_printInfos(elements, emptyMessage));
		} catch(Exception e) {
			elements.forEach(System.out::println);
		}
	}

	private static void internal_printInfos(Collection<? extends Object> elements, String emptyMessage) {

		// Setup console:
		WorkbenchUtil.showView("org.eclipse.ui.console.ConsoleView");

		// Console instance:
		MessageConsole myConsole = findConsole(CONSOLE_NAME);

		// Output streams:
		MessageConsoleStream outNormal = myConsole.newMessageStream();

		MessageConsoleStream outBold = myConsole.newMessageStream();
		Color colorBlue = new Color(PlatformUI.getWorkbench().getDisplay(), 0, 0, 128);
		outBold.setColor(colorBlue);
		outBold.setFontStyle(SWT.BOLD);
		
		MessageConsoleStream outInfo = myConsole.newMessageStream();
		Color colorRed = new Color(PlatformUI.getWorkbench().getDisplay(), 128, 0, 0);
		outInfo.setColor(colorRed);
		outInfo.setFontStyle(SWT.BOLD);
		
		// Info message:
		if (elements.isEmpty()) {
			outInfo.println(emptyMessage);
		} else {
			for (Object element : elements) {
				if (element != null) {
					// Message:
					String unqualified = element.toString().replaceAll("(\\w*\\.)*(\\w*@)", "$2");
					
					// Separate each line:
					String[] lines = unqualified.split("\n");
					
					for (int l = 0; l < lines.length; l++) {
						boolean endsWithColon = lines[l].endsWith(":");
						
						// Split on ':' and print the keyword 
						// (containing: letters, numbers, -, _, trailing white space) before the ':' in bold:
						String[] segments = lines[l].split(":");
						
						for (int i = 0; i < segments.length; i++) {
							
							// Case differentiation for last segment:
							if ((i < (segments.length - 1)) || endsWithColon) {
								
								// Cut keyword from the end of the segment:
								String normalText = segments[i].replaceFirst("[a-zA-Z_0-9_\\-_\\_]+\\s*$", "");
								String boldText = segments[i].substring(normalText.length(), segments[i].length());

								outNormal.print(normalText);
								
								if (boldText.isEmpty()) {
									outNormal.print(":");
								} else {
									outBold.print(boldText + ":");
								}
							} else {
								outNormal.print(segments[i]);
							}
						}
						
						// New line:
						if (l < (lines.length - 1)) {
							outNormal.print("\n");
						}
					}
				} else {
					outInfo.print("null");
				}
				outInfo.print("\n");
			}
		}
	}
	
	public static String getHorizontalLine() {
		return "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" 
				+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
				+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
				+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
				+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
				+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" 
				+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
				+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
				+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
				+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
				+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550"
				+ "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550";
	}

	private static MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();

		for (int i = 0; i < existing.length; i++) {
			if (name.equals(existing[i].getName())) {
				return (MessageConsole) existing[i];
			}
		}

		// No console found, so create a new one:
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}
}
