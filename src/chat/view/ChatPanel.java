package chat.view;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{
	/**
	 * The extend values.
	 */
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	
	public ChatPanel(ChatbotController appController)
	{
		/**
		 * Chatbot's new frame of the GUI setupFrame.
		 */
		//Initialize GUI data members
		super();
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10, 25);
		chatArea.setBackground(Color.WHITE);
		inputField = new JTextField(20);
		appLayout  = new SpringLayout();
		
					
		setupPanel();
		setupLayout();
		setupListeners();
		setupChatFrame();
		
	}
	public void setupPanel()
	{
		this.setBackground(Color.GREEN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	public void setupLayout()
	{
		/**
		 * The are of the 
		 */
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
	}
	public void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
				}
			});
			
	}
	public void setupChatFrame()
	{
		
	}
}