package org.sidiff.integration.eclipse;

import org.osgi.framework.Bundle;

public class IntegratorUtil {

	// Basic SiDiff namespaces
	public static final String SIDIFF_NAMESPACE = "org.sidiff";
	public static final String SIDIFF_CORE_NAMESPACE = "org.sidiff.core";
	public static final String SIDIFF_COMMON_NAMESPACE = "org.sidiff.common";

	// Domain Segments
	public static final String MODEL_SEGMENT = "model";
	public static final String MATCHING_SEGMENT = "matching";
	public static final String CORE_SEGMENT = "core";

	public static boolean isSiDiffCoreBundle(Bundle bundle) {
		return (bundle.getSymbolicName().startsWith(SIDIFF_CORE_NAMESPACE));
	}

	public static boolean isSiDiffCommonBundle(Bundle bundle) {
		return (bundle.getSymbolicName().startsWith(SIDIFF_COMMON_NAMESPACE));
	}
	
	public static boolean isSiDiffBundle(Bundle bundle) {
		return (bundle.getSymbolicName().startsWith(SIDIFF_NAMESPACE));
	}

	public static boolean isSiDiffDomainBundle(Bundle bundle) {
		if (bundle.getSymbolicName().startsWith(SIDIFF_NAMESPACE)
				&& bundle.getSymbolicName().endsWith("." + MODEL_SEGMENT)) {
			return true;
		} else if (bundle.getSymbolicName().startsWith(SIDIFF_NAMESPACE)
				&& bundle.getSymbolicName().endsWith("." + CORE_SEGMENT)) {
			return true;
		} else if (bundle.getSymbolicName().startsWith(SIDIFF_NAMESPACE)
				&& bundle.getSymbolicName().endsWith("." + MATCHING_SEGMENT)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isSiDiffMatchingEngineBundle(Bundle bundle) {
		return isSiDiffCommonBundle(bundle) || isSiDiffCoreBundle(bundle) || isSiDiffDomainBundle(bundle);
	}
}
