package org.sidiff.repair.history.generator.ecore;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.historymodel.ValidationError;
import org.sidiff.repair.history.generator.metadata.DataSetMetadata;
import org.sidiff.repair.history.generator.metadata.HistoryMetadata;
import org.sidiff.repair.history.generator.metadata.VersionMetadata;
import org.sidiff.repair.history.generator.validation.EMFValidator;

public class EcoreHistoryValidationApplication implements IApplication  {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		DataSetMetadata dataset = new DataSetMetadata("C:\\evaluation\\", true);
		Set<String> validationNames = new HashSet<>();
		int inconsistencyCount = 0;
		int inconsistentModels = 0;
		
		for (HistoryMetadata history : dataset.getHistories()) {
			for (VersionMetadata version : history.getVersions()) {
				File originalFile = new File(version.getLocalFilePath()); 
				File resolvedFile = new File(
						history.getDatafile().getParent() 
						+ "/" + originalFile.getParent() + "_resolved"
						+ "/" + originalFile.getName());
				URI uri = URI.createFileURI(resolvedFile.getAbsolutePath());
				
				ResourceSet resourceSet = new ResourceSetImpl();
				Resource model = resourceSet.getResource(uri, true);
				
				EMFValidator validator = new EMFValidator();
				Collection<ValidationError> inconsistencies = validator.validate(model);
				inconsistencyCount += inconsistencies.size();
				
				if (!inconsistencies.isEmpty()) {
					++inconsistentModels;
				}
				
				Set<String> modelValidationNames = inconsistencies.stream().map(ValidationError::getName).collect(Collectors.toSet());
				validationNames.addAll(modelValidationNames);
			}
		}
		
		System.out.println("Inconsistencies found: " + inconsistencyCount);
		System.out.println("Inconsistent Model Histories: " + inconsistentModels);
		
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
	}
}
