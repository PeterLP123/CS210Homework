import java.util.Scanner;
public class StackDirections {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        char [] stack = new char[100];
        int top = 0;
        while(true){
            String input = sc.nextLine();
            if(input.equals("Arrived")){
                break;
            }
            else if(input.equals("Go Back")){
                top--;
            }
            else{         
                stack[top] = input.charAt(3);
                top++;               
            }
        }
        sc.close();
        top--;
        while(top >= 0){
            switch(stack[top]){
                case 'N':
                    System.out.println("Go South");
                    break;
                case 'S':
                    System.out.println("Go North");
                    break;
                case 'E':
                    System.out.println("Go West");
                    break;
                case 'W':
                    System.out.println("Go East");
                    break;
            }
            top--;
        }
    }
}