import java.util.Scanner;
public class Scrabble {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int wordCount = sc.nextInt();
        sc.nextLine();
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; 
        int[] scores = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        String [] words = new String [wordCount];
        String [] owords = new String [wordCount];
        int [] totals = new int [wordCount];
        for(int i = 0; i < wordCount; i++){
            owords[i] = sc.nextLine();
            words[i] = owords[i].toLowerCase();
            for(int j = 0; j < words[i].length(); j++){
                for(int k = 0; k < letters.length; k++){
                    if(words[i].charAt(j) == letters[k]){
                        totals[i] += scores[k];
                    }
                }
            }
        }
        sc.close();
        for (int i = 0; i < totals.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < totals.length; j++){  
                if (totals[j] < totals[index]){  
                    index = j;
                }  
            }  
            int smallerNumber = totals[index];
            String temp = words[index];
            String tempo = words[index];

            totals[index] = totals[i];  
            words[index] = words[i];
            owords[index] = owords[i];

            totals[i] = smallerNumber;  
            words[i] = temp;
            owords[i] = tempo;
        }
        for(int i = 0; i < totals.length-1; i++){
            if(totals[i] == totals[i + 1]){
                if(words[i].compareTo(words[i+1]) > 0){
                    String temp2 = words[i];
                    String tempo2 = owords[i];
                    words[i] = words[i+1];
                    owords[i] = words[i+1];
                    words[i+1] = temp2;
                    words[i+1] = tempo2;
                }
            }
        }
        for(int i = 0; i < owords.length; i++){
            System.out.println(owords[i]);
        }
    }
}