import java.util.Scanner;
public class BaseConversion {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int baseIn = sc.nextInt();
        int baseOut = sc.nextInt();
        sc.nextLine();
        String num = sc.nextLine();
        sc.close();
        System.out.println(Long.toString(Long.parseLong(num, baseIn), baseOut));
    }
}