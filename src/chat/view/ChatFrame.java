package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;



public class ChatFrame extends JFrame
{
	/**
	 * Show the private types in extends MainFrame.
	 */
	private ChatbotController appController;
	private ChatPanel appPanel;
	
	public ChatFrame(ChatbotController appController)
	{
		/**
		 * Always start with a super(); Command in appController.
		 */
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		setupFrame();
	}
	private void setupFrame()
	{
		/**
		 * Content of the frame and size of the panel.
		 */
		this.setContentPane(appPanel);
		this.setTitle("Chatting with the chatbot");
		this.setResizable(false);
		this.setSize(600, 600);
		this.setVisible(true);
	}
}
