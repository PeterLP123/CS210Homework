import java.util.Scanner;
public class Lab11_Question1{
    public static void main(String [] main){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.close();
        System.out.println(function(input));
    }
    public static int function(int n){
        if(n == 1){
            return 2;
        }else{
            return 4 * function(n-1) - 3 * n;
        }
    }
}