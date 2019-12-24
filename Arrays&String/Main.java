/*
 * David Gonzales
 * Assignment 2, ECGR 4090
 */
package Assignment2IOT;

import java.util.Arrays;


public class Main {
    
    
    /*
     * Q1: Implement an algorithm to determine if a string has all unique characters.
     */
    public static boolean unique(String word){
        
        // Make an arrary that is the size of your word
        char[] characters = new char[word.length()];
        
        // add each character into the array
        for(int i =0; i <word.length(); i++){
            characters[i]=word.charAt(i);
        }
        
        // sort the array 
        Arrays.sort(characters);
        
        // Check if there are matching characters in the array
        for(int i =0, j=i+1; i< characters.length-1; i++, j++){
            if(characters[i] == characters[j])
                return false;
        }
        
        
        return true;
    }
    
    /*
     * Q2: Given two strings, write a method to decide if one is a permutation of the other. 
     * 
     */
    public static boolean arePermutations(String fWord, String sWord){
        
        // Create two character arrays
        char[] string1 = new char[fWord.length()];
        char[] string2 = new char[sWord.length()];
        
        // Enter both wrods into an array of characters
        for(int i =0; i<fWord.length(); i++){
            string1[i]= fWord.charAt(i);
        }
        for(int j =0; j<sWord.length(); j++){
            string2[j]= sWord.charAt(j);
        }
        

        // Sort both arrays        
        Arrays.sort(string1);
        Arrays.sort(string2);
        
        // compare the two arrays
        return Arrays.equals(string1, string2);
    
    }
    
    /*
     * Q3: Given a string, write a function to check if it is a permutation of a palindrome.
     */
    public static boolean palPerm(String word){
        
        // Create an array of 128 for ASCII characters
        int[] helper = new int[128];
        
        // Increase the count of each character in the string
        for(int i =0; i<word.length(); i++){
            helper[word.charAt(i)]++;
        }
        // number of odd characters in the string
        int numOdd =0;
        // If there is an odd amount of charcters for a charater increase the odd count
        for(int i=0; i<128; i++){
            if(helper[i]%2==1){
                numOdd++;
            }
        }
        // if there is one or none odd charcters you have a permutation of a palidrome
        if(numOdd<2){
            return true;
        }

    return false;
    }
    
    
    
    
    /*
     *  Q4: Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
     */
    public static boolean isRotation(String s1, String s2){

        // First check if the two strings are the same length
        if(s1.length() == s2.length()){
            // Concatinate the first word
            String x = s1.concat(s1);

            // Now check to see if s2 is a substring of s1
            if(x.contains(s2)){
                return true;
            }
            else{
                return false;
            }
        }
        // A rotation can not exist

        return false;
        
    }
    

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // String for question 1
        String word1 =  "hello";
        String word2 = "helo";  
        
        System.out.println("Question one:");
        if(!unique(word1)){
            System.out.println("Not unique characters: "+word1);
        }
        else{
            System.out.println("Unique charachters: "+word1);
        }
        if(!unique(word2)){
            System.out.println("Not unique characters: "+word2);
        }
        else{
            System.out.println("Unique charachters: "+word2);
        }

        // String for question 2
        String word3 = "water"; 
        String word4 = "arewt"; 
        System.out.println("Question Two:");
        if(arePermutations(word3, word4)==true){
            System.out.println("Permutations: " +word3 + ", " + word4);
        }
        else{
            System.out.println("Not Permutations: " +word3 + ", " + word4);
        }
        
        System.out.println("Question three: ");
        String word5 = "raceacr";
        if(palPerm(word5)){
            System.out.println(word5 + " is a permutation of a palidrome");
        }
        else{
            System.out.println(word5 + " is not a permutation of a palidrome");
        }


        // String for question 4
        String word6 = new String("waterbottle");
        String word7 = new String("erbottlewat");
        System.out.println("Question four:");
        if(isRotation(word6, word7)){
            System.out.println(word7 + " is a roation of "+ word6);
        }
        else{
            System.out.println(word7 + " is not a roation of "+ word6);
        }
        
        
        
    }  
    
}
