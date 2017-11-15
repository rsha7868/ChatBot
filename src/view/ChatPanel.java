package view;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import chat.controller.ChatController;
import java.awt.Color;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private JButton chatButton;
	private JTextField inputfield;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	
	public ChatPanel(ChatController appController)
	{
		//Initialize GUI data members
		super();
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		appLayout  = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	public void setupPanel()
	{
		
	}
	public void setupLayout()
	{
		
	}
	public void setupListeners()
	{
		
	}
}
