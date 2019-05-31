package org.sidiff.completion.ui.list;

import java.awt.MouseInfo;
import java.awt.PointerInfo;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.util.Util;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class CompletionProposalList {
	
	/*
	 * See: org.eclipse.jface.text.contentassist.CompletionProposalPopup
	 */

	private Shell fProposalShell;
	
	private TableViewer fProposalTable;
	
	private DefaultInformationControl fProposalInformation;
	
	public CompletionProposalList() {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				createPopup();
			}
		});
	}
	
	public void showPopupOnCursor() {
		PointerInfo mousePositionInfo = MouseInfo.getPointerInfo();
		int mousePositionX = mousePositionInfo.getLocation().x;
		int mousePositionY = mousePositionInfo.getLocation().y;
		Point mousePosition = new Point(mousePositionX, mousePositionY);
		
		showPopup(mousePosition);
	}
	
	public Object getSelectedProposal() {
		if (fProposalTable != null) {
			if (!fProposalTable.getStructuredSelection().isEmpty()) {
				return fProposalTable.getStructuredSelection().getFirstElement();
			}
		}
		return null;
	}
	
	public void addProposal(ICompletionProposal proposal) {
		fProposalTable.add(proposal);
	}
	
	public void addProposals(ICompletionProposal[] proposals) {
		fProposalTable.add(proposals);
	}
	
	public void setSelection(int index) {
		fProposalTable.getTable().setSelection(fProposalTable.getTable().getItem(index));
		fProposalTable.setSelection(fProposalTable.getSelection()); // trigger listener
	}
	
	public void showPopup(Point position) {

		/*
		 * Create shell
		 */
		{
			fProposalShell.setFont(JFaceResources.getDefaultFont());

			GridLayout layout = new GridLayout();
			{
				layout.marginWidth = 0;
				layout.marginHeight = 0;
				layout.verticalSpacing = 1;
			}
			fProposalShell.setLayout(layout);
			fProposalShell.setLocation(position);
		}

		/* 
		 * Create content table:
		 */
		{
			// Layout:
			fProposalTable.getTable().setHeaderVisible(false);
			fProposalTable.getTable().setLocation(0, 0);

			GridData data = new GridData(GridData.FILL_BOTH);
			{
				int height = fProposalTable.getTable().getItemHeight() * 10;
				double aspectRatio = 2;
				int width = (int) (height * aspectRatio);

				// Make sure our bounds still fit to the screen
				Monitor monitor = Util.getClosestMonitor(fProposalShell.getDisplay(), position);
				Rectangle bounds = monitor.getClientArea();
				width = Math.min(width, bounds.width / 4);
				height = Math.min(height, bounds.height / 4);

				Rectangle trim = fProposalTable.getTable().computeTrim(0, 0, width, height);
				data.heightHint = trim.height;
				data.widthHint = trim.width;
			}
			fProposalTable.getTable().setLayoutData(data);
			
			// Provider for content, icons and text of proposals:
			fProposalTable.setContentProvider(ArrayContentProvider.getInstance());
			fProposalTable.setLabelProvider(getLabelProvider());
			
			// Trigger initial selection:
			if (fProposalTable.getTable().getItemCount() > 0) {
				setSelection(0);
			}
			
			fProposalShell.pack();
		}

		/*
		 *  Create proposal information:
		 */
		{
			int width = fProposalShell.getBounds().width;
			int height = fProposalShell.getBounds().height;
			int x = fProposalShell.getLocation().x + fProposalShell.getBounds().width;
			int y = fProposalShell.getLocation().y;

			fProposalInformation.setSizeConstraints(width, height);
			fProposalInformation.setSize(width, height);
			fProposalInformation.setLocation(new Point(x, y));
		}

		/*
		 * Open the proposal viewer:
		 */
		fProposalShell.open();
	}
	
	private void createPopup() {

		/*
		 * Create shell
		 */
		fProposalShell = new Shell(PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.ON_TOP | SWT.RESIZE);
		
		/* 
		 * Create content table:
		 */
		fProposalTable = new TableViewer(fProposalShell, SWT.H_SCROLL | SWT.V_SCROLL | SWT.VIRTUAL);
		{
			// Enable keyboard support:
			fProposalTable.getTable().addKeyListener(new KeyListener() {

				@Override
				public void keyReleased(KeyEvent e) {
					
					// Apply proposal by pressing return:
					if (e.keyCode == SWT.CR) {
						Object selection = getSelectedProposal();
						
						fProposalShell.close();
						fProposalShell.dispose();
						
						applyProposal(selection);
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
				}
			});
			
			// Apply proposal on double click:
			fProposalTable.addDoubleClickListener(new IDoubleClickListener() {

				@Override
				public void doubleClick(DoubleClickEvent event) {
					Object selection = getSelectedProposal();
					
					fProposalShell.close();
					fProposalShell.dispose();
					
					applyProposal(selection);
				}
			});
			
			// Preview proposal on each selection:
			fProposalTable.addSelectionChangedListener(new ISelectionChangedListener() {
				
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					Object selection = getSelectedProposal();
					
					// Show preview:
					previewProposal(selection);
					
					// Show proposal information:
					String information = getProposalInformation(selection);
					
					if (information != null) {
						fProposalInformation.setInformation(information);
						fProposalInformation.setVisible(true);
					} else {
						fProposalInformation.setVisible(false);
					}
				}
			});
		}
		
		/*
		 *  Create proposal information:
		 */
		fProposalInformation = new DefaultInformationControl(fProposalShell, true);
		
		/*
		 * (1) Close the proposal list when losing the focus:
		 */
		fProposalTable.getTable().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (!fProposalInformation.isFocusControl()) {
					fProposalShell.close();
					fProposalShell.dispose();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});

		/*
		 * (2) Delegate the focus back to table. If the table is the new focus, then the
		 * viewer will remain open; otherwise it will be closed by the table (1).
		 */
		fProposalInformation.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (!fProposalTable.getControl().isFocusControl()) {
					fProposalTable.getControl().setFocus();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});
	}
	
	protected boolean previewProposal(Object proposal) {
		if (proposal instanceof ICompletionProposal) {
			return ((ICompletionProposal) proposal).preview();
		}
		return false;
	}
	
	protected boolean applyProposal(Object proposal) {
		if (proposal instanceof ICompletionProposal) {
			return ((ICompletionProposal) proposal).apply();
		}
		return false;
	}
	
	protected String getProposalInformation(Object proposal) {
		if (proposal instanceof ICompletionProposal) {
			return ((ICompletionProposal) proposal).getInformation();
		}
		return null;
	}
	
	protected ILabelProvider getLabelProvider() {
		return new ILabelProvider() {

			@Override
			public void removeListener(ILabelProviderListener listener) {
			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			@Override
			public void dispose() {
			}

			@Override
			public void addListener(ILabelProviderListener listener) {
			}

			@Override
			public String getText(Object element) {
				
				if (element instanceof ICompletionProposal) {
					return ((ICompletionProposal) element).getText();
				}
				
				return element.toString();
			}

			@Override
			public Image getImage(Object element) {
				
				if (element instanceof ICompletionProposal) {
					return ((ICompletionProposal) element).getImage();
				}
				
				return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
			}
		};
	}
}
