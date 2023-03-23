package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guess {
    private final String word;
    private final String[] endWords;
    private final ArrayList<String> availableWords;

    public Guess(String guess, String[] endWords){
        word = guess;
        this.endWords = endWords;
        availableWords = (ArrayList<String>) Arrays.asList(endWords);
    } // constructor

    /*
    /   This is more of a brute force method to getting data to ensure that it's accurate. I have it running the guess
    /   with each possible result, and then based on the colors returned from the guess, it sorts through the available
    /   words to see which ones are still possible answers
     */

    public void eliminate(){
        for (int i = 0; i < availableWords.size(); i++){
            int[] colors = getColors(word, availableWords.get(i));




        } // sorts through each possible answer
    }

    public static int[] getColors(String guess, String answer){
        int[] colors = new int[5];
        for (int i = 0; i < guess.length(); i++){
            char letter = guess.charAt(i);
            if (answer.charAt(i) == letter){

                int greenUses = 0;
                int greenOccurrences = 0;

                for (int e = 0; e < colors.length; e++){
                    if (colors[e] == 2 && guess.charAt(e) == letter) greenUses++; // get # of yellows with that letter already set
                    if (answer.charAt(e) == letter) greenOccurrences++; // get amount of that letter within answer
                }

                if (greenUses < greenOccurrences) colors[i] = 3;
                else colors[i] = 1;
            }

            /*
            /   if answer contains the guess, search the amount of times that letter has already been used in colors.
            /   if the amount of uses is < the amount of occurrences in answer then set as yellow
             */
            else if (answer.contains("" + letter)){
                int yellowUses = 0;
                int yellowOccurrences = 0;
                for (int e = 0; e < colors.length; e++){
                    if (colors[e] == 2 && guess.charAt(e) == letter) yellowUses++; // get # of yellows with that letter already set
                    if (answer.charAt(e) == letter) yellowOccurrences++; // get amount of that letter within answer
                }
                if (yellowUses < yellowOccurrences) colors[i] = 2;
                else colors[i] = 1;
            } // checks if yellow
            else colors[i] = 1;
        } // sorts through each character of guess to get a color
        return colors;
    } // returns the simulated Wordle colors with the specified guess and answer 1 represents green, 2 yellow, 3 gray



    private double getPercentRemoved(){
        return 100 * ((double)(endWords.length - availableWords.size())/endWords.length);
    }


}
