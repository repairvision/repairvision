package org.sidiff.repair.history.generator.repository;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public interface IHistoryRepository {
	
	String formatModelFileName(URI modelURI);
	
	String formatModelName(int revision, URI modelURI);
	
	Resource loadModel(URI modelURI);
	
	URI resolveModel(URI source, URI target);
	
	URI getNextModelVersion(URI modelURI);
	
	Set<String> getReferencedModels();
	
	ResourceSet getResourceSet();
	
	void sortHistory(List<URI> files);
	
	public static List<File> searchModelFiles(File root, String[] filters) {
		List<File> files = new ArrayList<>();
		
		FileFilter filter = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				if (!pathname.isDirectory()) {
					for (String filter : filters) {
						if (pathname.getName().toLowerCase().endsWith(filter)) {
							return true;
						}
					}
				}
				return false;
			}
		};
		
		files.addAll(Arrays.asList(root.listFiles(filter)));
		Collections.sort(files);
		
		// scan for sub-directories recursively
		for (File file : root.listFiles()) {
			if (file.isDirectory()) {
				files.addAll(searchModelFiles(file, filters));
			}
		}
		return files;
	}
}
