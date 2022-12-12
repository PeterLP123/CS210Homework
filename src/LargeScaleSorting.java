import java.util.Scanner;
public class LargeScaleSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        sc.close();
        long nums [] = new long[(int) (b - a + 1)];
        long collatz [] = new long[(int) (b - a + 1)];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = a;
            collatz[i] = collatzLength(a);
            a++;
        }
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i] + "," + collatz[i]);
        }
        mergeSort(collatz, nums);
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i] + "," + collatz[i]);
        }
    }

    //Collatz Length
    public static long collatzLength (long n) {
        long length = 1;
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

    //Merge Sort
    public static void mergeSort(long[] arr, long[] arr2) {
        if (arr.length > 1) {
            long[] leftc = leftHalf(arr);
            long[] left = leftHalf(arr2);
            long[] rightc = rightHalf(arr);
            long[] right = rightHalf(arr2);

            mergeSort(leftc, left);
            mergeSort(rightc, right);

            merge(arr, arr2, leftc, left, rightc, right);
        }
    }

    //left half of array
    public static long[] leftHalf(long[] arr) {
        long size1 = arr.length / 2;
        long[] left = new long[(int)size1];
        for (long i = 0; i < size1; i++) {
            left[(int)i] = arr[(int)i];
        }
        return left;
    }

    //right half of array
    public static long[] rightHalf(long[] arr) {
        long size1 = arr.length / 2;
        long size2 = arr.length - size1;
        long[] right = new long[(int)size2];
        for (long i = 0; i < size2; i++) {
            right[(int)i] = arr[(int) (i + size1)];
        }
        return right;
    }

    //merge method
    public static void merge(long[] result, long [] result2, long[] leftc, long[] left, long[] rightc, long[] right) {
        long i1 = 0;
        long i2 = 0;

        for (long i = 0; i < result.length; i++) {
            if (i2 >= rightc.length || (i1 < leftc.length && leftc[(int)i1] <= rightc[(int)i2])) {
                result[(int)i] = leftc[(int)i1];
                result2[(int)i] = left[(int)i1];
                i1++;
            } else {
                result[(int)i] = rightc[(int)i2];
                result2[(int)i] = right[(int)i2];
                i2++;
            }
        }
    }
}