package org.sidiff.common.util;

import javax.swing.*;

/**
 * Utility class for opening simple windows for displaying text or HTML. 
 * @author wenzel
 */
public class SiDiffUIUtil {

	/**
	 * This method opens a Window to show the given File.
	 * 
	 * @param source
	 *            File to show.
	 * @param title
	 *            Title of the showing Window
	 */
	public static void showDataFrame(String source, String title) {

		JEditorPane dataOutputPanel = new JEditorPane();
		// dataOutputPanel.setContentType("text/html");
		dataOutputPanel.setEditable(false);
		dataOutputPanel.setText(source);

		JFrame dataframe = new JFrame(title);
		dataframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		dataframe.getContentPane().add(new JScrollPane(dataOutputPanel));
		dataframe.setSize(1200, 600);
		dataframe.setVisible(true);
	}

	/**
	 * This method opens a Window to show the given HTML data.
	 * 
	 * @param source
	 *            HTML source to be rendered.
	 * @param title
	 *            Title of the showing Window
	 */
	public static void showHtmlFrame(String source, String title) {

		JEditorPane dataOutputPanel = null;

		dataOutputPanel = new JEditorPane();
		dataOutputPanel.setContentType("text/html");
		dataOutputPanel.setEditable(false);

		dataOutputPanel.setText(source);

		JFrame dataframe = new JFrame(title);
		dataframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		dataframe.getContentPane().add(new JScrollPane(dataOutputPanel));
		dataframe.setSize(1200, 600);
		dataframe.setVisible(true);

	}

}
