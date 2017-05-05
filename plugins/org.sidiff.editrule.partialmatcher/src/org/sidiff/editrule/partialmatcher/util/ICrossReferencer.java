package org.sidiff.editrule.partialmatcher.util;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface ICrossReferencer {

	Iterator<? extends EObject> getInverse(EObject source, EReference inverse);

}