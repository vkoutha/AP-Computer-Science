/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 * 		Uses advanced search for keywords 
 *</li><li>
 * 		Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */
public class Magpie4
{
	
	private String[] likes = new String[4], dislikes = new String[4];
	String favoriteShow, favoriteColor, favoriteMovie, favoriteSportTeam, favoriteClass;
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	
	public String getLikes() {
		String giantLike = "";
		
		for(int i = 0; i < likes.length && likes[i] != null; i++) {
			if (i < likes.length-1 && likes[i+1] != null) {
				giantLike += likes[i] + (i == likes.length-2 ? ", and " : ",");
			}else
				giantLike+=likes[i];
		}
		
		if(likes[0] == null)
			 return "you like nothing because ur stupid";

		return giantLike;
	}
	
	public String getDislikes() {
		String giantDislike = "";
		for(int i = 0; i < dislikes.length && dislikes[i] != null; i++) {
			if (i < dislikes.length-1 && dislikes[i+1] != null) {
				giantDislike += dislikes[i] + (i == dislikes.length-2 ? ", and " : ",");
			}else
				giantDislike+=dislikes[i];
		}
		
		if(dislikes[0] == null)
			 return "you like nothing because ur stupid";
		
		return giantDislike;
	}
	
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.trim().length() == 0)
		{
			response = "Say something, please.";
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Tell me more about your family.";
			
		}else if (findKeyword(statement, "My favorite TV show is") >= 0) {
			favoriteShow = statement.substring("My favorite TV Show is".length()+1);
			response = "I really don't care";
		}else if (findKeyword(statement, "What is my favorite TV show") >= 0 && favoriteShow != null) {
			response = "Your favorite TV show is " + favoriteShow;
			
		}else if (findKeyword(statement, "My favorite color is") >= 0) {
			favoriteShow = statement.substring("My favorite color is".length()+1);
			response = "I really don't care";
		}else if (findKeyword(statement, "What is my favorite color") >= 0 && favoriteColor != null) {
			response = "Your favorite color is " + favoriteColor;
			
		}else if (findKeyword(statement, "My favorite movie is") >= 0) {
			favoriteShow = statement.substring("My favorite movie is".length()+1);
			response = "I really don't care";
		}else if (findKeyword(statement, "What is my favorite color") >= 0 && favoriteMovie!= null) {
			response = "Your favorite movie is " + favoriteMovie;
			
		}else if (findKeyword(statement, "My favorite class is") >= 0) {
			favoriteShow = statement.substring("My favorite class is".length()+1);
			response = "I really don't care";
		}else if (findKeyword(statement, "What is my favorite class") >= 0 && favoriteClass != null) {
			response = "Your favorite class is " + favoriteClass;
			
		}else if (findKeyword(statement, "My favorite sports team is") >= 0) {
			favoriteShow = statement.substring("My favorite sports team is".length()+1);
			response = "I really don't care";
		}else if (findKeyword(statement, "What is my favorite sports team is") >= 0 && favoriteSportTeam != null) {
			response = "Your favorite sports team is " + favoriteSportTeam;
			
		}else if (findKeyword(statement, "What do I like") >= 0) {
			response = getLikes();
		}else if (findKeyword(statement, "What do I dislike") >= 0) {
			response = getDislikes();
		}else if (findKeyword(statement, "I like") >= 0) {
			for(int i = 0; i < likes.length; i++) 
				if (likes[i] == null) { 
					likes[i] = statement.substring("I like".length()+1);
					break;
				}
			response = "what a crappy thing to like";
		
		}else if (findKeyword(statement, "I dont like") >= 0 || findKeyword(statement, "I don't like") >= 0) {
			for(int i = 0; i < dislikes.length; i++) 
			if (dislikes[i] == null)
				if (findKeyword(statement, "I dont like") >= 0) {
					dislikes[i] = statement.substring("I dont like".length()+1);
					break;
				}else if (findKeyword(statement, "I don't like") >= 0) {
					dislikes[i] = statement.substring("I don't like".length()+1);
					break;
				}
			response = "What a crappy thing to dislike";
		}
// Responses which require transformations
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement.toLowerCase());
			for(int i = 0; i < likes.length; i++) 
				if (likes[i] != null) 
					likes[i] = statement.substring("I want to".length());
				
		}else if (findKeyword(statement, "I want", 0) >= 0) {
			response = "Would you really be happy if you had" + statement.substring("I want".length());
			for(int i = 0; i < likes.length; i++) 
				if (likes[i] != null) 
					likes[i] = statement.substring("I want".length());
		}else
		{
			// Look for a two word (you <something> me)
			// pattern
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0
					&& findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
			}
			else if(psn>=0 && findKeyword(statement, "i", 0) >= 0)
			{
				response = transformIYouStatement(statement);
			}else {
				response = getRandomResponse();
			}
		}

		return response;
	}

	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "What would it mean to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword(statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}



	/**
	 * Take a statement with "you <something> me" and transform it into 
	 * "What makes you think that I <something> you?"
	 * @param statement the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement)
	{
		System.out.println("you me statement");
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}

		int psnOfYou = findKeyword (statement, "you", 0);
		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);

		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}
	
	private String transformIYouStatement(String statement) {
	//  Remove the final period, if there is one
			statement = statement.trim();
			String lastChar = statement.substring(statement
					.length() - 1);
			if (lastChar.equals("."))
			{
				statement = statement.substring(0, statement
						.length() - 1);
			}

			int psnOfYou = findKeyword (statement, "i", 0);
			int psnOfMe = findKeyword (statement, "you", psnOfYou + 3);

			String restOfStatement = statement.substring(psnOfYou + 2, psnOfMe).trim();
	//		return "What makes you think that I " + restOfStatement + " you?";
			return "Why do you " + restOfStatement + " me";
	}





	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @param startPos the character of the string to begin the search at
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim();
		//  The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		//  Refinement--make sure the goal isn't part of a word 
		while (psn >= 0) 
		{
			//  Find the string of length 1 before and after the word
			String before = " ", after = " "; 
			if (psn > 0)
			{
				before = phrase.substring (psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}

			//  If before and after aren't letters, we've found the word
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
					&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
			{
				return psn;
			}

			//  The last position didn't work, so let's find the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

		}

		return -1;
	}

	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement.toLowerCase(), goal, 0);
	}



	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}

		return response;
	}

}