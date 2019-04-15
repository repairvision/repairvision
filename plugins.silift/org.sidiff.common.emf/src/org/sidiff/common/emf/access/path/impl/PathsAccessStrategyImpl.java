package org.sidiff.common.emf.access.path.impl;

import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.path.*;
import org.sidiff.common.emf.access.path.impl.EMFPathAccessorImpl.StrategyImpl;

/**
 * Implements PathsAccessStrategyImpl.
 * 
 * @see PathsAccessStrategy
 * 
 * @author Sven Wenzel
 */
class PathsAccessStrategyImpl implements PathsAccessStrategy, StrategyImpl<Collection<List<EObject>>> {

	@Override
	public Collection<List<EObject>> evaluate(EObject start, EMFPath emfPath) {
		assert (emfPath instanceof EMFPathImpl) : "Illegal argument! Invalid Path implemention";

		Collection<List<EObject>> resultPaths = new LinkedList<List<EObject>>();
		EMFPathImpl pathImpl = (EMFPathImpl) emfPath;
		Iterator<EMFPathStepImpl> iterator = pathImpl.iterator();
		if (iterator.hasNext()) {
		
			// Ersten Schritt berechnen
			List<List<EObject>> stepResultPaths = new LinkedList<List<EObject>>();
			Collection<EObject> stepResultNodes = null;
			
			EMFPathStepImpl step = iterator.next();
			stepResultNodes = step.evaluateStep(Collections.singleton(start));
			for(EObject stepNode : stepResultNodes){
				stepResultPaths.add(new LinkedList<EObject>(Collections.singletonList(stepNode)));
			}
		
			int i = 0;
			// Alle folgenden Schritte berechnen
			while (iterator.hasNext()) {
				EMFPathStepImpl furtherStep = iterator.next();
				i++;

				Collection<List<EObject>> expiredPaths = null;
				// Pfade um aktuellen Schritt verlaengern
				for(int j=0;j<stepResultPaths.size();j++){
					List<EObject> path = stepResultPaths.get(j);
					
					if (path.size()!=i)
						continue; // this path is too long, hence, must have been added in this iteration of the while loop 
					
					LinkedList<EObject> linkedPath = (LinkedList<EObject>)path;
					stepResultNodes = furtherStep.evaluateStep(Collections.singleton(linkedPath.getLast()));
					if(stepResultNodes.isEmpty()){
						// Pfad ist abgelaufen -> Keine weitere verlaengerung
						if(expiredPaths==null){
							expiredPaths= new LinkedList<List<EObject>>();
						}
						expiredPaths.add(path);
					} else {
						// Pfad verlaengern
						Iterator<EObject> iter = stepResultNodes.iterator();
						EObject first = iter.next(); // First check for branches bevor add
						while(iter.hasNext()){
							// We have a branch, so copy original path
							List<EObject> branch = new LinkedList<EObject>(path);
							branch.add(iter.next());
							stepResultPaths.add(branch);
						}
						// Finaly add first Element to the original Path
						path.add(first);
					}
				}
				if(expiredPaths!=null){
					stepResultPaths.removeAll(expiredPaths);
					resultPaths.addAll(expiredPaths); // May be optional?!
				}
			}
			// Pfad abgelaufen... Alles was uebrig ist, ist auch ergebniss :-)
			resultPaths.addAll(stepResultPaths);
		}
		return resultPaths;

	}
	
	
}
