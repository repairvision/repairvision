package org.sidiff.history.revision.metamodel;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public interface IMetaModel {

	Set<EClass> getAllSuperTypes(EClass eClass);
	
	Set<EClass> getAllSubTypes(EClass eClass);
	
	Set<EReference> getAllOutgoingReferences(EClass eClass);
	
	Set<EReference> getAllIncomingReferences(EClass eClass);
}
