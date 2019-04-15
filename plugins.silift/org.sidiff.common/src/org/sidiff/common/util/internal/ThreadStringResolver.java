package org.sidiff.common.util.internal;

import org.sidiff.common.util.StringResolver;


/**
 * StringResolver to compute the string representation of a thread.
 */
public class ThreadStringResolver implements StringResolver {

	@Override
	public Class<?> dedicatedClass() {
		return Thread.class;
	}

	@Override
	public String resolve(Object obj) {
		if (obj instanceof Thread) {
			Thread thread = (Thread)obj;
			StringBuffer sb = new StringBuffer();
			sb.append("Thread "+thread.getName()+"("+thread.getId()+")\n");
			for (StackTraceElement ste : thread.getStackTrace())
				sb.append(resolve(ste));
			return sb.toString();
		} else if (obj instanceof StackTraceElement) {
			StackTraceElement ste = (StackTraceElement)obj;
			return ste.getClassName()+"."+ste.getMethodName()+"("+ste.getFileName()+":"+ste.getLineNumber()+")\n";
		}
		return null;
	}
}