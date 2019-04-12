package org.sidiff.difference.symmetric.graphviewer.modules;

import org.eclipse.gef.common.adapt.inject.AdaptableScopes;
import org.eclipse.gef.mvc.fx.parts.IContentPartFactory;
import org.eclipse.gef.mvc.fx.viewer.IViewer;
import org.eclipse.gef.zest.fx.ZestFxModule;
import org.sidiff.difference.symmetric.graphviewer.parts.MatchingContentPartFactory;

/**
 * <p>Based on: {@link org.eclipse.gef.zest.fx.ZestFxModule}</p>
 * 
 * <p>Adjusts the default GEF MVC Module (e.g. common content part stuff).</p>
 */
public class IntegratedMatchingModule extends ZestFxModule {
	
	protected void bindIContentPartFactory() {

		// Bind content part factory: (Model -> Content Part)
		binder().bind(IContentPartFactory.class)
			.to(MatchingContentPartFactory.class)
			.in(AdaptableScopes.typed(IViewer.class));
	}
}
