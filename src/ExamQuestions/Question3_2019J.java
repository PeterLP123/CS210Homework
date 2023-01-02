import java.util.Scanner;

public class Question3_2019J {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue(100);
        while(true){
            String input = sc.nextLine();
            if(input.equals("exit")){
                break;
            }
            else if(input.contains("insert")){
                q.insert(Integer.parseInt(input.substring(7, input.length())));
            }
            else if(input.equals("remove")){
                int item = q.remove();
                System.out.println("The removed item is " + item);
            }
            else{
                System.out.println("Invalid input");
            }
        }
        sc.close();
    }
}

class Queue{
    int [] queue;
    int front;
    int rear;
    int size;

    public Queue(int size){
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void insert (int item){
        if (rear == size-1){
            System.out.println("Queue is full");
        }
        else{
            if (front == -1){
                front = 0;
            }
            rear++;
            queue[rear] = item;
        }
    }

    public int remove(){
        int item = 0;
        if (front == -1 || front > rear){
            System.out.println("0");
        }
        else{
            item = queue[front];
            front++;
        }
        return item;
    }
}
