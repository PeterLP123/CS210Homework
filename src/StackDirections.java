import java.util.Scanner;
public class StackDirections{
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String [] stack = new String[100];
        boolean notArrived = true;
        int top = 0;
        while(notArrived){
            String input = sc.nextLine();
            if(input.equals("Arrived")){
                notArrived = false;
            }
            else if(input.equals("Go Back")){
                top--;
            }
            else{
                stack[top] = input;
                top++;
            }
        }
        sc.close();
        for(int i = top-1; i >= 0; i--){
            switch(stack[i]){
                case "Go North":
                    System.out.println("Go South");
                    break;
                case "Go South":
                    System.out.println("Go North");
                    break;
                case "Go East":
                    System.out.println("Go West");
                    break;
                case "Go West":
                    System.out.println("Go East");
                    break;
            }
        }
    }
}