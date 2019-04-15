package org.sidiff.common.settings;

/**
 * Implement this interface to listen to changes in the settings object.
 */
public interface ISettingsChangedListener {

	/**
	 * This function will be called every time when a setting was changed.
	 * 
	 * @param item
	 *            Some enumeration that is associated with the changed setting (
	 *            Enumeration: <em><...>SettingsItem</em>).
	 */
	public void settingsChanged(Enum<?> item);
}
