package org.sidiff.difference.symmetric.graphviewer.diagram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.common.attributes.IAttributeStore;
import org.eclipse.gef.fx.swt.canvas.IFXCanvasFactory;
import org.eclipse.gef.graph.Graph;
import org.eclipse.gef.layout.LayoutContext;
import org.eclipse.gef.layout.algorithms.SpringLayoutAlgorithm;
import org.eclipse.gef.mvc.fx.domain.IDomain;
import org.eclipse.gef.mvc.fx.models.SelectionModel;
import org.eclipse.gef.mvc.fx.parts.IContentPart;
import org.eclipse.gef.mvc.fx.ui.MvcFxUiModule;
import org.eclipse.gef.mvc.fx.viewer.IViewer;
import org.eclipse.gef.mvc.fx.viewer.InfiniteCanvasViewer;
import org.eclipse.gef.zest.fx.ZestProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingGraphElement;
import org.sidiff.difference.symmetric.graphviewer.content.MatchingGraphImporter;
import org.sidiff.difference.symmetric.graphviewer.modules.IntegratedMatchingModule;
import org.sidiff.difference.symmetric.graphviewer.parts.MatchingEdgeContentPart;
import org.sidiff.difference.symmetric.graphviewer.parts.MatchingNodeContentPart;
import org.sidiff.difference.symmetric.graphviewer.parts.design.NodeDesignSwitcher.Design;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.embed.swt.FXCanvas;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;

/**
 * @author Manuel Ohrndorf
 */
public class IntegratedMatchingDiagram  {

	/**
	 * The primary control associated with this diagram.
	 */
	protected Composite container;
	
	/**
	 * The integrated model difference viewer.
	 */
	private IViewer viewer;
	
	/**
	 * Viewer graph content.
	 */
	private Graph graph;
	
	/**
	 * Creates a new instance of this diagram.
	 */
	public IntegratedMatchingDiagram() {
	}

	public Control getControl() {
		return container;
	}

	public void createControls(Composite parent) {
		
		// Layout:
		container = new Composite(parent, SWT.NONE);
		GridLayout gl_container = new GridLayout(1, false);
		gl_container.verticalSpacing = 0;
		gl_container.marginWidth = 0;
		gl_container.marginHeight = 0;
		gl_container.horizontalSpacing = 0;
		container.setLayout(gl_container);
		
		Composite composite_viewer = new Composite(container, SWT.NONE);
		composite_viewer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite_viewer.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		// GEF4 setup:
		
		// > Setup GEF modules:
		final IntegratedMatchingModule moduleDomain = new IntegratedMatchingModule();
		final Module moduleUI = (Module) new MvcFxUiModule();
		final Module module = Modules.override(moduleDomain).with(moduleUI);
		final Injector injector = Guice.createInjector(module);
		
		// > Setup GEF viewer:
		IDomain domain = injector.getInstance(IDomain.class);
		viewer = domain.getAdapter(IViewer.class);
		
		IFXCanvasFactory canvasFactory = injector.getInstance(IFXCanvasFactory.class);
		FXCanvas canvas = canvasFactory.createCanvas(composite_viewer, SWT.NONE);
		canvas.setScene(new Scene(viewer.getCanvas()));

		// > Activate domain:
		domain.activate();
	}
	
	public void setInput(MatchingGraphImporter importer) {
		
		if (graph == null) {
			graph = new Graph();
			viewer.getContents().add(graph);
			actionLayout();
		} else {
			graph.getEdges().clear();
			graph.getNodes().clear();
		}
		
		importer.getNodes().forEachRemaining(n -> graph.getNodes().add(n.getGraphNode()));
		importer.getEdges().forEachRemaining(e -> graph.getEdges().add(e.getGraphEdge()));
	}
	
	public void actionLayout() {
		
		// NOTE: org.eclipse.gef.layout.examples.SpringLayoutProgressExample
		
		ToggleButton toggleLayoutButton = new ToggleButton("Layout");
		Group overlay = ((InfiniteCanvasViewer) viewer).getCanvas().getOverlayGroup();
		overlay.getChildren().add(toggleLayoutButton);
		
		SpringLayoutAlgorithm layoutAlgorithm = new SpringLayoutAlgorithm();
		layoutAlgorithm.setRandom(true);
		ZestProperties.setLayoutAlgorithm(graph, layoutAlgorithm);

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				LayoutContext layoutContext = viewer.getContentPartMap().get(graph).getAdapter(LayoutContext.class);
				layoutContext.applyLayout(true);
				
				new AnimationTimer() {
					private long last = 0;
					private final long NANOS_PER_MILLI = 1000000;
					private final long NANOS_PER_ITERATION = 10 * NANOS_PER_MILLI;

					@Override
					public void handle(long now) {
						if (toggleLayoutButton.isSelected()) {
							long elapsed = now - last;
							if (elapsed > NANOS_PER_ITERATION) {
								int n = (int) (elapsed / NANOS_PER_ITERATION);
								layoutAlgorithm.performNIteration(n);
								last = now;
							}
						} else {
							last = now;
						}
					}
				}.start();
			}
		});
	}
	
	private List<IContentPart<? extends Node>> getSelectionOrAllParts(Class<?> type) {
		SelectionModel selectionModel = viewer.getAdapter(SelectionModel.class);
		List<IContentPart<? extends Node>> selection = selectionModel.getSelectionUnmodifiable();
		
		if (!selection.isEmpty()) {
			for (IContentPart<? extends Node> contentPart : selection) {
				if (type.isInstance(contentPart)) {
					return selection;		
				}
			}
		}
		return new ArrayList<IContentPart<? extends Node>>(viewer.getContentPartMap().values());
	}
	
	/**
	 * Collapse all (selected) nodes one design step.
	 */
	public void actionCollapseNodes() {
		
		for (IContentPart<? extends Node> contentPart : 
			getSelectionOrAllParts(MatchingNodeContentPart.class)) {
			
			if (contentPart instanceof MatchingNodeContentPart) {
				MatchingNodeContentPart node = (MatchingNodeContentPart) contentPart;
				
				switch (node.getDesign()) {
				case NODE:
					// Fake event to notify an external design change...
					node.setDesign(Design.NODE);
					break;
				case NODE_WITH_ICON:
					node.setDesign(Design.NODE);
					break;
				case NODE_WITH_ICON_TEXT:
					node.setDesign(Design.NODE_WITH_ICON);
					break;
				case NODE_WITH_ICON_TEXT_ATTRIBUTES:
					node.setDesign(Design.NODE_WITH_ICON_TEXT);
					break;
				}
			}
		}
	}
	
	/**
	 * Expand all (selected) nodes one design step.
	 */
	public void actionExpandNodes() {
		
		for (IContentPart<? extends Node> contentPart : 
			getSelectionOrAllParts(MatchingNodeContentPart.class)) {
			
			if (contentPart instanceof MatchingNodeContentPart) {
				MatchingNodeContentPart node = (MatchingNodeContentPart) contentPart;
				
				switch (node.getDesign()) {
				case NODE:
					node.setDesign(Design.NODE_WITH_ICON);
					break;
				case NODE_WITH_ICON:
					node.setDesign(Design.NODE_WITH_ICON_TEXT);
					break;
				case NODE_WITH_ICON_TEXT:
					node.setDesign(Design.NODE_WITH_ICON_TEXT_ATTRIBUTES);
					break;
				case NODE_WITH_ICON_TEXT_ATTRIBUTES:
					// Fake event to notify an external design change...
					node.setDesign(Design.NODE_WITH_ICON_TEXT_ATTRIBUTES);
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * @param visibility
	 *            The visibility of the labels. (Will show a tooltip instead.)
	 */
	public void actionSetEdgeLabelVisibility(boolean visibility) {
		
		for (IContentPart<? extends Node> contentPart : 
			getSelectionOrAllParts(MatchingEdgeContentPart.class)) {
			
			if (contentPart instanceof MatchingEdgeContentPart) {
				((MatchingEdgeContentPart) contentPart).setLabelsVisible(visibility);
			}
		}
	}
	
	public List<MatchingGraphElement> getSelection() {
		if (viewer != null) {
			SelectionModel selectionModel = viewer.getAdapter(SelectionModel.class);
			List<MatchingGraphElement> selection = new ArrayList<>();
			
			for (IContentPart<? extends Node> contentProvider : selectionModel.getSelectionUnmodifiable()) {
				if (contentProvider.getContent() instanceof IAttributeStore) {
					Object content = ((IAttributeStore) contentProvider.getContent())
							.getAttributes().get(MatchingGraphElement.ATTRIBUTE_CONTENT);
					
					// Matching elements:
					if (content instanceof MatchingGraphElement) {
						selection.add((MatchingGraphElement) content);
					}
				}
			}
			
			return selection;	
		}
		return Collections.emptyList();
	}
	

	public void setSelection(Collection<? extends EObject> selection) {
		if (viewer != null) {
			SelectionModel selectionModel = viewer.getAdapter(SelectionModel.class);
			List<IContentPart<? extends Node>> contentParts 
					= new ArrayList<IContentPart<? extends Node>>();
			
			for (Object selected : selection) {
				IContentPart<? extends Node> contentPart = viewer.getContentPartMap().get(selected);
				
				if (contentPart != null) {
					contentParts.add(contentPart);
				}
			}
			
			selectionModel.setSelection(contentParts);
		}
	}
	
	public void dispose() {
		viewer.deactivate();
		viewer.dispose();
		container.dispose();
	}
}
