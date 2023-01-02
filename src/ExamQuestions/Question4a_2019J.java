public class Question4a_2019J {
    // What is the output of the following program?
    public static void main(String[] args){
        System.out.println(function("Launch"));
        }
        public static String function(String input){
        System.out.println("Evaluating");
        if(input.length()%7==0){
        return "Exit";
        }
        return(function(input+"Return")+"Terminated");
    }       
}
// This program will print out:
// Evaluating for the number of times that terminated must be added to the string "Launch" to make it a multiple of 7
// It will then print out the string "Exit" and then "Terminated" for the number of times that terminated was added