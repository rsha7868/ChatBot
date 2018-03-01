package chat.model;
//import chat.controller.IOController;
import chat.controller.ChatbotController;


import twitter4j.*;

import java.util.*;
import java.text.DecimalFormat;


public class CTECTwitter
{
private ChatbotController appController;
private Twitter chatbotTwitter;
private List<Status> searchTweets;
private List<String> tweetedWords;
private long totalWordCount;

public CTECTwitter(ChatbotController appController)
	{
	this.appController = appController;
	this.chatbotTwitter = TwitterFactory.getSingleton();
	this.tweetedWords = new ArrayList<String>();
	this.searchTweets = new ArrayList<String>();
	this.totalWordCount = 0;
	}


	public void sendTweet(String textToTweet)
	{
	try
		{
		chatbotTwitter.updateStatus(textToTweet + "@ChatbotCTEC");
		}
	catch(TwitterException tweetError)
		{
		appController.handleErrors(tweetError);
		}
	catch(Exception otherError)
		{
			appController.handleErrors(otherError);
		}
	}
	public String getMostCommonWord(String username)
	{
		String mostCommon = "";
		
		collectTweets(username);
		turnStatusesToWords();
		
		return mostCommon;
	}
	private void collectTweets(String username)
	{
		searchTweets.clear();
		tweetedWords.clear();
		
		Paging statusPage = new Paging(1,100);
		int page = 1;
		long lastID = Long.MAX_VALUE;
		
		while(page <= 10)
		{
			statusPage.setPage(page);
			try
			{
				ResponseList<Status> listedTweets = chatbotTwitter.getUserTimeline(username, statusPage);
				for(Status current : listedTweets)
				{
					if(current.getID() < lastID)
					{
						searchTweets.add(current);
						lastID = current.getID();
					}
				}
			}
			catch(TwitterException searchTweetError)
			{
				appController.handleErrors(searchTweetError);
			}
			page++;
		}
	}
	
}
