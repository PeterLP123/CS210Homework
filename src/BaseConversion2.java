import java.util.Scanner;
public class BaseConversion2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int baseIn = sc.nextInt();
        int baseOut = sc.nextInt();
        sc.nextLine();
        String num = sc.nextLine();
        sc.close();
        boolean neg = (num.charAt(0) == '-') ? true : false;
        char [] arr = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l', 'm','n','o','p','q','r','s','t','u','v'};
        long sum = 0;
        int power = 0;
        for(int i = num.length()-1; i >= 0; i--){
            for(int index = 0; index < arr.length; index++){
                if(num.charAt(i) == arr[index]){
                    sum += (long)Math.pow(baseIn,power) * index;
                    power++;
                    break;
                }
            }
        }
        String out = "";
        while(sum > 0){
            int outnum = (int)(sum % baseOut);
            out = arr[outnum] + out;
            sum /= baseOut;
        }       
        System.out.println((neg) ? '-' + out : out);
    }
}