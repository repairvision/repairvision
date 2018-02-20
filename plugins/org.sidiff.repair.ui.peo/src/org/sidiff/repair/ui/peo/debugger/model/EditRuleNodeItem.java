package org.sidiff.repair.ui.peo.debugger.model;

import java.util.ArrayList;
import java.util.List;

public class EditRuleNodeItem extends EditRuleGraphElementItem  {

	private DomainItem domainA;
	
	private DomainItem domainB;
	
	private DomainItem difference;
	
	private List<EditRuleEdgeItem> outgoings = new ArrayList<>();
}
