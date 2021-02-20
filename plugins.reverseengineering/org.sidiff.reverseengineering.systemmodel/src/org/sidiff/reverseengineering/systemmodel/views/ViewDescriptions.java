package org.sidiff.reverseengineering.systemmodel.views;

import org.sidiff.reverseengineering.systemmodel.SystemModelFactory;
import org.sidiff.reverseengineering.systemmodel.ViewDescription;

public class ViewDescriptions {

	public static ViewDescription JAVA_MODEL = SystemModelFactory.eINSTANCE.createViewDescription("Java AST", "Java EMF-based AST", "javamodel");
	
	public static ViewDescription UML_CLASS_DIAGRAM = SystemModelFactory.eINSTANCE.createViewDescription("UML Class Diagram", "UML class diagram showing the project structure.", "class.uml");
	
	public static ViewDescription UML_CLASS_OPERATION_CONTROL_FLOW = SystemModelFactory.eINSTANCE.createViewDescription("UML Activity Diagram", "UML activity diagram showing the operation control flow.", "cfg.activity.uml");

	public static ViewDescription[] ALL_VIEWS = {JAVA_MODEL, UML_CLASS_DIAGRAM, UML_CLASS_OPERATION_CONTROL_FLOW};
	
}
