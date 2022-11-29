package ExamQuestions;
import java.util.Scanner;
public class Question4_2022A {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] arr = new String [5];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextLine();
        }
        sc.close();
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j].length() > arr[j + 1].length()){
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }else if(arr[j].length() == arr[j+1].length()){
                    if(arr[j].compareToIgnoreCase(arr[j+1]) > 0){
                        String temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}