package org.sidiff.history.revision.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.history.revision.IVersion;
import org.sidiff.history.revision.crossreferences.ICrossReferencer;
import org.sidiff.history.revision.crossreferences.impl.IndexedCrossReferencer;
import org.sidiff.revision.common.utilities.java.JUtil;

public class Version implements IVersion {
	
	private Set<Resource> resources = new HashSet<>();
	
	private Resource targetResource;
	
	private ICrossReferencer crossReferencer;
	
	public Version(Resource targetResource) {
		this.resources.add(targetResource);
		this.targetResource = targetResource;
		
		// TODO/FIXME: For future releases we can uncomment this line to lazy initialize cross-referencing!
		this.crossReferencer = getCrossReferencer();
	}

	@Override
	public Set<Resource> getResources() {
		return resources;
	}
	
	public boolean addResource(Resource resource) {
		if (crossReferencer != null) {
			crossReferencer.addResource(resource);
		}
		return resources.add(resource);
	}
	
	@Override
	public Resource getTargetResource() {
		return targetResource;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<? extends EObject> getTarget(EObject source, EReference outgoing) {
		if (outgoing.isMany()) {
			return ((Collection<EObject>) source.eGet(outgoing)).iterator();
		} else {
			Object target = source.eGet(outgoing);
			
			if (target instanceof EObject) {
				return JUtil.singeltonIterator((EObject) target);
			} else {
				return Collections.emptyIterator();
			}
		}
	}
	
	@Override
	public Iterator<? extends EObject> getSource(EObject target, EReference incoming) {
		return getCrossReferencer().getInverse(target, incoming);
	}

	private ICrossReferencer getCrossReferencer() {
		if (crossReferencer == null) {
			this.crossReferencer = new IndexedCrossReferencer();
			resources.forEach(crossReferencer::addResource);
		}
		return crossReferencer;
	}
}
