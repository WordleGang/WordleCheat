/**
 * TODO: Import Chris' dictionary class and Justin's probability class
 */
import java.io.File;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        File answers = new File("/Users/rush/Desktop/WordleHelper/wordleAnswers.txt");

        String nullLetters;
        String yellowLetters;
        String greenLetters;
        
        ArrayList<String> wordList = new ArrayList<String>();

        try (Scanner myScanner = new Scanner(System.in)) 
        {
            System.out.print("\r\nAccepting letters that aren't in the word of the day... (ex: aeiou): ");

            nullLetters = myScanner.nextLine().toLowerCase();

            System.out.println("Accepting yellow letters in the format that README.txt specifies... (if the word you entered was 'raise' and the yellows were r, s, and e, you would type it as r__se.): ");

            yellowLetters = myScanner.nextLine().toLowerCase();

            System.out.print("Accepting green letters in the format that README.txt specifies... (if the word you entered was 'table' and the greens were t, e, and l, you would type it as t__le.): ");

            greenLetters = myScanner.nextLine().toLowerCase();

        }


        Dictionary cheater = new Dictionary(answers, nullLetters, yellowLetters, greenLetters, wordList);

        cheater.confirmLetters();
        System.out.println(cheater.makeWordList());
    }

}
