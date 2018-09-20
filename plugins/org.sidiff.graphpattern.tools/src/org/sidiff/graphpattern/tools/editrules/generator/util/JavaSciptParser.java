package org.sidiff.graphpattern.tools.editrules.generator.util;

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

public class JavaSciptParser {

	private transient static Reference<ScriptEngine> engine;

	protected static ScriptEngine getEngine() {
		synchronized (JavaSciptParser.class) {
			if ((engine == null) || (engine.get() == null)) {
				ScriptEngine weakSingleton = createJavaScriptEngine();
				engine = new WeakReference<ScriptEngine>(weakSingleton);
			}
			return engine.get();
		}
	}
	
	protected static ScriptEngine createJavaScriptEngine() {
		return new ScriptEngineManager().getEngineByName("nashorn");
	}
	
	public static List<String> getVariables(String value) {

		// no content:
		if (value.isEmpty()) {
			return Collections.emptyList();
		}
		
		// one variable:
		if (value.matches("[0-9a-zA-Z]*")) {
			return Collections.singletonList(value);
		}
		
		// one string:
		if (value.startsWith("\"") && value.endsWith("\"") && !value.substring(1, value.length() - 1).contains("\"")) {
			return Collections.emptyList();
		}
		
		try {
			value = value.replace("\"", "'");
			
			String script = 
					"load(\"nashorn:parser.js\");\r\n" + 
							"var ast = parse(\"" + value + "\");" + 
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
		
		return Collections.emptyList();
	}
}
