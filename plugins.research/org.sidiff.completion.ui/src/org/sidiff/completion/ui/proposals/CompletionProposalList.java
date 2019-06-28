package org.sidiff.completion.ui.proposals;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.util.List;

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
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
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

	private Shell proposalShell;
	
	private TableViewer proposalTable;
	
	private DefaultInformationControl proposalInformation;
	
	private ICompletionPreview preview;
	
	public CompletionProposalList(Display display) {
		display.syncExec(new Runnable() {

			@Override
			public void run() {
				createPopup(display);
			}
		});
	}
	
	public CompletionProposalList() {
		this(PlatformUI.getWorkbench().getDisplay());
	}
	
	public boolean isEmpty() {
		return proposalTable.getTable().getItemCount() == 0;
	}
	
	public void showPopupOnCursor() {
		PointerInfo mousePositionInfo = MouseInfo.getPointerInfo();
		int mousePositionX = mousePositionInfo.getLocation().x;
		int mousePositionY = mousePositionInfo.getLocation().y;
		Point mousePosition = new Point(mousePositionX, mousePositionY);
		
		showPopup(mousePosition);
	}
	
	public Object getSelectedProposal() {
		if (proposalTable != null) {
			if (!proposalTable.getStructuredSelection().isEmpty()) {
				return proposalTable.getStructuredSelection().getFirstElement();
			}
		}
		return null;
	}
	
	public void addProposal(ICompletionProposal proposal) {
		proposalTable.add(proposal);
	}
	
	public void addProposals(ICompletionProposal[] proposals) {
		proposalTable.add(proposals);
	}
	
	public void addProposals(List<? extends ICompletionProposal> proposals) {
		proposalTable.add(proposals.toArray());
	}
	
	public void setSelection(int index) {
		proposalTable.getTable().setSelection(proposalTable.getTable().getItem(index));
		proposalTable.setSelection(proposalTable.getSelection()); // trigger listener
	}
	
	/**
	 * @param position The position on which the UI will be opened.
	 */
	public void showPopup(Point position) {

		/*
		 * Layout shell
		 */
		{
			proposalShell.setFont(JFaceResources.getDefaultFont());

			GridLayout layout = new GridLayout();
			{
				layout.marginWidth = 0;
				layout.marginHeight = 0;
				layout.verticalSpacing = 1;
			}
			proposalShell.setLayout(layout);
			proposalShell.setLocation(position);
		}

		/* 
		 * Layout content table:
		 */
		{
			// Layout:
			proposalTable.getTable().setHeaderVisible(false);
			proposalTable.getTable().setLocation(0, 0);

			GridData data = new GridData(GridData.FILL_BOTH);
			{
				int height = proposalTable.getTable().getItemHeight() * 10;
				double aspectRatio = 2;
				int width = (int) (height * aspectRatio);

				// Make sure our bounds still fit to the screen
				Monitor monitor = Util.getClosestMonitor(proposalShell.getDisplay(), position);
				Rectangle bounds = monitor.getClientArea();
				width = Math.min(width, bounds.width / 4);
				height = Math.min(height, bounds.height / 4);

				Rectangle trim = proposalTable.getTable().computeTrim(0, 0, width, height);
				data.heightHint = trim.height;
				data.widthHint = trim.width;
			}
			proposalTable.getTable().setLayoutData(data);
			
			// Provider for content, icons and text of proposals:
			proposalTable.setContentProvider(ArrayContentProvider.getInstance());
			proposalTable.setLabelProvider(getLabelProvider());
			
			// Trigger initial selection:
			if (proposalTable.getTable().getItemCount() > 0) {
				setSelection(0);
			}
			
			proposalShell.pack();
		}


		/*
		 * Open the proposal viewer:
		 */
		proposalShell.open();
		
		/*
		 *  Layout proposal information:
		 */
		layoutInformation(getProposalInformation(getSelectedProposal()));
	}
	
	private void layoutInformation(String information) {
		int width = proposalShell.getBounds().width;
		int height = proposalShell.getBounds().height;
		int x = proposalShell.getLocation().x + proposalShell.getBounds().width;
		int y = proposalShell.getLocation().y;

		proposalInformation.setSizeConstraints(width, height);
		proposalInformation.setSize(width, height);
		proposalInformation.setLocation(new Point(x, y));
		
		if (information != null) {
			proposalInformation.setInformation(information);
			proposalInformation.setVisible(true);
		} else {
			proposalInformation.setVisible(false);
		}
		
	}
	
	private void createPopup(Display display) {

		/*
		 * Create shell
		 */
		proposalShell = new Shell(display, SWT.ON_TOP | SWT.RESIZE);
		
		// Hide preview:
		proposalShell.addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				hideProposalPreview();
			}
		});
		
		/* 
		 * Create content table:
		 */
		proposalTable = new TableViewer(proposalShell, SWT.H_SCROLL | SWT.V_SCROLL | SWT.VIRTUAL);
		{
			// Enable keyboard support:
			proposalTable.getTable().addKeyListener(new KeyListener() {

				@Override
				public void keyReleased(KeyEvent e) {
					
					// Apply proposal by pressing return:
					if (e.keyCode == SWT.CR) {
						Object selection = getSelectedProposal();
						
						proposalShell.close();
						proposalShell.dispose();
						
						applyProposal(selection);
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
				}
			});
			
			// Apply proposal on double click:
			proposalTable.addDoubleClickListener(new IDoubleClickListener() {

				@Override
				public void doubleClick(DoubleClickEvent event) {
					Object selection = getSelectedProposal();
					
					proposalShell.close();
					proposalShell.dispose();
					
					applyProposal(selection);
				}
			});
			
			// Preview proposal on each selection:
			proposalTable.addSelectionChangedListener(new ISelectionChangedListener() {
				
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					Object selection = getSelectedProposal();
					showProposalPreview(selection);
				}
			});
			
			// Show proposal information:
			proposalTable.addSelectionChangedListener(new ISelectionChangedListener() {
				
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					Object selection = getSelectedProposal();
					String information = getProposalInformation(selection);
					layoutInformation(information);
				}
			});
		}
		
		/*
		 *  Create proposal information:
		 */
		proposalInformation = new DefaultInformationControl(proposalShell, true);
		
		/*
		 * (1) Close the proposal list when losing the focus:
		 */
		proposalTable.getTable().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				
				if (!proposalInformation.isFocusControl()) {
					hideProposalPreview();
					proposalShell.close();
					proposalShell.dispose();
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
		proposalInformation.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (!proposalTable.getControl().isFocusControl()) {
					proposalTable.getControl().setFocus();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});
	}
	
	protected boolean showProposalPreview(Object proposal) {
		if (proposal instanceof ICompletionProposal) {
			
			// Hide old preview:
			hideProposalPreview();
			
			// Show new preview:
			preview = ((ICompletionProposal) proposal).preview();
			
			if (preview != null) {
				return preview.show();
			}
		}
		return false;
	}
	
	protected boolean hideProposalPreview() {
		if (preview != null) {
			ICompletionPreview lastPreview = preview;
			preview = null;
			return lastPreview.hide();
		}
		return false;
	}
	
	protected boolean applyProposal(Object proposal) {
		if (proposal instanceof ICompletionProposal) {
			
			// Hide preview:
			hideProposalPreview();
			
			// Apply real proposal:
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
	
	public static String escapeHTML(String s) {
	    StringBuilder out = new StringBuilder(Math.max(16, s.length()));
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c > 127 || c == '"' || c == '<' || c == '>' || c == '&') {
	            out.append("&#");
	            out.append((int) c);
	            out.append(';');
	        } else {
	            out.append(c);
	        }
	    }
	    return out.toString();
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
	
	public Shell getShell() {
		return proposalShell;
	}
}
