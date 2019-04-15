package org.sidiff.common.henshin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;

/**
 * Some common Henshin Utils, mostly used for DEBUGGING purposes.
 * 
 * @author kehrer, dreuling
 */
public class HenshinUtil {

	/**
	 * Only for DEBUGGING purposes. Prints the contents of a Henshin graph.
	 * 
	 * @param graph
	 */
	public static void printGraph(EGraph graph) {
		System.out.println("----------------- EGraph -----------");
		System.out.println("[size: " + graph.size()+  "]");
		for (EObject eObject : graph) {
			System.out.println(eObject);
		}
		System.out.println("----------------- END EGraph -----------");
	}

	/**
	 * Only for DEBUGGING purposes. Serializes a temporary Henshin rule to the
	 * system's tmp path.
	 * 
	 * @param rule
	 * @param path
	 */
	public static void serializeTempRule(Rule rule) {
		String path = System.getProperty("java.io.tmpdir");
		Module newModule = HenshinFactory.eINSTANCE.createModule();
		// TransformationSystem newTS =
		// HenshinFactory.eINSTANCE.createTransformationSystem();
		newModule.getUnits().add(rule);

		URI uri = URI.createFileURI(new File(path).getAbsolutePath() + "/temp.henshin");
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add((EObject) newModule);

		Map<String, Boolean> options = new HashMap<String, Boolean>();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * For DEBUGGING: Serializes a Henshin module to the given path.
	 * 
	 * @param module
	 * @param path
	 * 
	 * */
	public static void serializeTransformationSystem(Module module, String path) {

		String name = module.getName() + ".henshin";

		URI uri = URI.createFileURI(new File(path).getAbsolutePath() + "/" + name);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add((EObject) module);

		Map<String, Boolean> options = new HashMap<String, Boolean>();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}