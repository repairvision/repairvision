package org.sidiff.reverseengineering.java.configuration.uml;

import org.sidiff.reverseengineering.java.configuration.TransformationModule;
import org.sidiff.reverseengineering.java.configuration.TransformationSettings;
import org.sidiff.reverseengineering.java.transformation.uml.rulebase.JavaToUMLHelper;
import org.sidiff.reverseengineering.java.transformation.uml.rulebase.JavaToUMLRules;

public class TransformationModuleUML extends TransformationModule {

	public TransformationModuleUML(TransformationSettings settings) {
		super(settings, new TransformationDomainUML());
	}
	
	@Override
	protected void configure() {
		super.configure();
		bindJavaToUMLRules();
		bindJavaToUMLHelper();
	}
	
	protected void bindJavaToUMLRules() {
		bind(JavaToUMLRules.class);
	}
	
	protected void bindJavaToUMLHelper() {
		bind(JavaToUMLHelper.class);
	}
	
}
