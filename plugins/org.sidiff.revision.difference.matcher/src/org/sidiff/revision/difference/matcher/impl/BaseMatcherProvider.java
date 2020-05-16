package org.sidiff.revision.difference.matcher.impl;

import org.sidiff.common.utilities.ui.util.NameUtil;
import org.sidiff.revision.difference.matcher.IMatcherProvider;

/**
 * This is the simple matcher provider base implementation.
 */
public abstract class BaseMatcherProvider implements IMatcherProvider {

	@Override
	public String getKey(){
		return getClass().getSimpleName();
	}
	
	@Override
	public String getName() {
		return NameUtil.beautifyName(getKey());
	}

}
