import java.util.Scanner;

public class Main {
  public static void main(String args[]) {

    // System.out.println("Welcome to the Wordle game enter in the letters");
    // System.out.print("Input: ");

    // Scanner sc = new Scanner(System.in);
    // String input = sc.nextLine();

    // Probability p = new Probability();

    // System.out.println("Input: " + input);

    System.out.println("dog");
    Probability prob = new Probability();
    prob.getProbability("AAAAA");
    prob.getProbability("EEEEE");
    prob.getProbability("ROUND");
    prob.getProbability("YYYY");

  }
}