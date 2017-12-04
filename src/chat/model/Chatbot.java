package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String [3];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.topics = new String [3];
		this.verbs = new String [4];
		this.followUps = null;
	
	buildVerbs();
	buildShoppingList();
	buildMovieList();
	buildQuestions();
	buildTopics();
	buildChatbotResponse();
	buildcuteAnimalMemes();
	}
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	private void buildMovieList()
	{
		movieList.add(new Movie(""));
		movieList.add(new Movie(""));
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
	}
	private void buildTopics()
	{
		topics[0] = ("dogs");
		topics[1] = ("people");
		topics[2] = ("aliens");
	}
	
	private void buildcuteAnimalMemes()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
	}
	
	private void buildQuestions()
	{
		questions[0] = ("Who are you?");
		questions[1] = ("Who are people?");
		questions[2] = ("Do you hate Cats?");
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		return chatbotResponse;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if(input != null)
		{
			if(input.length() > 3)
			{
				validLength = true;		
			}
		}
		
		return validLength;
	}
	
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += "" + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
		
			if (random % 2 == 0)
			{
				random = (int) (Math.random() * shoppingList.size());
				response += "\n" + shoppingList.get(random) + " is great food!";
			}
			int followup = (int) (Math.random() * 5);
			
			switch (followup)
			{
			case 0:
				response += followUps[0] + "\n";
				break;
			case 3:
				response += followUps[1] + "\n";
			case 1:
				response += followUps[2] + "\n";
				break;
				default:
					response += followUps[3] + "\n";
					response += followUps[4] + "\n";
			}
		
		
		return response;
	}
	
	
	
	
//	public boolean htmlTagChecker(String input)
//	{
//		
//		boolean containsHTML = false;
//		if(input == null || !input.contains("<"))
//		{
//			return containsHTML
//		}
//	}
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		for(int index = 0; index < cuteAnimalMemes.size(); index++)
		{
			if(cuteAnimalMemes.contains(cuteAnimalMemes.get(index))
					{
						return true;
					}
			else if()
			return false;
		}
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
//		if (shoppingList.contains(shoppingItem))
//		{
//			return true;
//		}
//		else
//		{
//		return false;	
//		}
		//the data of this file shows how the shopping list checks the data...From the begginging and the end. From one list to a anouther.
		for (int index = 0; 1 < shoppingList.size(); index++)
		{
			if (shoppingItem.contains(shoppingList.get(index)))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		if (title.contains("Spiderman"))
		{
			return true;
		}
		else if (title.contains("Hidden Figures"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

	public boolean keyboardMashChecker(String input)
	{
		
		if (input.contains("sdf"))
		{
			return true;
		}
		else if (input.contains("SDF"))
		{
			return true;
		}
		else if (input.contains("dfg"))
		{
			return true;
		}
		else if (input.contains("cvb"))
		{
			return true;
		}
		else if (input.contains(",./"))
		{
			return true;
		}
		else if (input.contains("kjh"))
		{
			return true;
		}
		else if (input.contains("DFG"))
		{
			return true;
		}
		else if (input.contains("CVB"))
		{
			return true;
		}
		else if (input.contains("KJH"))
		{
			return true;
		}
		return false;
	}
	
	//public List<Movie> getMovieList()
	//{
		//return movieList;
	//}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return null;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
