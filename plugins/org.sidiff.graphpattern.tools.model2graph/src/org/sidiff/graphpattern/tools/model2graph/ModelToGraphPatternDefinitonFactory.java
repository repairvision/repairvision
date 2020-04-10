package org.sidiff.graphpattern.tools.model2graph;

import java.io.File;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.modelstorage.EMFStorage;

public class ModelToGraphPatternDefinitonFactory {

	protected static final String FILE_EXTENSION = "model2graph";
	
	public ModelToGraphPatternDefiniton createDefintion(Resource model) {
		return new ModelToGraphPatternDefiniton(getDefinitionFile(model));
	}
	
	protected static File getDefinitionFile(Resource model) {
		return EMFStorage.uriToFile(model.getURI().trimFileExtension().appendFileExtension(FILE_EXTENSION));
	}
}
