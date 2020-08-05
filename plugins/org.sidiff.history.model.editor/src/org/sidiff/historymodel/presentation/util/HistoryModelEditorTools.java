package org.sidiff.historymodel.presentation.util;

import static java.util.Collections.emptyIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.CompareUI;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.domain.ICompareEditingDomain;
import org.eclipse.emf.compare.domain.impl.EMFCompareEditingDomain;
import org.eclipse.emf.compare.ide.ui.internal.configuration.EMFCompareConfiguration;
import org.eclipse.emf.compare.ide.ui.internal.editor.ComparisonEditorInput;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.FilterComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.ui.IWorkbenchPage;
import org.sidiff.revision.common.emf.EMFStorage;

@SuppressWarnings("restriction")
public class HistoryModelEditorTools {

	public static void compare(Notifier left, Notifier right) {
		compare(left, right, null, null, null); 
	}
	
	public static void compare(Notifier left, Notifier right, Set<String> uriFragmentScope) {
		compare(left, right, null, null, uriFragmentScope); 
	}
	
	public static void compare(Notifier left, Notifier right, Notifier ancestor, IWorkbenchPage page, Set<String> uriFragmentScope) {
	    EMFCompare comparator = EMFCompare.builder().build();
	    IComparisonScope scope;

	    if (uriFragmentScope == null) {
	    	scope = new DefaultComparisonScope(left, right, ancestor);
	    } else {
	    	scope = createFilter(left, right, ancestor, uriFragmentScope);
	    }
	    
	    Comparison comparison = comparator.compare(scope);
	 
	    ICompareEditingDomain editingDomain = EMFCompareEditingDomain.create(left, right, ancestor);
	    AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	    CompareEditorInput input = new ComparisonEditorInput(new EMFCompareConfiguration(new CompareConfiguration()), comparison, editingDomain, adapterFactory);
	 
	    if (page != null) {
	    	CompareUI.openCompareEditorOnPage(input, page);
	    } else {
	    	CompareUI.openCompareEditor(input);
	    }
	}
	
	private static FilterComparisonScope createFilter(Notifier left, Notifier right, Notifier ancestor, Set<String> uriFragmentScope) {
		FilterComparisonScope filterScope = new FilterComparisonScope(left, right, ancestor) {
    		@Override
    		public Iterator<? extends EObject> getCoveredEObjects(Resource resource) {
    			if (resource == null) {
    				return emptyIterator();
    			}
    			
    			return new Iterator<EObject>() {
    				
    				Iterator<EObject> properContent = EcoreUtil.getAllProperContents(resource, false);
    				
    				EObject next = null;

					@Override
					public boolean hasNext() {
					
						while (properContent.hasNext() && (next == null)) {
							next = properContent.next();
							
							if (!uriFragmentScope.contains(EMFStorage.getXmiId(next))) {
								next = null;
							}
						}
						
						return next != null;
					}

					@Override
					public EObject next() {
						if (hasNext()) {
							EObject tmp_next = next;
							next = null;
							return tmp_next;
						} else {
							throw new NoSuchElementException();
						}
					}
				};
    		}
    	};
    	
    	return filterScope;
	}
}
