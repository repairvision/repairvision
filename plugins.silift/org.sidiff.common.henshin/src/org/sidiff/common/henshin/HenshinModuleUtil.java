package org.sidiff.common.henshin;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.ParameterMapping;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;

public class HenshinModuleUtil {

	/**
	 * Creates a new Module that is an inverse of an input Module
	 * @param name
	 * 				the name for the new Module.
	 * @param description
	 * 				the description for the new Module.
	 * @param inputModule
	 * 				the Henshin Module from which an inverse should be created.
	 * @return the new Module.
	 */	
	public static Module createInverse(String name, String description, Module inputModule) {
		
		// create inverse
		Module module = EcoreUtil.copy(inputModule);
		module.setName(name);
		module.setDescription(description);
		for(Unit unit: module.getUnits()) {
			if(unit instanceof Rule){
				
				Rule r = (Rule)unit;
				Graph lhs = r.getRhs();
				lhs.setName("LHS");
				Graph rhs = r.getLhs();
				rhs.setName("RHS");
				r.setLhs(lhs);
				r.setRhs(rhs);
			
				for(Mapping m: r.getMappings()) {
					Node origin = m.getImage();
					Graph orginGraph = m.getImage().getGraph();
					origin.setGraph(orginGraph);
				
					Node image = m.getOrigin();
					Graph imageGraph = m.getOrigin().getGraph();
					image.setGraph(imageGraph);
				
					m.setImage(image);
					m.setOrigin(origin);
				
				}
			
				// remove attributes under <<delete>> nodes and their ParameterMappings
				// and not used Parameters will be deleted automatically then.
				for(Node n:r.getLhs().getNodes()) {
					List<ParameterMapping> removableMappings = new ArrayList<ParameterMapping>();
				
					if(HenshinRuleAnalysisUtilEx.isDeletionNode(n)) {
						for(Attribute a:n.getAttributes()) {
						
							for(ParameterMapping pm:r.getParameterMappings()) {
								if(	pm.getTarget().getName().equals(a.getValue()) ||
										pm.getSource().getName().equals(a.getValue())) {
								
									removableMappings.add(pm);
								}
							}
						}
						n.getAttributes().clear();
					}
					r.getParameterMappings().removeAll(removableMappings);
				}
	
			}
	
		}
		return module;
		
	}

}
