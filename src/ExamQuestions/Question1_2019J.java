import java.util.Scanner;

public class Question1_2019J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int [] inputs = new int[n];
        int [] collatzLengths = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a number: ");
            inputs[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            collatzLengths[i] = collatzLength(inputs[i]);
        }
        //Bubble sort collatzLengths largest to smallest
        //Do the same to inputs
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (collatzLengths[j] < collatzLengths[j + 1]) {
                    int temp = collatzLengths[j];
                    int temp2 = inputs[j];
                    collatzLengths[j] = collatzLengths[j + 1];
                    inputs[j] = inputs[j + 1];
                    collatzLengths[j + 1] = temp;
                    inputs[j + 1] = temp2;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(inputs[i]);
        }
        sc.close();
    }

    //Returns the length of the Collatz sequence starting at n
    public static int collatzLength(int n) {
        int length = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            length++;
        }
        return length;
    }
}
