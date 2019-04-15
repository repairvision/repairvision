package org.sidiff.common.ui.widgets;

import org.eclipse.jface.dialogs.IMessageProvider;

public interface IWidgetValidation {

	/**
	 * Validate the actual state of the widget.
	 *
	 * @return <code>true</code> if everything is fine; <code>false</code> otherwise.
	 */
	public boolean validate();

	/**
	 * 
	 * @return An warning or error message about the actual state of the widget.
	 */
	public ValidationMessage getValidationMessage();


	public class ValidationMessage {

		/**
		 * Empty OK message instance to reuse
		 */
		public static final ValidationMessage OK = new ValidationMessage(ValidationType.OK, "");

		private String message;
		private ValidationType type;

		public ValidationMessage(ValidationType type, String message) {
			this.message = message;
			this.type = type;
		}

		public ValidationType getType() {
			return type;
		}

		public String getMessage() {
			return message;
		}

		public enum ValidationType {
			// these constants are ordered according to their importance
			OK(IMessageProvider.NONE),
			INFORMATION(IMessageProvider.INFORMATION),
			WARNING(IMessageProvider.WARNING),
			ERROR(IMessageProvider.ERROR);

			private int code;

			ValidationType(int code) {
				this.code = code;
			}

			public int getCode() {
				return code;
			}
		}
	}
}
