import java.util.Random;
import java.util.Scanner;
public class Question2_2022J {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int simulations = sc.nextInt();
        sc.close();
        int success = 0;
        //Monte Carlo simulation
        for(int i = 0; i < simulations; i++){
            int num1 = rand.nextInt(10000000);
            int num2 = rand.nextInt(10000000);
            int hcf = highestCommonFactor(num1, num2);
            if(hcf == 1){
                success++;
            }
        }
        System.out.println((double)success/simulations);
    }

    public static int highestCommonFactor(int a, int b) //Finds the highest common factor
    {
        if(b==0)
        {
            return a;
        }
        else
        {
        return highestCommonFactor(b, a % b);
        }
    }
}
