package org.sidiff.consistency.repair.validation.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.uml2.uml.UMLPackage;
import org.sidiff.consistency.repair.validation.ConsistencyRule;
import org.sidiff.consistency.repair.validation.formulas.And;
import org.sidiff.consistency.repair.validation.formulas.Formula;
import org.sidiff.consistency.repair.validation.formulas.predicates.Equality;
import org.sidiff.consistency.repair.validation.formulas.quantifiers.Exists;
import org.sidiff.consistency.repair.validation.formulas.quantifiers.ForAll;
import org.sidiff.consistency.repair.validation.terms.Term;
import org.sidiff.consistency.repair.validation.terms.Variable;
import org.sidiff.consistency.repair.validation.terms.functions.Get;

public class TestApplication implements IApplication {

	private UMLPackage UML = UMLPackage.eINSTANCE;
	
	@SuppressWarnings("unused")
	@Override
	public Object start(IApplicationContext applicationContext) throws Exception {
		
		// Load Model
		String consistent = "D:/Workspace/SiLift/org.sidiff.consistency.repair.validation/src/org/sidiff/consistency/repair/validation/test/M0005A.uml";
		String inconsistent = "D:/Workspace/SiLift/org.sidiff.consistency.repair.validation/src/org/sidiff/consistency/repair/validation/test/M0005B.uml";
		
		ResourceSet rss = new ResourceSetImpl();
		URI modeURI = URI.createFileURI(consistent);
		Resource modelResource = rss.getResource(modeURI, true);;
		
		// Create consistency rule:
		Variable m = new Variable("m");
		Variable l1 = new Variable("l1");
		Variable l2 = new Variable("l2");
		Variable l = new Variable("l");
		Variable a = new Variable("a");
		Variable o = new Variable("o");
		
		Term c1_m_receiveEvent_covered = new Get(new Get(m, 
				UML.getMessage_ReceiveEvent()), 
				UML.getInteractionFragment_Covered());
		
		Term c2_m_receiveEvent_covered = new Get(new Get(m, 
				UML.getMessage_ReceiveEvent()), 
				UML.getInteractionFragment_Covered());
		
		Term m_sendEvent_covered = new Get(new Get(m, 
				UML.getMessage_SendEvent()), 
				UML.getInteractionFragment_Covered());
		
		Term l2_represents_type_ownedAttribute = new Get(new Get(new Get(l2, 
				UML.getLifeline_Represents()),
				UML.getTypedElement_Type()), 
				UML.getStructuredClassifier_OwnedAttribute()); 
		
		Term l1_represents_type = new Get(new Get(l1,
				UML.getLifeline_Represents()),
				UML.getTypedElement_Type());
		
		Term a_type = new Get(a, 
				UML.getTypedElement_Type());
		
		Term l_represents_type_ownedOperation = new Get(new Get(new Get(l,
				UML.getLifeline_Represents()),
				UML.getTypedElement_Type()), 
				UML.getClass_OwnedOperation());
		
		Term m_name = new Get(m, 
				UML.getNamedElement_Name());
		
		Term o_name = new Get(o, 
				UML.getNamedElement_Name());

		Formula checkAssoziation = 
				new Exists(l1, c1_m_receiveEvent_covered, 
				new Exists(l2, m_sendEvent_covered,
				new Exists(a, l2_represents_type_ownedAttribute, 
				new Equality(a_type, l1_represents_type))));
		
		Formula checkNames = 
				new ForAll(l, c2_m_receiveEvent_covered, 
				new Exists(o, l_represents_type_ownedOperation, 
				new Equality(o_name, m_name)));
		
		Formula validation = new And(checkAssoziation, checkNames);
		
		ConsistencyRule messageBasedOnOperation = new ConsistencyRule(
				UML.getMessage(), m, validation);
		
		// Check consistency:
		modelResource.getAllContents().forEachRemaining(modelElement -> {
			if (modelElement.eClass() == messageBasedOnOperation.getContextType()) {
				System.out.print("Validation [");
				System.out.print(messageBasedOnOperation.evaluate(modelElement));
				System.out.println("]: " + modelElement);
			}
		});
		
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
	}
}
