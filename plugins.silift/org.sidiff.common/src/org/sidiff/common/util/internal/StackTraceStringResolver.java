package org.sidiff.common.util.internal;

import org.sidiff.common.util.StringResolver;

/**
 * StringResolver to compute the string representation of a stack trace. (i.e. StackTraceElement[])
 */
public class StackTraceStringResolver implements StringResolver {

	@Override
	public Class<?> dedicatedClass() {
		return StackTraceElement[].class;
	}

	@Override
	public String resolve(Object obj) {
		StackTraceElement st[] = (StackTraceElement[])obj;
		StringBuffer result = new StringBuffer();
		for(StackTraceElement ste : st){
			result.append(ste.getClassName()+"."+ste.getMethodName()+"("+ste.getFileName()+":"+ste.getLineNumber()+")\n");
		}
		return result.toString();
	}

}
