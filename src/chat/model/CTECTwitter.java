package chat.model;

import chat.controller.ChatbotController;

import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.twitter;
import twitter4j.Status;



public class CTECTwitter
{
private ChatbotController app Controller;
private Twitter chatbotTwitter;

public CTECTwitter(ChatbotController appController)
	{
	this.appController = app Controller;
	this.chatbotTwitter = TwitterFactory.getSingleton();
	}
}

public void sendTweet(String textToTweet)
{
	
}
