import java.util.Scanner;
public class Lab11_Question3Final {
    public static void main(String args[] ){
        Scanner myscanner = new Scanner(System.in);
        String sentence = myscanner.nextLine();
        myscanner.close();
        System.out.println(countunique(sentence,0));
    }
    
    public static int countunique(String sentence, int seen){
    //fill in the recursive method
        if(sentence.contains("?")){
            sentence = sentence.replaceAll("\\?", "");
            return countunique(sentence, seen) + 1;
        }
        else if(sentence.length() == 0){
            return 0;
        }
        sentence = sentence.replaceAll(Character.toString(sentence.charAt(0)), "");
        return countunique(sentence, seen) + 1;
    }
}
