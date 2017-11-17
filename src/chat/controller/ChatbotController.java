package chat.controller;
import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;

public class ChatbotController
	{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	
	public ChatbotController()
{
		chatbot = new Chatbot("Ryan Sharp");
		display = new PopupDisplay();
	}
	public void start()
	{
	display.displayText("welcome to Chatbot");
	
	
//	while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//	{
//		response = popupChat(response);
//		response = display.collectResponse(response);
//	}
	}
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	public interactWithChatbot(String input)
	{
		String chatbotSays = "";
		chatbotSays.processConversion(input)
		return chatbotSays
	}
}
