package org.sidiff.reverseengineering.retrieval.util;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.equinox.app.IApplicationContext;

public class ApplicationUtil {
	
	public static String getStringFromProgramArguments(IApplicationContext context, String argumentName) {
		String[] args = (String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
		
		for (int i = 0; i < args.length - 1; i++) {
			if (args[i].equalsIgnoreCase(argumentName)) {
				return args[i + 1];
			}
		}
		
		return null;
	}
	
	public static Path getPathFromProgramArguments(IApplicationContext context, String argumentName) throws FileNotFoundException {
		return getPathFromProgramArguments(context, argumentName, true);
	}
	
	public static Path getPathFromProgramArguments(IApplicationContext context, String argumentName, boolean exists) throws FileNotFoundException {
		String[] args = (String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
		
		for (int i = 0; i < args.length - 1; i++) {
			if (args[i].equalsIgnoreCase(argumentName)) {
				Path dataSetPath = Paths.get(args[i + 1]);
				
				if (exists && !Files.exists(dataSetPath)) {
					throw new FileNotFoundException(args[i + 1]);
				}
				
				return dataSetPath;
			}
		}
		
		throw new FileNotFoundException("Program argument '" + argumentName + "' not specified.");
	}
	
	public static boolean containsProgramArgument(IApplicationContext context, String argumentName) throws FileNotFoundException {
		String[] args = (String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
		
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase(argumentName)) {
				return true;
			}
		}
		
		return false;
	}
}
