package org.sidiff.graphpattern.tools.model2graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;

public class FolderToBundleTransformation {

	private Set<String> modelFileExtensions;
	
	private ModelToGraphPatternFactory factory;
	
	public FolderToBundleTransformation(
			Set<String> modelFileExtensions, 
			ModelToGraphPatternFactory definitionFactory) {
		
		this.modelFileExtensions = modelFileExtensions;
		this.factory = definitionFactory;
	}
	
	public FolderToBundleTransformation(Set<String> modelFileExtensions) {
		this.modelFileExtensions = modelFileExtensions;
		this.factory = new ModelToGraphPatternFactory();
	}
	
	// TODO: Method to determine <<constraint>> marker, e.g., folder name convention... or list of constraint names

	public Bundle toBundle(IFolder folder) {
		Bundle bundle = GraphpatternFactory.eINSTANCE.createBundle();
		bundle.setName(folder.getName() + "Bundle");
		
		// Process folder content:
		Pattern pattern = toPatternTree(folder);
		bundle.getPatterns().add(pattern);
		
		return bundle;
	}
	
	protected Pattern toPatternTree(IFolder folder) {
		Pattern pattern = GraphpatternFactory.eINSTANCE.createPattern();
		pattern.setName(folder.getName());
		
		// Process folder content:
        try {
			for (IResource member : folder.members()) {
			    if (member instanceof IFolder) {
			    	
			    	// Convert folder to pattern:
			    	IFolder childFolder = (IFolder) member;
			        Pattern subPattern = toPatternTree(childFolder);
			        pattern.getPatterns().add(subPattern);
			        
			    } else if (member instanceof IFile) {
			    	
			    	// Convert file to graph:
			    	if (matchFileExtension(member)) {
			    		Resource modelResource = factory.loadModel((IFile) member);
			    		ModelToGraphPatternDefiniton definition = factory.createDefinition(modelResource);
			    		ModelToGraphPatternTransformation transformator = factory.createTransformation(definition);
			    		
						Pattern modelPattern = transformator.toParameterizedGraph(modelResource);
						pattern.getPatterns().add(modelPattern);
			    	}
			    }
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return pattern;
	}
	
	public void updateBundle(Bundle bundle, IFolder bundleFolder, boolean overwrite) {
		
		// Synchronize folder with the bundle:
        updatePatternTree(bundle, bundleFolder, overwrite);
	}

	protected void updatePatternTree(Pattern pattern, IFolder patternFolder, boolean overwrite) {
		
		try {
			List<Parameter> parameters = new ArrayList<>();
			
			for (IResource member : patternFolder.members()) {
			    if (member instanceof IFolder) {
			    	
			    	// Get existing pattern:
			    	IFolder subFolder = (IFolder) member;
			    	Pattern subPattern = pattern.getPattern(subFolder.getName());
			    	
			    	// Or create new pattern:
			    	if (subPattern == null) {
			    		subPattern = GraphpatternFactory.eINSTANCE.createPattern();
			    		subPattern.setName(subFolder.getName());
			    		pattern.getPatterns().add(subPattern);
			    	}
			    	
			    	updatePatternTree(subPattern, subFolder, overwrite);
			        
			    } else if ((pattern != null) && (member instanceof IFile)) {
			    	
			    	// Convert file to graph:
			    	if (matchFileExtension(member)) {
			    		IFile patternExample = (IFile) member;
			    		Resource modelResource = factory.loadModel(patternExample);
			    		ModelToGraphPatternDefiniton definition = factory.createDefinition(modelResource);
			    		
			    		GraphPattern oldGraphPattern = pattern.getGraph(definition.getNameGraph(modelResource));
			    		
			    		if ((oldGraphPattern == null) || overwrite) {
				    		ModelToGraphPatternTransformation transformator = factory.createTransformation(definition);
			    			Pattern newPattern = transformator.toParameterizedGraph(modelResource);
			    			GraphPattern newGraphPattern = newPattern.getGraphs().get(0);
			    			
			    			if (oldGraphPattern != null) {
			    				EcoreUtil.replace(oldGraphPattern, newGraphPattern);
			    			} else {
			    				pattern.getGraphs().add(newGraphPattern);
			    			}
			    			
			    			parameters.addAll(newPattern.getParameters());
			    		}
			    	}
			    }
			}
			
			updateParameters(pattern, parameters, overwrite);
			 
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	protected void updateParameters(Pattern pattern, List<Parameter> newParameters, boolean overwrite) {
		
		if (overwrite) {
			pattern.getParameters().clear();
		}
		
		for (Parameter parameter : newParameters) {
			if (pattern.getParameter(parameter.getName()) == null) {
				pattern.getParameters().add(parameter);
			}
		}
	}

	protected boolean matchFileExtension(IResource member) {
		String fileExtension = member.getFileExtension();
		
		if (fileExtension != null) {
			for (String modelFileExtension : modelFileExtensions) {
				if (fileExtension.equalsIgnoreCase(modelFileExtension)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
