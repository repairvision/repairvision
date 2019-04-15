package org.sidiff.common.settings;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

/**
 * Abstract implementation of {@link ISettings} managing a list of
 * {@link ISettingsChangedListener listeners} that can be notified
 * by subclasses by calling {@link #notifyListeners}. Subclasses
 * must implement {@link #validate(MultiStatus)} to add validation
 * results to the multi status.
 */
public abstract class AbstractSettings implements ISettings {

	/**
	 * All listeners of this Setting-Object.
	 */
	private final List<ISettingsChangedListener> listeners;

	/**
	 * Cached status describing the validity of this Settings-Object.
	 */
	private MultiStatus status;

	public AbstractSettings() {
		this.listeners = new ArrayList<ISettingsChangedListener>();
	}

	public void addSettingsChangedListener(ISettingsChangedListener listener) {
		if (!this.listeners.contains(listener)) {
			this.listeners.add(listener);
		}
	}

	public void removeSettingsChangedListener(ISettingsChangedListener listener) {
		this.listeners.remove(listener);
	}

	/**
	 * Call this function every time when a setting was changed!
	 * 
	 * @param item The Enumeration associated with the changed setting.
	 */
	protected void notifyListeners(Enum<?> item) {
		// reset cached validation result
		status = null;

		for (ISettingsChangedListener listener : listeners) {
			try {
				listener.settingsChanged(item);
			} catch (Exception e) {
				Platform.getLog(Platform.getBundle(Activator.PLUGIN_ID))
					.log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Settings listener threw exception", e));
			}
		}
	}

	@Override
	public IStatus validate() {
		if(status == null) {
			status = new MultiStatus(Activator.PLUGIN_ID, 0, "The settings were validated.", null);
			validate(status);
		}
		return status;
	}

	/**
	 * Validates the settings. Adds {@link IStatus} to the {@link MultiStatus}.<br>
	 * <b>Super must be called: <pre>super.validateSettings(multiStatus);</pre></b>
	 * @param multiStatus the multi status
	 */
	protected abstract void validate(MultiStatus multiStatus);
}
