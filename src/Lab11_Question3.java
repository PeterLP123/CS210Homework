import java.util.Scanner;
public class Lab11_Question3 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(counter(s, 0));
    }

    public static int counter(String s, int c){
        if(s.length() == 0){
            return 0;
        }
        s = s.replaceAll(Character.toString(s.charAt(0)), "");
        return counter(s, c) + 1;
    }
}
