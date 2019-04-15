package org.sidiff.common.emf.ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

public class ECoreTraversal {
	
	public static final String PATH_SEPERATOR = ".";

	public static void traverse(EClassVisitor visitor, EPackage... modelRoots){
		//in case of multiple modelRoots use each packages name for fullyQualifiedPath,
		//because there is a synthetic modelRoot
		if(modelRoots.length == 1){
			recursiveTraverse(visitor, modelRoots[0], new StringBuffer());
		} else for(EPackage ePackage : modelRoots){
			recursiveTraverse(visitor, ePackage, new StringBuffer(ePackage.getName()));
		}
		visitor.finish();
	}
	
	private static void recursiveTraverse(EClassVisitor visitor, EPackage ePackage, StringBuffer pathSegment){
		if(pathSegment.length() > 0){
			pathSegment.append(PATH_SEPERATOR);
		}
		
		for(EClassifier eClassifier : ePackage.getEClassifiers()){
			if(eClassifier instanceof EClass){
				StringBuffer pathClassSegment = new StringBuffer(pathSegment);
				pathClassSegment.append(eClassifier.getName());

				visitor.eClassifier((EClass) eClassifier, pathClassSegment.toString());
			}
		}

		for(EPackage subPackage : ePackage.getESubpackages()){
			StringBuffer pathPackageSegment = new StringBuffer(pathSegment);
			pathPackageSegment.append(subPackage.getName());
			
			recursiveTraverse(visitor, subPackage, pathPackageSegment);
		}
	}
}
