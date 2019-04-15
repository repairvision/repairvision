package org.sidiff.common.ui.widgets;

/**
 * The {@link IWidgetCallback} interface can be implemented by classes implementing {@link IWidget}.
 * Widgets implementing this interface receive a callback to the page containing the widget,
 * which can be used to request the validation, and that the layout be updated.
 * 
 * @author Robert Müller
 *
 */
public interface IWidgetCallback {

	/**
	 * Sets this widget's {@link Callback}.
	 * @param callback the callback
	 */
	void setWidgetCallback(Callback callback);

	/**
	 * Interface implemented by wizard pages to allow widgets to call back to the page.
	 *
	 */
	interface Callback {

		/**
		 * Requests that all widgets should be validated.
		 */
		void requestValidation();

		/**
		 * Requests that the page should update its layout and size.
		 */
		void requestLayout();

		/**
		 * An implementation of {@link Callback} that does nothing.
		 */
		Callback NO_OP = new Callback() {
			@Override
			public void requestValidation() {
				// do nothing
			}

			@Override
			public void requestLayout() {
				// do nothing
			}
		};
	}
}
