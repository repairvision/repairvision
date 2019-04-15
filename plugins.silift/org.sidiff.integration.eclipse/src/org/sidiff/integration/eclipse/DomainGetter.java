package org.sidiff.integration.eclipse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.osgi.framework.Bundle;

public class DomainGetter {

	public DomainGetter() {
	}

	private static DomainGetter instance = null;

	public static DomainGetter getInstance() {
		if (instance == null) {
			instance = new DomainGetter();
		}
		return instance;
	}

	public HashSet<String> getDomains() {

		Collection<Bundle> domains = new ArrayList<Bundle>();
		ArrayList<String> tmp = new ArrayList<String>();
		HashSet<String> result = new HashSet<String>();

		Bundle[] bundles = Activator.getContext().getBundles();
		for (Bundle bundle : bundles) {
			if (IntegratorUtil.isSiDiffDomainBundle(bundle)) {
				domains.add(bundle);
				tmp.add(bundle.getSymbolicName());
			}
		}

		// domain complete..?
		for (String string : tmp) {

			if (string.endsWith(IntegratorUtil.MODEL_SEGMENT)) {

				String core = string.replace(IntegratorUtil.MODEL_SEGMENT, IntegratorUtil.CORE_SEGMENT);
				String matching = string.replace(IntegratorUtil.MODEL_SEGMENT, IntegratorUtil.MATCHING_SEGMENT);

				if (tmp.contains(core) && tmp.contains(matching)) {
					result.add(string.replace("."+IntegratorUtil.MODEL_SEGMENT, ""));
				}
				
			} else {
				continue;
			}
		}

		return result;
	}

}
