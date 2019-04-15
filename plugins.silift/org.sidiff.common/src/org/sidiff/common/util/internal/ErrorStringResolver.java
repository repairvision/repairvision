package org.sidiff.common.util.internal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.sidiff.common.util.StringResolver;

/**
 * StringResolver to compute the string representation of an Error object.
 * @author wenzel
 *
 */
public class ErrorStringResolver implements StringResolver {

	@Override
	public Class<?> dedicatedClass() {
		return Error.class;
	}

	@Override
	public String resolve(Object obj) {
		
		if (!(obj instanceof Error))
			return null;
		
		Error error = (Error)obj;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		error.printStackTrace(new PrintStream(baos));
		return " Exception Message: " + error.getMessage() + "\nSee StackTrace for details:\n" + baos.toString();
	}
}