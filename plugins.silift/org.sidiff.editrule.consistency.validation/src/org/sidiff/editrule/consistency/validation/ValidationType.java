package org.sidiff.editrule.consistency.validation;

public enum ValidationType {
	ruleOrganization,
	mainUnit,
	mainUnitType,
	mainUnitComposition,
	noUnusedParameters,
	uniqueParameterNames,
	mappedAllRuleObjectInParameters,
	mappedAllCreateNodes,
	mappedAllValueSettingParameters,
	correctParameterTyping,
	consistentEOpposite, 
	derivedEdges,
	atLeastOneAction,
	acComposition,
	acBoundaries,
	lhsBoundaries,
	noAcBoundaryAttributes, 
	multiRuleNodeEmbedding,
	multiRuleEdgeEmbedding,
	multiRuleAttributeEmbedding,
	multiRuleParameterEmbedding,
	uniqueMultiMappings,
	knownAnnotation
}
