import java.util.Scanner;
import java.util.Random;
public class MonteCarlo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int sampleSize = sc.nextInt();
        int testNo = sc.nextInt();
        sc.close();
        int success = 0;
        for(int c = 0; c < 1000; c++){
            int[] days = new int[365];
            for (int i = 0; i < sampleSize; i++) {
                days[rand.nextInt(days.length)]++;
            }
            for(int i = 0; i < days.length; i++){
                // Equal or greater than or equal?
                if(days[i] >= testNo){
                    success++;
                    break;
                }
            }
        }
        System.out.println(success);
    }
}