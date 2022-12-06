import java.util.Scanner;
public class Lab11_Question2Final {
    public static void main(String [] args){
        Scanner myscanner = new Scanner(System.in);
        int y = myscanner.nextInt();
        double i = myscanner.nextDouble();
        double x = myscanner.nextDouble();
        myscanner.close();
        System.out.println(String.format( "%.2f", compound(y,i,x)));
    }

    public static double compound(int y, double i, double x){
        /* Enter your code here. Define factor, one, two and three below */
        if(y <= 0){
            return x;
        }
        double two = i;
        double three = x;
        i /= 100;
        double factor = 1 + i;
        int one = y - 1;
    
        return (factor*compound(one, two, three));
    }
}
