import java.util.ArrayList;
import java.util.stream.DoubleStream;
import java.util.*;
import java.lang.Math;

public class Probability {

  // List of all letters used for comparasion
  char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
      'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

  // The total probability of the word
  double addedProbability;

  // Probability of each letter occuring in the entire list
  double[] probability = { 0.085, 0.024, 0.041, 0.033, 0.116, 0.019, 0.025, 0.033, 0.057, 0.002, 0.018, 0.062,
      0.027,
      0.049, 0.065, 0.032, 0.003, 0.077, 0.057, 0.062, 0.040, 0.013, 0.017, 0.003, 0.037, 0.003, 0.034 };

  ArrayList<Double> holdingList = new ArrayList<Double>();

  public double roundedAddedProbability;

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

  public Map<String, Double> makeList(String[] wordList) {

    // ArrayList<Double> probabilityList = new ArrayList<Double>();
    HashMap<String, Double> totalArr = new HashMap<>();
    String word;
    double wordProbability;
    for (int i = 0; i < wordList.length; i++) {
      word = wordList[i];
      wordProbability = getProbability(wordList[i]);
      totalArr.put(word, wordProbability);
    }

    Map<String, Double> sortedMap = hashMapSorter(totalArr);
    // Collections.sort(probabilityList);

    // return probabilityList;

    return sortedMap;
  }

  public HashMap<String, Double> hashMapSorter(HashMap<String, Double> hm) {
    List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(hm.entrySet());

    // Sort the list
    Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
      public int compare(Map.Entry<String, Double> o1,
          Map.Entry<String, Double> o2) {
        return (o1.getValue()).compareTo(o2.getValue());
      }
    });

    // put data from sorted list to hashmap
    HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
    for (Map.Entry<String, Double> aa : list) {
      temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
  }

  /**
   * Would find the probabiliy of the word entered
   * 
   * @param input
   */
  public double getProbability(String input) {

    // System.out.println("Called");
    addedProbability = 0;

    char[] charArray = input.toCharArray();
    // System.out.println(charArray);
    // ArrayList<String> stringList = new
    // ArrayList<String>(Arrays.asList(stringArray));

    int letterIndex = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < letters.length; j++) {
        if (charArray[i] == letters[j]) {
          addedProbability += probability[j];
        }
      }

      // System.out.println(addedProbability);
    }

    // for (int i = 0; i < 4; i++) {

    // for (int e : letters) {
    // if (e == charArray[i]) {
    // addedProbability += probability[e];
    // System.out.println(addedProbability);
    // }
    // }
    // }

    roundedAddedProbability = roundDecimal(addedProbability, 4);
    System.out.println(roundedAddedProbability);
    return roundedAddedProbability;
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
