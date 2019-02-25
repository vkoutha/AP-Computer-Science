/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
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
		if (statement.toLowerCase().indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.toLowerCase().indexOf("mother") >= 0
				|| statement.toLowerCase().indexOf("father") >= 0)
		{
			response = "Tell me more about your parents.";
		}else if (statement.toLowerCase().indexOf("abishek") >= 0) {
			response = "Wow, he sounds like a retarded person";
		}else if (statement.toLowerCase().indexOf("cool") >= 0) {
			response = "cool is something that youre not you monkey";
		}else if (statement.toLowerCase().indexOf("brother") >= 0
				 || statement.toLowerCase().indexOf("sister") >= 0) {
			response = "Tell me more about your siblings";
		}else if (statement.toLowerCase().indexOf("dog") >= 0
				 || statement.toLowerCase().indexOf("cat") >= 0) {
			response = "Tell me more about your pets.";
		}else if (statement.toLowerCase().indexOf("Mr.") >= 0
				 || statement.toLowerCase().indexOf("Mrs.") >= 0
				 || statement.toLowerCase().indexOf("Ms.") >= 0) {
			response = "Wow, they sound like a great teacher!";
		}
		else if (statement.trim().length() < 1) {
			response = "Say something, pleaseeeee";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
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
		}else if (whichResponse == 4) {
			response = "That is so interesting, like I want to like poop my pants because its so interesting";
		}else if (whichResponse == 5) {
			response = "You actually suck, everything you say is boring";
		}

		return response;
	}
}