package org.sidiff.revision.editrules.generation.difference.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.junit.Assert;
import org.junit.Test;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.editrules.generation.difference.DifferenceToEditRule;
import org.sidiff.revision.editrules.generation.difference.builder.GraphPatternBuilder;
import org.sidiff.revision.editrules.generation.difference.builder.HenshinBuilder;
import org.sidiff.revision.editrules.generation.difference.configuration.SymmetricModelDifference;
import org.sidiff.revision.editrules.generation.difference.configuration.TransformationConfiguration;


public class DifferenceToEditRuleTest {
	
	// smoke testing ;)

	@Test
	public void toHenshin() {
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource difference = resourceSet.getResource(URI.createPlatformPluginURI("/org.sidiff.revision.editrules.generation.difference/tests/test01/modelAToB.revisiondiff", true), true);
		SymmetricModelDifference symmetricModelDifference = new SymmetricModelDifference((Difference) difference.getContents().get(0));
		
		HenshinBuilder builder = new HenshinBuilder();
		TransformationConfiguration transformationConfiguration = new TransformationConfiguration("TEST", symmetricModelDifference);
		
		DifferenceToEditRule<Rule, Node, Edge, Attribute> transformation 
			= new DifferenceToEditRule<Rule, Node, Edge, Attribute>(builder, transformationConfiguration);
		
		transformation.transform();
		
		Assert.assertEquals(13, transformation.getBuilder().sizeNodes());
		Assert.assertEquals(62, transformation.getBuilder().sizeAttributes());
		Assert.assertEquals(24, transformation.getBuilder().sizeEdges());
	}
	
	@Test
	public void toGraphPattern() {
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource difference = resourceSet.getResource(URI.createPlatformPluginURI("/org.sidiff.revision.editrules.generation.difference/tests/test01/modelAToB.revisiondiff", true), true);
		SymmetricModelDifference symmetricModelDifference = new SymmetricModelDifference((Difference) difference.getContents().get(0));
		
		GraphPatternBuilder builder = new GraphPatternBuilder();
		TransformationConfiguration transformationConfiguration = new TransformationConfiguration("TEST", symmetricModelDifference);
		
		DifferenceToEditRule<GraphPattern, NodePattern, EdgePattern, AttributePattern> transformation 
			= new DifferenceToEditRule<GraphPattern, NodePattern, EdgePattern, AttributePattern>(builder, transformationConfiguration);
		
		transformation.transform();
		
		Assert.assertEquals(9, transformation.getBuilder().sizeNodes());
		Assert.assertEquals(35, transformation.getBuilder().sizeAttributes());
		Assert.assertEquals(17, transformation.getBuilder().sizeEdges());
	}
}
