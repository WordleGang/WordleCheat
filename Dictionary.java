import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		
		//Creates file object to be used later in the reader.
		File file = new File("C:\\Users\\hsstudent\\eclipse-workspace\\Wordle Test\\src\\wordleAnswers.txt");
		
		//Creates a list of words to be transmitted back and forth between the Dictionary class.
		ArrayList<String> wordList = new ArrayList<String>();
		
		Boolean wordFound = false;
		
		Dictionary dict = new Dictionary(null, null, null, null, null, null);
		
		ArrayList<String> guessList = new ArrayList<String>();
	
		//Main while loop.
		while(!wordFound) 
		{
				Scanner guessCheck = new Scanner(System.in);
				
				System.out.println("Type in the word that you guessed.");
				guessList.add(guessCheck.nextLine().toLowerCase());
				
				//Scanner to see what letters ARE NOT included in the word.
				System.out.println("Accepting letters that aren't in the word of the day... (ex: aeiou, do NOT type letters that have already appeared as another color)");
				String nullLetters = guessCheck.nextLine().toLowerCase();
				if (!nullLetters.equals(""))
				{
					System.out.println(" ");
				}
			
				System.out.println("The letter(s) " + nullLetters + " have been removed from the word list.\r\n");
				
				//Scanner to see if there are any yellow letters and what positions they are in.
				System.out.println("Accepting yellow letters in the format that README.txt specifies... (if the word you entered was 'raise' and the yellows were r, s, and e, you would type it as r__se.)");
				String yellowLetters = guessCheck.nextLine().toLowerCase();
				if (!yellowLetters.equals(""))
				{
					System.out.println(" ");
				}
				
				//Scanner to see if there are any green letters and what positions they are in.
				System.out.println("Accepting green letters in the format that README.txt specifies... (if the word you entered was 'table' and the greens were t, e, and l, you would type it as t__le.)");
				String greenLetters = guessCheck.nextLine().toLowerCase();
				if (!greenLetters.equals(""))
				{
					System.out.println(" ");
				}
				
				ArrayList<String> runningNull = dict.totNullLetters;
				String[] runningGreen = dict.totGreenLetters;
				ArrayList<String[]> runningYellow = dict.totYellowLetters;
				Boolean greenFound = dict.greenFound;

				dict = new Dictionary(file, nullLetters, yellowLetters, greenLetters, wordList, greenFound);
				dict.confirmLetters(runningNull, runningGreen, runningYellow);
				wordList = dict.makeWordList(guessList);
				
				System.out.println("-----------\r\n");
				
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
				System.out.println(" ");
			}
	}
}
