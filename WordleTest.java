import java.io.*;
import java.util.*;
public class WordleTest {
	
	public static void main(String[] args) throws Exception{
		
	File file = new File("C:\\Users\\hsstudent\\Documents\\wordleAnswers.txt");
	ArrayList<String> totNullLetters = new ArrayList<String>();
	Boolean wordNotFound = true;
	
	while(wordNotFound) 
	{
		ArrayList<String> wordList = new ArrayList<String>();
		System.out.println("Pick a word and type it into 'Wordle.'\r\n");
		
		Scanner nullCheck = new Scanner(System.in);
		System.out.println("Accepting letters that aren't in the word of the day... (separate each letter with a space, ex: A E I O U)");
		String nullLetters = nullCheck.nextLine().toLowerCase();
		String[] currNullLetters = nullLetters.split(" ");
		
		for(int i = 0; i < currNullLetters.length; i++)
		{
			totNullLetters.add(currNullLetters[i]);
		}
		
		System.out.println("\r\nThe letter(s) " + nullLetters + " have been removed from the word list.\r\n");
		
		
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
		
		for(int i = 0; i < 5; i++)
		{
			System.out.println(wordList.get(i));
		}
		System.out.print("\r\n");
	}
	}
	
}