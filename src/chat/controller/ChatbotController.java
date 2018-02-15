package chat.controller;
import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;

/**
 * Manages the Chatbot application including the model and frame of the View package.
 * @author Ryan.Sharp
 * @version 21.11.17 Add Frame 1.2
 */
public class ChatbotController
	{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	
	public ChatbotController()
{
		chatbot = new Chatbot("Ryan Sharp");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	public void start()
	{
	display.displayText("welcome to Chatbot");
	}
	
//	while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//	{
//		response = popupChat(response);
//		response = display.collectResponse(response);
//	}
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		if(chatbot.quitChecker(input))
		{
			close();
		}

		chatbotSays += chatbot.processConversation(input);
		return chatbotSays;
	}
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "";
		}
		//continue with all checkers except length and quit checker
		return response;
	}
	}
