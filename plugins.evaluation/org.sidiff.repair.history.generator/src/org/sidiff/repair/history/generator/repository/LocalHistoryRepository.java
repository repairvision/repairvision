package org.sidiff.repair.history.generator.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.sidiff.repair.history.generator.repository.git.GitMetaData;
import org.sidiff.repair.history.generator.repository.svn.SVNConnector;

public class LocalHistoryRepository extends BasicHistoryRepository {

	private String localRepositoryPath;
	
	private List<Model> models = new ArrayList<>();
	
	private Map<String, GitMetaData> metadata = new HashMap<>();
	
	private class Model {
		String name;
		String pluginPath;
		Date date;
	}
	
	public LocalHistoryRepository(URI versionsTargetFolder, String path, String[] modelFileFilter) {
		super(versionsTargetFolder);
		this.localRepositoryPath = path;
		
		// Read files:
		for (File file : IHistoryRepository.searchModelFiles(new File(path), modelFileFilter)) {
			String pluginPath = file.getAbsolutePath().substring(path.length(), 
					file.getAbsolutePath().length() - file.getName().length());
			pluginPath = pluginPath.replaceAll("\\\\", "/");
			
			if (file.getName().equals(GitMetaData.META_FILE_NAME)) {
				metadata.put(pluginPath, new GitMetaData(file.getAbsolutePath()));
			} else {
				Model nextModel = new Model();
				nextModel.name = file.getName();
				nextModel.pluginPath = pluginPath;
				
				if (SVNConnector.isSVNVersion(nextModel.name)) {
					nextModel.date = ModelNamingUtil.getDate(file.getName());
				}
				
				models.add(nextModel);
			}
		}
		
		// Read metadata:
		for (File file : IHistoryRepository.searchModelFiles(new File(path), new String[] {"json"})) {
			String pluginPath = file.getAbsolutePath().substring(path.length(), 
					file.getAbsolutePath().length() - file.getName().length());
			pluginPath = pluginPath.replaceAll("\\\\", "/");
			
			metadata.put(pluginPath, new GitMetaData(file.getAbsolutePath()));
		}
		
		// Read time:
		for (Model model : models) {
			if (model.date == null) {
				String hash = ModelNamingUtil.getVersion(model.name);
				
				if (hash != null) {
					GitMetaData metadate = metadata.get(model.pluginPath);
					
					if (metadate != null) {
						String sDate = metadate.getDate(hash);
						model.date = ModelNamingUtil.parseDate(sDate);
					}
				}
			}
				
		}
	}
	
	@Override
	public String formatModelFileName(URI modelURI) {
		String date = ModelNamingUtil.unparseDate(getModel(modelURI.trimFragment()).date);
		String version = ModelNamingUtil.getVersion(modelURI.lastSegment());
		String name = ModelNamingUtil.getModelName(modelURI.lastSegment());
		
		return ModelNamingUtil.parseFileName(date, version, name);
	}

	@Override
	public URI resolveModel(URI source, URI target) {
		Model sourceModel = getModel(source);
		String targetModelName = target.lastSegment();
		
		Model matchedModel = null;
		
		for (Model model : models) {
			String name = ModelNamingUtil.getModelName(model.name);
			
			if (name.equalsIgnoreCase(targetModelName)) {
				if (matchedModel == null) {
					matchedModel = model;
				} else {
					long timeOld = Math.abs(sourceModel.date.getTime() - matchedModel.date.getTime());
					long timeNew = Math.abs(sourceModel.date.getTime() - model.date.getTime());
					
					if (timeNew < timeOld) {
						matchedModel = model;
					}
				}
			}
		}
		
		if (matchedModel != null) {
			return URI.createFileURI(localRepositoryPath + "/" + matchedModel.pluginPath + matchedModel.name);
		} else {
			return null;
		}
	}
	
	private Model getModel(URI modelURI) {
		for (Model model : models) {
			if (modelURI.toString().endsWith(model.pluginPath + model.name)) {
				return model;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuffer print = new StringBuffer();
		
		for (Model model : models) {
			print.append(model.date + ": " + model.pluginPath + model.name + "\n");
		}
		
		return print.toString();
	}
}
