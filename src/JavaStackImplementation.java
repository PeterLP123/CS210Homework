import java.util.*;
public class JavaStackImplementation {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        Stack<String> directions = new Stack<>(); 
        while(true){
            String input = sc.nextLine();
            if(input.equals("Arrived")){
                break;
            }
            else if(input.equals("Go Back")){
                directions.pop();
            }
            else{         
                directions.push(input);              
            }
        }
        sc.close();
        while(!directions.empty()){
            String output = directions.pop();
            switch(output){
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