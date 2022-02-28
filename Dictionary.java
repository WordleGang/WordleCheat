import java.io.*;
import java.util.*;

public class Dictionary {
  
  // Wordle answers file to be used in the BufferedReader later on.
  private File answers;

  // ArrayList of strings to hold all letters that have been found to not be a
  // part of the word.
  private ArrayList<String> totNullLetters;

  // Array to hold all green letters that have been found in order.
  private String[] totGreenLetters;
	
  // ArrayList of arrays of strings to hold all instances of letters that are in
  // the word but in the wrong place.
  private ArrayList<String[]> totYellowLetters;

  // ArrayList of strings that holds all the words that the target word could be.
  public ArrayList<String> wordList;

  // Boolean to let the program know whether or not a green letter has been found.
  private Boolean greenFound = false;
  
  //Constructor for the dictionary class.
  public Dictionary(File f, ArrayList<String> nl, String[] gl, ArrayList<String[]> yl, ArrayList<String> wl){
  	this.answers = f;
	this.totNullLetters = nl;
	this.totGreenLetters = gl;
	this.totYellowLetters = yl;
	this.wordList = wl;
  }

  // Method to be used by the Main class after receiving input from the user
  // regarding the different types of letters.
  public void confirmLetters(String nullLetters, String yellowLetters, String greenLetters) {
    String[] currNullLetters = nullLetters.split("");
    for (int i = 0; i < currNullLetters.length; i++) {
      totNullLetters.add(currNullLetters[i]);
    }

    String[] currYellowLetters = yellowLetters.split("");
    totYellowLetters.add(currYellowLetters);

    String[] currGreenLetters = greenLetters.split("");
    for (int i = 0; i < currGreenLetters.length; i++) {
      if (!currGreenLetters[i].equals("_") & !currGreenLetters[i].equals(null) & !currGreenLetters[i].equals("")) {
        this.greenFound = true;
        totGreenLetters[i] = currGreenLetters[i];
      }
    }
  }

  // Method to be used after confirming all information with the user. Goes
  // through the previously established answers File variable and removes words
  // that do not fit the criteria.
  public ArrayList<String> makeWordList() {
    wordList = new ArrayList<String>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(answers));
      String line = reader.readLine();
      while (line != null) {
        Boolean goodWord = true;
        String[] lineLetters = line.split("");

        // Null letters.
        for (int i = 0; i < totNullLetters.size(); i++) {
          if (line.contains(totNullLetters.get(i))) {
            goodWord = false;
          }
        }

        //Yellow letters.
	if (goodWord){
		for (int i = 0; i < totYellowLetters.size(); i++){
			String[] yellowTest = totYellowLetters.get(i);
			for (int k = 0; k < yellowTest.length; k++){
				if (!yellowTest[k].equals("_") & yellowTest[k].equals(lineLetters[k]))
				{
					goodWord = false;
				}
				if (!line.contains(yellowTest[k]) & !yellowTest[k].equals("_"))
				{
					goodWord = false;
				}
			}
		}
	}

        // Green letters.
        if (greenFound & goodWord) {
          for (int i = 0; i < lineLetters.length; i++) {
            if (!totGreenLetters[i].equals("") & !lineLetters[i].equals(totGreenLetters[i])) {
              goodWord = false;
            }
          }
        }

        // Adds words that pass all tests to the wordList.
        if (goodWord) {
          wordList.add(line);
        }
        line = reader.readLine();
      }
      reader.close();
    } catch (Exception e) {
      System.out.print("Exception in Dictionary class: " + e);
    }
    return wordList;
  }
}
