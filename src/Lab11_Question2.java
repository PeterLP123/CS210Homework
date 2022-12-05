import java.util.Scanner;
public class Lab11_Question2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input balance, interest rate, years");
        double x = sc.nextDouble();
        double i = sc.nextDouble();
        int y = sc.nextInt();
        sc.close();
        System.out.println(interest(x,i,y));
    }

    public static double interest(double x, double i, int y){
        if(y == 0){
            return x;
        }
        return interest(x * (1 + i), i, y-1);
    } 
}
