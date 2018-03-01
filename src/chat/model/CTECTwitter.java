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
		totalWordCount = tweetedWords.size();
		String [] boring = createIgnoredWordArray();
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
					if(current.getId() < lastID)
					{
						searchTweets.add(current);
						lastID = current.getId();
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
	private void turnStatusesToWords()
	{
		for(Status currentStatus : searchTweets)
		{
			String tweetText = currentStatus.getText();
			String [] tweetWords = tweetText.split(" ");
			for(int index = 0; index < tweetedWords.length;index++)
			{
				tweetedWords.add(removePunctuation(tweetWords[index]).trim());
			}
		}
	}
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"() {}^[]<>-";
		
		String scrubbedString = "";
		for(int i=0; i < currentString.length();i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	private String [] createIgnoredWordArray()
	{
		String [] boringWords;
		String fileText= IOController.loadFromFile(appController, "commonWords.txt");
		int wordCount = 0;
		
		Scanner wordScanner = new Scanner(fileText);
		
		while(wordScanner.hasNextLine())
		{
			wordScanner.nextLine();
			wordCount++;
		}
		
		boringWords = new String [wordCount];
		wordScanner.close();
		
		// Alternative File loading method.
		// Uses the InputStream class
		// Notice the lack of try/catch
		
		wordScanner = new Scanner(this.getClass().getResourceAsStream("data/commonWords.txt"));
		for(int index = 0; index < boringWords.length; index++)
		{
			boringWords[index] = wordScanner.nextLine();
		}
		
		wordScanner.close();
		return boringWords;
	}
}
