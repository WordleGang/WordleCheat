import java.io.*;
import java.util.*;

public class Dictionary{
	
	//Wordle answers file to be used in the BufferedReader later on.
	private File answers;

	//ArrayList of strings to hold all letters that have been found to not be a part of the word.
	public ArrayList<String> totNullLetters = new ArrayList<String>();
	
	public String nullLetters;

	//Array to hold all green letters that have been found in order.
	public String[] totGreenLetters = new String[]{"", "", "", "", ""};
	
	public String greenLetters;

	//ArrayList of arrays of strings to hold all instances of letters that are in the word but in the wrong place.
	public ArrayList<String[]> totYellowLetters = new ArrayList<String[]>();
	
	public String yellowLetters;

	//ArrayList of strings that holds all the words that the target word could be.
	public ArrayList<String> wordList;

	//Boolean to let the program know whether or not a green letter has been found.
	private Boolean greenFound = false;

	//Constructor for Dictionary class.
	public Dictionary(File f, String nl, String yl, String gl, ArrayList<String> wl){
		this.answers = f;
		this.nullLetters = nl;
		this.yellowLetters = yl;
		this.greenLetters = gl;
		this.wordList = wl;
  	}
	
	//Method to be used by the Main class after receiving input from the user regarding the different types of letters.
	public void confirmLetters(ArrayList<String> nl, String[] gl, ArrayList<String[]> yl)
	{
		totNullLetters = nl;
		String[] currNullLetters = nullLetters.split("");
		for (int i = 0; i < currNullLetters.length; i++)
		{
			totNullLetters.add(currNullLetters[i]);
		}
		
		totYellowLetters = yl;
		String[] currYellowLetters = yellowLetters.split("");
		totYellowLetters.add(currYellowLetters);

		totGreenLetters = gl;
		String[] currGreenLetters = greenLetters.split("");			
		for (int i = 0; i < currGreenLetters.length; i++)
		{
			if (!currGreenLetters[i].equals("_") & !currGreenLetters[i].equals(null) & !currGreenLetters[i].equals("")) 
			{
				greenFound = true;
				totGreenLetters[i] = currGreenLetters[i];
			}
		}
	}

	//Method to be used after confirming all information with the user. Goes through the previously established answers File variable and removes words that do not fit the criteria.
	public ArrayList<String> makeWordList()
	{
		ArrayList<String> tempWordList = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(answers));
			String line = reader.readLine();
			while(line!=null)
			{
				Boolean goodWord = true;				
				String[] lineLetters = line.split("");
				
				//Null letters.
				for (int i = 0; i < totNullLetters.size(); i++) 
				{
					if (line.contains(totNullLetters.get(i))) 
					{
						goodWord = false;
					}
				}
				
				//Yellow letters.
				if (goodWord)
				{
					for (int i = 0; i < totYellowLetters.size(); i++)
					{
						String[] yellowTest = totYellowLetters.get(i);
						for (int k = 0; k < yellowTest.length; k++)
						{
							if (!yellowTest[k].equals("_"))
							{
								if (line.contains(yellowTest[k]) & !yellowTest[k].equals(lineLetters[k]))
								{
									
								} else
								{
									goodWord = false;
								}
							}
						}
					}
				}
				
				//Green letters.
				if (greenFound & goodWord)
				{
					for (int i = 0; i < lineLetters.length; i++)
					{
						if (!totGreenLetters[i].equals("") & !lineLetters[i].equals(totGreenLetters[i]))
						{
							goodWord = false;
						}
					}
				}
				
				//Adds words that pass all tests to the wordList.
				if (goodWord) 
				{
					tempWordList.add(line);
				}
				line = reader.readLine();
			}
			reader.close();
			wordList = tempWordList;
		}
		catch (Exception e) 
		{
			System.out.print("Exception in Dictionary class: " + e);
		}
			return wordList;
		}
}
