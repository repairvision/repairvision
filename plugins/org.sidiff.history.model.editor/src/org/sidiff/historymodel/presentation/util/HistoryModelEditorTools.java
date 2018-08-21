package org.sidiff.historymodel.presentation.util;

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
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.ui.IWorkbenchPage;

@SuppressWarnings("restriction")
public class HistoryModelEditorTools {

	public static void compare(Notifier left, Notifier right) {
		compare(left, right, null, null); 
	}
	
	public static void compare(Notifier left, Notifier right, IWorkbenchPage page) {
		compare(left, right, null, page); 
	}
	
	public static void compare(Notifier left, Notifier right, Notifier ancestor, IWorkbenchPage page) {
	    EMFCompare comparator = EMFCompare.builder().build();
	    IComparisonScope scope = new DefaultComparisonScope(left, right, ancestor);
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
}
