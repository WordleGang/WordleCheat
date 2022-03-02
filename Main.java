
/**
 * TODO: Import Chris' dictionary class and Justin's probability class
 */
import java.io.File;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    File answers = new File("/Users/rush/Desktop/WordleHelper/wordleAnswers.txt");

    String nullLetters;
    String yellowLetters;
    String greenLetters;

    ArrayList<String> wordList = new ArrayList<String>();

    try (Scanner myScanner = new Scanner(System.in)) {
      System.out.print("\r\nAccepting letters that aren't in the word of the day... (ex: aeiou): ");

      nullLetters = myScanner.nextLine().toLowerCase();

      ArrayList<String> arrs = new ArrayList<>();
      arrs.add("AAAAA");
      arrs.add("EEEEE");

      String[] arr = { "AAAAA", "EEEEE", "JJJJJ" };

      yellowLetters = myScanner.nextLine().toLowerCase();

      // System.out.println("dog");
      Probability prob = new Probability();
      // prob.getProbability("AAAAA");
      // prob.getProbability("EEEEE");
      // prob.getProbability("ROUND");
      // prob.getProbability("YYYYY");
      // prob.getProbability("ZZZZZ");
      System.out.println(prob.makeList(arrs));

      greenLetters = myScanner.nextLine().toLowerCase();

    }

    Dictionary cheater = new Dictionary(answers, nullLetters, yellowLetters, greenLetters, wordList);

    cheater.confirmLetters();
    System.out.println(cheater.makeWordList());
  }

}
