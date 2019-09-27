package org.sidiff.graphpattern.attributes;

import java.io.StringWriter;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.eclipse.emf.ecore.EDataType;

/**
 * Parsing of constants and script expressions in attribute values.
 * 
 * @author Manuel Ohrndorf
 */
public class JavaSciptParser {
	
	// NOTE: Currently asserts that all constants are quoted, e.g., "true".
	//       All none quoted strings are interpreted as script expressions or single variables.

	/**
	 * The JavaScript engine to parse expressions.
	 */
	private static Reference<ScriptEngine> engine;
	
	/**
	 * Matches a string which starts and ends with quotation marks. The string must
	 * also not contain any not escaped quotation marks.
	 */
	private static Pattern MATCH_CONSTANT = Pattern.compile("^\"[^\"\\\\]*(?:\\\\.[^\"\\\\]*)*\"$");
	
	/**
	 * Matches a simple variable name.
	 */
	private static Pattern MATCH_VARIABLE = Pattern.compile("^([a-zA-Z\\d_$]*)$");

	/**
	 * @return An instance of the JavaScript engine to parse expressions.
	 */
	protected static ScriptEngine getEngine() {
		synchronized (JavaSciptParser.class) {
			if ((engine == null) || (engine.get() == null)) {
				ScriptEngine weakSingleton = createJavaScriptEngine();
				engine = new WeakReference<ScriptEngine>(weakSingleton);
			}
			return engine.get();
		}
	}
	
	/**
	 * @return Creates an instance of the JavaScript engine to parse expressions.
	 */
	protected static ScriptEngine createJavaScriptEngine() {
		return new ScriptEngineManager().getEngineByName("nashorn");
	}
	
	/**
	 * @param eDataType    The object type of the literal.
	 * @param literalValue The object as a literal string.
	 * @return An instance of the data type.
	 */
	protected static Object createFromString(EDataType eDataType, String literalValue) {
		return eDataType.getEPackage().getEFactoryInstance().createFromString(eDataType, literalValue);
	}

	/**
	 * @param type       The type of the expression result.
	 * @param expression An expression.
	 * @return If the expression contains a single constant value, the constant as
	 *         primitive data type or <code>null</code>.
	 */
	public static Object getConstant(EDataType type, String expression) {
		
		if (isConstant(expression)) {
			expression = expression.substring(1, expression.length() - 1);
			
			try {
				return createFromString(type, expression);
			} catch (Exception e) {
			}
		}
		
		return null;
	}
	
	/**
	 * @param type       The type of the expression result.
	 * @param expression An expression.
	 * @return <code>true</code> if the expression contains a single constant
	 *         (quoted) value; <code>false</code> otherwise.
	 */
	public static boolean isConstant(String expression) {

		if (expression != null) {
			if (expression.startsWith("\"") && expression.endsWith("\"")) { // optimization
				return MATCH_CONSTANT.matcher(expression).find();
			}
		}
		
		return false;
	}
	
	/**
	 * @param expression An expression.
	 * @return <code>true</code> if the expression is a single variable;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isVariable(String expression) {
		
		if (expression != null) {
			return MATCH_VARIABLE.matcher(expression).find();
		}
		
		return false;
	}
	
	/**
	 * @param type       The type of the expression result.
	 * @param expression An expression.
	 * @return <code>true</code> if the expression is not a constant value;
	 *         <code>false</code> otherwise.
	 * @see JavaSciptParser#isQuoted(String)
	 */
	public static boolean isExpression(String expression) {
		
		if (expression != null) {
			return !isConstant(expression);
		}
		
		return false;
	}
	
	/**
	 * @param type       The type of the expression result.
	 * @param expression An expression.
	 * @return The variables contained in the expression; an empty list otherwise.
	 */
	public static List<String> getVariables(EDataType type, String expression) {
		
		// no content:
		if (expression.isEmpty()) {
			return Collections.emptyList();
		}
		
		// one variable:
		if (isVariable(expression)) {
			return Collections.singletonList(expression);
		}
		
		// constant:
		if (isExpression(expression)) {

			// java script expression:
			try {
				expression = expression.replace("\"", "'");

				String script = 
						"load(\"nashorn:parser.js\");\r\n" + 
								"var ast = parse(\"" + expression + "\");" + 
								"print(JSON.stringify(ast));";

				ScriptEngine engine= getEngine();
				StringWriter output = new StringWriter();

				ScriptContext scriptContext = new SimpleScriptContext();
				scriptContext.setWriter(output);

				engine.eval(script, scriptContext);

				String ast = output.toString();
				String attributeASTPattern = "(.*?)(\\{\"type\":\"Identifier\",\"name\":\")(.*?)(\"\\})(.*?)";

				Pattern compiledAttributeASTPattern = Pattern.compile(attributeASTPattern);
				Matcher matcher = compiledAttributeASTPattern.matcher(ast);

				List<String> variables = new ArrayList<>();

				while(matcher.find()) {
					String variable = matcher.group(3);

					if (!variable.isEmpty()) {
						variables.add(variable);
					}
				}

				return variables;
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		}
		
		return Collections.emptyList();
	}
}
