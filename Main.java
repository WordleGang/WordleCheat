import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		
		//Creates file object to be used later in the reader.
		File file = new File("WordleCheat\\wordleAnswers.txt");
		
		//Creates a list of words to be transmitted back and forth between the Dictionary class.
		ArrayList<String> wordList = new ArrayList<String>();
		
		Boolean wordFound = false;
		
		Dictionary dict = new Dictionary(null, null, null, null, null);
	
		//Main while loop.
		while(!wordFound) 
		{
			//Scanner to see what letters ARE NOT included in the word.
			Scanner nullCheck = new Scanner(System.in);
			System.out.println("Accepting letters that aren't in the word of the day... (ex: aeiou)");
			String nullLetters = nullCheck.nextLine().toLowerCase();
		
			System.out.println("\r\nThe letter(s) " + nullLetters + " have been removed from the word list.\r\n");
			
			//Scanner to see if there are any yellow letters and what positions they are in.
			Scanner yellowCheck = new Scanner(System.in);
			System.out.println("Accepting yellow letters in the format that README.txt specifies... (if the word you entered was 'raise' and the yellows were r, s, and e, you would type it as r__se.)");
			String yellowLetters = yellowCheck.nextLine().toLowerCase();
			
			//Scanner to see if there are any green letters and what positions they are in.
			Scanner greenCheck = new Scanner(System.in);
			System.out.println("Accepting green letters in the format that README.txt specifies... (if the word you entered was 'table' and the greens were t, e, and l, you would type it as t__le.)");
			String greenLetters = greenCheck.nextLine().toLowerCase();
			
			ArrayList<String> runningNull = dict.totNullLetters;
			String[] runningGreen = dict.totGreenLetters;
			ArrayList<String[]> runningYellow = dict.totYellowLetters;
			
			dict = new Dictionary(file, nullLetters, yellowLetters, greenLetters, wordList);
			dict.confirmLetters(runningNull, runningGreen, runningYellow);
			wordList = dict.makeWordList();
			
			System.out.print("\r\n");
			for(int i = 0; i < wordList.size() && i < 5; i++)
			{
				System.out.println(wordList.get(i));
			}
			System.out.print("\r\n");
			
			System.out.println("Pick a word and type it into 'Wordle.'\r\n");
			
			//Checks to see if user has found word.
			Scanner foundCheck = new Scanner(System.in);
			System.out.println("Was the word you typed in correct? (y/n)");
			String foundResponse = foundCheck.nextLine().toLowerCase();
			if (foundResponse.equals("y"))
			{
				wordFound = true;
			}
		}
	}
}
