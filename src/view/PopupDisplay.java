package view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PopupDisplay
{
/**
 * Simple Gui class using JOptionPane.
 * @author rsha7868
 *@version 1.0 03.10.2017
 */	
	private ImageIcon icon;
	private String windowTitle;


	/**
	 * Display a popup showing the supplied string to the user.
	 * @param textDisplay The text o be displayed.
	 */
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/chatbot.png"));
		windowTitle = "Chatbot says";
	}
	
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	/**
	 * Uses a popup to display a question to the user and returns their response as a String.
	 * @param fromQuestion The question being asked.
	 * @return The users response to the question
	 */
	public String collectResponse(String question)
	{
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		
		return answer;
	}
}
