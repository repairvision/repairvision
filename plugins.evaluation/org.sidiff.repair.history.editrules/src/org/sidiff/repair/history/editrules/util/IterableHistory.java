package org.sidiff.repair.history.editrules.util;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class IterableHistory extends IterableWork<Resource[]> {

	protected List<URI> history;
	
	public IterableHistory(List<URI> history) {
		this.history = history;
	}
	
	@Override
	public int getWork() {
		return history.size();
	}
	
	@Override
	public Iterator<Resource[]> iterator() {
		return new Iterator<Resource[]>() {
			
			Iterator<URI> modelURIs = history.iterator();
			
			URI modelAURI;
			
			Resource modelA;
			
			URI modelBURI;
			
			Resource modelB;
			
			{
				ResourceSet rss = new ResourceSetImpl();
				
				if (modelURIs.hasNext()) {
					modelAURI = modelURIs.next();
					modelA = loadModel(modelAURI, rss);
				}
				
				if (modelURIs.hasNext()) {
					modelBURI = modelURIs.next();
					modelB = loadModel(modelBURI, rss);
				}
			}
			
			@Override
			public Resource[] next() {
				
				if (hasNext()) {
					Resource[] next = new Resource[] {modelA, modelB};
					modelA = null;
					modelB = null;
					return next;
				} else {
					throw new NoSuchElementException();
				}
			}
			
			@Override
			public boolean hasNext() {
				
				if ((modelA == null) && (modelB == null)) {
					if (modelURIs.hasNext()) {
						modelAURI = modelBURI;
						modelBURI = modelURIs.next();
						
						ResourceSet rss = new ResourceSetImpl();
						modelA = loadModel(modelAURI, rss);
						modelB = loadModel(modelBURI, rss);
						
						return true;
					}
					return false;
				}
				return true;
			}
		};
	}
	
	protected static Resource loadModel(URI uri, ResourceSet rss) {
		return rss.getResource(uri, true);
	}
}
