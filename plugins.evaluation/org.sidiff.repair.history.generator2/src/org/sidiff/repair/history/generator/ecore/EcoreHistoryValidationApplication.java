package org.sidiff.repair.history.generator.ecore;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
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
import org.sidiff.repair.history.generator.util.HistoryUtil;
import org.sidiff.repair.history.generator.validation.EMFValidator;

public class EcoreHistoryValidationApplication implements IApplication  {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		DataSetMetadata dataset = new DataSetMetadata("C:\\evaluation\\", true);
		
		Set<String> validationNames = new HashSet<>();
		Map<HistoryMetadata, Set<String>> inconsistentHistories = new LinkedHashMap<>();
		int inconsistencyCount = 0;
		int inconsistentModels = 0;
		
		for (HistoryMetadata history : dataset.getHistories()) {
			System.out.println("Project: " + history.getProjectName() + " Model: " + history.getLatestRemoteFilePath());
			
			// TODO: Create meta-data for resolved models!
			File modeHistoryFolder = new File(history.getDatafile().getParent() + File.separator
					+ history.getDatafile().getName().substring(0, history.getDatafile().getName().lastIndexOf(".")));
		
			for (File modelCommitFolder : modeHistoryFolder.listFiles()) {
				File modelVersion = new File(modelCommitFolder.getAbsoluteFile() 
						+ File.separator + new File(history.getLatestRemoteFilePath()).getName());
				URI uri = URI.createFileURI(modelVersion.getAbsolutePath());
				
				ResourceSet resourceSet = new ResourceSetImpl();
				Resource model = HistoryUtil.load(resourceSet, uri);
				
				EMFValidator validator = new EMFValidator();
				Collection<ValidationError> inconsistencies = validator.validate(model);
				
				// Analyze inconsistencies:
				if (!inconsistencies.isEmpty()) {
					inconsistencyCount += inconsistencies.size();
					++inconsistentModels;
					
					Set<String> modelValidationNames = inconsistencies.stream().map(ValidationError::getName).collect(Collectors.toSet());
					validationNames.addAll(modelValidationNames);
					
					if (inconsistentHistories.containsKey(history)) {
						inconsistentHistories.get(history).addAll(modelValidationNames);
					} else  {
						inconsistentHistories.put(history, modelValidationNames);
					}
				}
				
			}
		}
		
		System.out.println("Inconsistencies found: " + inconsistencyCount);
		System.out.println("Inconsistent Model Histories: " + inconsistentModels);
		System.out.println();
		System.out.println("Inconsistencies per Project:");
		
		for (HistoryMetadata history : inconsistentHistories.keySet()) {
			System.out.println();
			System.out.println(history.getInfo());
			
			for (String inconsistency : inconsistentHistories.get(history)) {
				System.out.println(inconsistency);
			}
		}
		
		
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
	}
}
