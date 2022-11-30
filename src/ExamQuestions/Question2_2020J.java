/*
Write a Java program that takes in a String array of 10,000
English words, and sorts them according to the number of
unique letters they contain, before printing them out in order.
The words containing the greatest number of unique letters
should be printed out first, followed by those containing fewer
unique letters. If two words use the same number of unique
letters, then they should be sorted lexicographically (i.e. like a
dictionary).

For example, the word “fantastic” uses 7 unique letters, so it
should be printed out before “banana”, which uses only 3 unique
letters.
Include comments which explain your code clearly.

State the Big O complexity of your program and justify your
reasoning. 
*/
public class Question2_2020J{
    public static void main(String [] args){
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h','i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String [] arr = new String [10000];
        int [] arrValues = new int [10000];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length(); j++){
                
            }
        } 
    }
}
