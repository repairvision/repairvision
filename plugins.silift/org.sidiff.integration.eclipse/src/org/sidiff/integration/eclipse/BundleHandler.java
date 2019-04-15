package org.sidiff.integration.eclipse;

import java.util.Collection;
import java.util.HashMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BundleHandler {
	private BundleHandler() {
	}

	private static BundleHandler instance = null;

	public static BundleHandler getInstance() {
		if (instance == null) {
			instance = new BundleHandler();
		}
		return instance;
	}

	private Logger logger = Logger.getLogger("org.sidiff.eclipse.integrator.BundleHandler");

	public void startBundles() {
		logger.log(Level.INFO, "Starting every SiDiff Bundle!");
		Collection<Bundle> bundleToStart = new ArrayList<Bundle>();

		Bundle[] bundles = Activator.getContext().getBundles();
		for (Bundle bundle : bundles) {
			if (IntegratorUtil.isSiDiffMatchingEngineBundle(bundle)) {
				bundleToStart.add(bundle);
			}
		}
		long time1, time2;
		time2 = System.currentTimeMillis();
		for (Bundle bundle : bundleToStart) {
			try {
				if (bundle.getState() != Bundle.ACTIVE) {// && bundle.getState()
															// !=
															// Bundle.STARTING)
															// {
					time1 = time2;
					bundle.start();
					time2 = System.currentTimeMillis();
					logger.log(Level.INFO, "Started '" + bundle.getSymbolicName() + "' (" + (time2 - time1) + " ms)");
				} else {
					// logger.log(Level.INFO, "Not started '" +
					// bundle.getSymbolicName() + "' (" + bundle.getState() +
					// ")");
				}
			} catch (BundleException e) {
			}
		}

		logger.log(Level.INFO, "Starting of every SiDiff Bundle is finished now!");
	}

	public void startBundles(ArrayList<Bundle> bundles) {
		logger.log(Level.INFO, "Starting a List of SiDiff Bundles!");

		long time1, time2;
		time2 = System.currentTimeMillis();
		for (Bundle bundle : bundles) {
			try {
				if (bundle.getState() != Bundle.ACTIVE) {// && bundle.getState()
															// !=
															// Bundle.STARTING)
															// {
					time1 = time2;
					bundle.start();
					time2 = System.currentTimeMillis();
					logger.log(Level.INFO, "Started '" + bundle.getSymbolicName() + "' (" + (time2 - time1) + " ms)");
				} else {
					// logger.log(Level.INFO, "Not started '" +
					// bundle.getSymbolicName() + "' (" + bundle.getState() +
					// ")");
				}
			} catch (BundleException e) {
			}
		}

		logger.log(Level.INFO, "Starting of the List of SiDiff Bundles is finished now!");

	}

	public void stopBundles() {
		logger.log(Level.INFO, "Stopping every SiDiff Bundle!");
		Collection<Bundle> bundleToStart = new ArrayList<Bundle>();

		Bundle[] bundles = Activator.getContext().getBundles();
		for (Bundle bundle : bundles) {
			if (IntegratorUtil.isSiDiffMatchingEngineBundle(bundle)) {
				bundleToStart.add(bundle);
			}
		}
		long time1, time2;
		time2 = System.currentTimeMillis();
		for (Bundle bundle : bundleToStart) {
			try {
				if (bundle.getState() == Bundle.ACTIVE) {// && bundle.getState()
															// !=
															// Bundle.STARTING)
															// {
					time1 = time2;
					bundle.stop();
					time2 = System.currentTimeMillis();
					logger.log(Level.INFO, "Stopping '" + bundle.getSymbolicName() + "' (" + (time2 - time1) + " ms)");
				} else {
					// logger.log(Level.INFO, "Not started '" +
					// bundle.getSymbolicName() + "' (" + bundle.getState() +
					// ")");
				}
			} catch (BundleException e) {
			}
		}

		logger.log(Level.INFO, "Stopping of every SiDiff Bundle is finished now!");
	}

	public void stopBundles(ArrayList<Bundle> bundles) {
		logger.log(Level.INFO, "Stopping a List of SiDiff Bundles!");

		long time1, time2;
		time2 = System.currentTimeMillis();
		for (Bundle bundle : bundles) {
			try {
				if (bundle.getState() == Bundle.ACTIVE) {// && bundle.getState()
															// !=
															// Bundle.STARTING)
															// {
					time1 = time2;
					bundle.stop();
					time2 = System.currentTimeMillis();
					logger.log(Level.INFO, "Stopping '" + bundle.getSymbolicName() + "' (" + (time2 - time1) + " ms)");
				} else {
					// logger.log(Level.INFO, "Not started '" +
					// bundle.getSymbolicName() + "' (" + bundle.getState() +
					// ")");
				}
			} catch (BundleException e) {
			}
		}

		logger.log(Level.INFO, "Stopping of the List of SiDiff Bundles is finished now!");
	}

	public void refreshBundles() {
		logger.log(Level.INFO, "Refreshing every SiDiff Bundle!");
		stopBundles();
		startBundles();
		logger.log(Level.INFO, "Refreshing of all SiDiff Bundles is finished now!");

	}

	public void refreshBundles(ArrayList<Bundle> bundles) {
		if (bundles.isEmpty()) {
			logger.log(Level.INFO, "List of refreshing Bundles is empty!");			
		} else {
			logger.log(Level.INFO, "Refreshing a List of SiDiff Bundles!");
			stopBundles(bundles);
			startBundles(bundles);
			logger.log(Level.INFO, "Refreshing of the List of SiDiff Bundles is finished now!");
		}
	}

	public ArrayList<Bundle> getSiDiffBundles() {

		ArrayList<Bundle> sidiffBundles = new ArrayList<Bundle>();

		Bundle[] bundles = Activator.getContext().getBundles();
		for (Bundle bundle : bundles) {
			if (IntegratorUtil.isSiDiffMatchingEngineBundle(bundle)) {
				sidiffBundles.add(bundle);
			}
		}
		return sidiffBundles;
	}

	public String getState(Bundle bundle) {
		switch (bundle.getState()) {
		case Bundle.ACTIVE:
			return "ACTIVE";
		case Bundle.INSTALLED:
			return "INSTALLED";
		case Bundle.RESOLVED:
			return "RESOLVED";
		default:
			return "either one";
		}

	}

	public ArrayList<Bundle> getBundleList(ArrayList<String> bundles) {
		ArrayList<Bundle> result = new ArrayList<Bundle>();
		ArrayList<Bundle> siDiffBundles = getSiDiffBundles();
		HashMap<String, Bundle> bundleMap = new HashMap<String, Bundle>();

		for (Bundle bundle : siDiffBundles) {
			bundleMap.put(bundle.getSymbolicName(), bundle);
		}

		for (String bundle : bundles) {
			result.add(bundleMap.get(bundle));
		}
		return result;
	}

}
