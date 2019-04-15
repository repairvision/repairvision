package org.sidiff.common.emf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * 
 * @author cpietsch
 * 
 */
public class ContainmentCycleChecker {

	private Collection<EClass> vertices = new ArrayList<EClass>();
	private Collection<EClass> finished = new ArrayList<EClass>();
	private List<EClass> visited = new ArrayList<EClass>();
	private List<EClass> path = new ArrayList<EClass>();
	private List<EClass> cycle = new ArrayList<EClass>();
	private List<EReference> refCycle = new ArrayList<EReference>();

	public ContainmentCycleChecker(Resource model) {

		for (Iterator<EObject> iterator = model.getAllContents(); iterator
				.hasNext();) {
			EObject eObject = (EObject) iterator.next();
			if (eObject instanceof EClass) {
				vertices.add((EClass) eObject);
			}
		}
	}

	public List<EReference> check() {
		
		finished.clear();
		visited.clear();
		path.clear();
		cycle.clear();
		refCycle.clear();
		
		for (EClass eClass : vertices) {
			if (checkNode(eClass))
				break;
		}

		for (int i = 0; i < path.size(); i++) {
			if (!cycle.contains(path.get(i)))
				cycle.add(path.get(i));
		}
		if(path.size()>0)cycle.add(path.get(0));
		Collections.reverse(cycle);
		Collections.reverse(refCycle);
		ArrayList<EReference> tmp = new ArrayList<EReference>();
		for(EReference ref: refCycle){
			if(!cycle.contains(ref.eContainer())){
				tmp.add(ref);
			}
		}
		refCycle.removeAll(tmp);
		return refCycle;
	}

	private boolean checkNode(EClass node) {
		
		if (finished.contains(node))
			return false;
		if (visited.contains(node))
			return true;
		
		visited.add(node);
		
		for(EReference containment : node.getEAllContainments()){
			if(checkNode(containment.getEReferenceType())){
				path.add(containment.getEReferenceType());
				refCycle.add(containment);
				return true;
			}	
		}
		for(EClass eClass: vertices){
			if(eClass.getEAllSuperTypes().contains(node)){
				if(checkNode(eClass)){
					path.add(eClass);
					return true;
				}
			}
		}
		finished.add(node);
		return false;
	}

	public String printCycle() {
		String result = "";
		for (int i = 0; i < cycle.size(); i++) {
			result += cycle.get(i).getName();
			if(i<cycle.size()-1)
				result += " -> ";
		}
		return result;
	}

	
	public static void main(String[] args) {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("ecore", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Get the resource

//########################## !!!!!!!!!!!!!!!!!!!!! ####################################		
		
//		Resource resource = resSet.getResource(
//				URI.createURI("../SA.ecore"), true);
		Resource resource = resSet.getResource(
				URI.createURI("../SimpleUMLMM.ecore"), true);

		
//########################## !!!!!!!!!!!!!!!!!!!!! ####################################				
		ContainmentCycleChecker cc = new ContainmentCycleChecker(resource);

			//System.out.println(cc.printCycle());
			System.out.println(cc.check());
			System.out.println(cc.printCycle());
		
	}
}
