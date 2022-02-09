import java.io.*;
import java.util.*;
public class WordleTest {
	
	public static void main(String[] args) throws Exception{
	
	//Creates file to be used later in the reader.
	File file = new File("C:\\Users\\hsstudent\\Documents\\wordleAnswers.txt");
	
	//List of strings to hold all letters that are not in the word.
	ArrayList<String> totNullLetters = new ArrayList<String>();
	
	//Exit case for main while loop.
	Boolean wordNotFound = true;
		
		//Main while loop.
		while(wordNotFound) 
		{
			//Creates list of words to be temporarily used and changed depending on the data that the user gives the program.
			ArrayList<String> wordList = new ArrayList<String>();
			System.out.println("Pick a word and type it into 'Wordle.'\r\n");
		
			//Scanner to see what letters ARE NOT included in the word.
			Scanner nullCheck = new Scanner(System.in);
			System.out.println("Accepting letters that aren't in the word of the day... (separate each letter with a space, ex: a e i o u)");
			String nullLetters = nullCheck.nextLine().toLowerCase();
			String[] currNullLetters = nullLetters.split(" ");
		
			for(int i = 0; i < currNullLetters.length; i++)
			{
			totNullLetters.add(currNullLetters[i]);
			}
		
			System.out.println("\r\nThe letter(s) " + nullLetters + " have been removed from the word list.\r\n");
			
			//Scanner to see what letters ARE included in the word.
			
			//Scanner to see if there are any green letters and what positions they are in.
			Scanner greenCheck = new Scanner(System.in);
			System.out.println("Accepting green letters in the format that README.txt specifies... (if the word you entered was 'table' and the greens were t, e, and l, you would type it as t _ _ l e.)");
			String greenLetters = greenCheck.nextLine().toLowerCase();
			String[] currGreenLetters = greenLetters.split(" ");
			
			//Reader reads through the entire word list and removes words that have null letters.
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while(line!=null)
			{
				Boolean goodWord = true;
				for (int i = 0; i < totNullLetters.size(); i++) 
				{
					if (line.contains(totNullLetters.get(i))) 
					{
						goodWord = false;
					}
				}
				if (goodWord) 
				{
				wordList.add(line);
				}
				line = reader.readLine();
			}
			reader.close();
			
			//Prints out 5 words for the user to choose from for the next iteration.
			for(int i = 0; i < 5; i++)
			{
				System.out.println(wordList.get(i));
			}
			System.out.print("\r\n");
		}
	}	
}
