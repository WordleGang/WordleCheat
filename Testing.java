import java.util.Scanner;

public class Testing {
  static char[] lettersT = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
      'S', 'T',
      'U', 'V', 'W', 'S', 'X', 'Y', 'Z' };

  // The total probability of the word

  static double addedProbability = 0;
  // Probability of each letter occuring in the entire list
  static double[] probabilityT = { 0.085, 0.024, 0.041, 0.033, 0.116, 0.019, 0.025, 0.033, 0.057, 0.002, 0.018, 0.062,
      0.027,
      0.049, 0.065, 0.032, 0.003, 0.077, 0.057, 0.062, 0.040, 0.013, 0.017, 0.003, 0.037, 0.003 };

  public static void main(String args[]) {
    testing('I');

  }

  public static double testing(char input) {
    // char[] stringArray = input.toCharArray();
    for (char i : lettersT) {
      if (input == lettersT[i]) {
        addedProbability += probabilityT[i];
      }
    }

    System.out.println(addedProbability);
    return addedProbability;
  }
}