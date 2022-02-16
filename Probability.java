import java.util.ArrayList;
import java.util.stream.DoubleStream;
import java.util.*;
import java.lang.Math;

public class Probability extends Dictionary {

  // List of all letters used for comparasion
  char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
      'T',
      'U', 'V', 'W', 'S', 'X', 'Y', 'Z' };

  // The total probability of the word
  double addedProbability;

  // Probability of each letter occuring in the entire list
  double[] probability = { 0.085, 0.024, 0.041, 0.033, 0.116, 0.019, 0.025, 0.033, 0.057, 0.002, 0.018, 0.062,
      0.027,
      0.049, 0.065, 0.032, 0.003, 0.077, 0.057, 0.062, 0.040, 0.013, 0.017, 0.003, 0.037, 0.003 };

  ArrayList<Double> holdingList = new ArrayList<Double>();

  /**
   * Probability Class finds the total probabiliy of a letter occuring in a word
   */
  public Probability() {

  }

  /**
   * Finds the rounded value of decimals
   * 
   * @param num
   * @param decimalpoint
   * @return
   */
  public static double roundDecimal(double num, int decimalpoint) {
    // Use the math power value to cut off decimal place
    num = num * Math.pow(10, decimalpoint);
    num = Math.floor(num);
    num = num / Math.pow(10, decimalpoint);
    return num;
  }

  /**
   * Would find the probabiliy of the word entered
   * 
   * @param input
   */
  public void getProbability(String input) {

    System.out.println("Called");

    char[] charArray = input.toCharArray();
    System.out.println(charArray);
    // ArrayList<String> stringList = new
    // ArrayList<String>(Arrays.asList(stringArray));

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 26; j++) {
        if (charArray[i] == letters[j]) {
          addedProbability += probability[j];
        }
      }
      // addedProbability += probability[i];
      System.out.println(addedProbability);
    }

    System.out.println(addedProbability);
  }

  // roundedAddedProbability = roundDecimal(addedProbability, 4);

  // System.out.println(addedProbability);
  // return addedProbability;

  /**
   * // Turns inputed value into useable array
   * char[] stringArray = input.toCharArray();
   * 
   * // initiaates addedProbability
   * 
   * int letterIndex = 0;
   * 
   * // rounds addedProbability
   * double roundedAddedProbability = 0;
   * 
   * // Runs five times but starts at zero to match with index of stringArray
   * for (int i = 0; i < 5; i++) {
   * 
   * // while (stringArray[i] != letters[letterIndex]) {
   * // if (stringArray[i] == letters[letterIndex]) {
   * 
   * // // holdingList.add(probability[letterIndex]);
   * // }
   * // letterIndex++;
   * 
   * // }
   * 
   * for (char c : stringArray) {
   * if (stringArray[c] == letters[c]) {
   * addedProbability += probability[c];
   * }
   * }
   * // System.out.println(addedProbability);
   * // addedProbability = addedProbability + probability[letterIndex];
   */

}
