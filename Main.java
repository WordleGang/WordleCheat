/**
 * TODO: Import Chris' dictionary class and Justin's probability class
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.Dictionary;

public class Main 
{
    public static void main(String[] args)
    {
        try (Scanner myScanner = new Scanner(System.in)) 
        {
            System.out.print("Please enter in the letters that are not in the word (The letters that are grayed out): ");

            String nullLetters = myScanner.nextLine().toLowerCase();

            String[] grayLetters = nullLetters.split("(?!^)");

            System.out.println(Arrays.toString(grayLetters));

            System.out.println("Accepting yellow letters in the format that README.txt specifies... (if the word you entered was 'raise' and the yellows were r, s, and e, you would type it as r__se.)");

            String yelLetters = myScanner.nextLine().toLowerCase();

            String [] yellowLetters = yelLetters.split("(?!^)");

            System.out.println(Arrays.toString(yellowLetters));

            System.out.print("Please enter in the letters that are in the word and in the correct spot (The letters that are highlighted green): ");

            String grnLetters = myScanner.nextLine().toLowerCase();

            String [] greenLetters = grnLetters.split("(?!^)");

            System.out.println(Arrays.toString(greenLetters));
        }
    }

}
