package org.sidiff.common.util;

import java.util.regex.Pattern;

/**
 * Utility class for working with regular expressions.
 * @author Robert Müller
 * @see Patterns
 */
public class RegExUtil {

	/**
	 * Enum containing regular expression patterns.
	 * Use {@link #get()} to retrieve a {@link Pattern}.
	 */
	public enum Patterns {
		/**
		 * A pattern to split CamelCase word (a-z, A-Z):
		 * <ul>
		 * <li>CamelCase -> Camel, Case</li>
		 * <li>camelCase -> camel, Case</li>
		 * <li>CAMELCase -> CAMEL, Case</li>
		 * </ul>
		 */
		SPLIT_CAMEL_CASE("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");


		private final Pattern pattern;

		private Patterns(String regex) {
			this.pattern = Pattern.compile(regex);
		}

		public Pattern get() {
			return pattern;
		}
	}
}
