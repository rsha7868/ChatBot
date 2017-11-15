package chat.controller;
import view.ChatFrame;
import chat.model.Chatbot;
import view.PopupDisplay;

public class ChatController
	{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	
	public ChatController()
{
		chatbot = new Chatbot("Ryan Sharp");
		display = new PopupDisplay();
	}
	public void start()
	{
	String response = display.collectResponse("What do you want to talk about?");
	
	while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
	{
		response = popupChat(response);
		response = display.collectResponse(response);
	}
	}
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
}
