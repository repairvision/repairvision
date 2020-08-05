package org.sidiff.graphpattern.tools.model2graph;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.revision.common.emf.EMFHandlerUtil;
import org.sidiff.revision.common.emf.EMFStorage;

public class ModelToGraphPatternFactory {

	public static final String FILE_EXTENSION = "model2graph";
	
	protected boolean createDefinitionFile = false;
	
	public ModelToGraphPatternFactory() {
	}
	
	public ModelToGraphPatternFactory(boolean createDefinitionFile) {
		this.createDefinitionFile = createDefinitionFile;
	}

	public Resource loadModel(IFile modelFile) {
		ResourceSet rss = new ResourceSetImpl();
		URI uri = EMFHandlerUtil.getURI(modelFile);
		Resource modelResource = rss.getResource(uri, true);
		
		return modelResource;
	}
	
	public ModelToGraphPatternDefiniton createDefinition(Resource model) {
		File definitionFile = getDefinitionFile(model);
		ModelToGraphPatternDefiniton definition = new ModelToGraphPatternDefiniton(definitionFile);
		
		if (createDefinitionFile && !definitionFile.exists()) {
			try {
				definition.createDefinitionFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return definition;
	}
	
	protected static File getDefinitionFile(Resource model) {
		return EMFStorage.uriToFile(model.getURI().trimFileExtension().appendFileExtension(FILE_EXTENSION));
	}
	
	public ModelToGraphPatternTransformation createTransformation(ModelToGraphPatternDefiniton definition) {
		return new ModelToGraphPatternTransformation(definition);
	}
}
