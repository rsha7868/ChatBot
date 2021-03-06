package chat.view;
import javax.swing.*;

import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChatPanel extends JPanel
{
	/**
	 * The extend values.
	 */
	private JButton loadButton; 
	private JButton saveButton;
	private JButton tweetButton;
	private JButton searchButton;
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	
	public ChatPanel(ChatbotController appController)
	{
		/**
		 * Chatbot's new frame of the GUI setupFrame.
		 */
		//Initialize GUI data members
		super();
		
		chatButton = new JButton("chat", new ImageIcon(getClass().getResource("/chat/view/images/Chat.png")));
		loadButton = new JButton("chat", new ImageIcon(getClass().getResource("/chat/view/images/Load.png")));
		saveButton = new JButton("chat", new ImageIcon(getClass().getResource("/chat/view/images/Save.png")));
		tweetButton = new JButton("chat", new ImageIcon(getClass().getResource("/chat/view/images/Tweet.png")));
		searchButton = new JButton("chat", new ImageIcon(getClass().getResource("/chat/view/images/Search.png")));
		chatArea = new JTextArea(10, 25);
		chatArea.setBackground(Color.WHITE);
		inputField = new JTextField(20);
		appLayout  = new SpringLayout();
		infoLabel = new JLabel("Type to chat with chatbot");
		chatScrollPane = new JScrollPane();
		checkerButton = new JButton("Check contents");
					
		setupPanel();
		setupLayout();
		setupListeners();
		setupChatFrame();
		setupScrollPane();
	}
	/**
	 * Setup Panel for what the design is
	 */
	public void setupPanel()
	{
		this.setBackground(Color.GREEN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		this.add(infoLabel);
		this.add(chatScrollPane);
	}
	private void setupLayout()
	{
		/**
		 * They are the code to put the area of the panel in the design... 
		 */
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, inputField);
	}
	/**
	 * this is where the bot talks to us in the listener tools...
	 */
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
		
		checkerButton.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent click)
				{
					String userText = inputField.getText();
					String displayText = appController.useCheckers(userText);
							chatArea.append(displayText);
					inputField.setText("");
				}
			});
			
	}
	/**
	 * The framework of the panel 
	 * */
	public void setupChatFrame()
	{
		
	}
	/**
	 * To scroll the data up and down in the view text box.
	 */
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(false);
	}
	
}
