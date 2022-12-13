import java.util.Scanner;
public class LargeScaleSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long lowerbound = sc.nextLong();
        long upperbound = sc.nextLong();
        long search = sc.nextLong();
        sc.close();
        long nums [] = new long[(int) (upperbound - lowerbound + 1)];
        long collatz [] = new long[(int) (upperbound - lowerbound + 1)];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = lowerbound;
            collatz[i] = collatzLength(lowerbound);
            lowerbound++;
        }
        mergeSort(collatz, nums);
        System.out.println(nums[(int) search - 1]);
    }

    public static long collatzLength (long n) {
        long length = 1;
        while (n != 1) {
            n = (n % 2 == 0) ? n/2 : 3 * n + 1;
            length++;
        }
        return length;
    }

    public static void mergeSort(long[] arrc, long[] arr2) {
        if (arrc.length > 1) {
            long[] leftc = leftHalf(arrc);
            long[] left = leftHalf(arr2);
            long[] rightc = rightHalf(arrc);
            long[] right = rightHalf(arr2);

            mergeSort(leftc, left);
            mergeSort(rightc, right);

            merge(arrc, arr2, leftc, left, rightc, right);
        }
    }

    public static long[] leftHalf(long[] arr) {
        long size1 = arr.length / 2;
        long[] left = new long[(int)size1];
        for (long i = 0; i < size1; i++) {
            left[(int)i] = arr[(int)i];
        }
        return left;
    }

    public static long[] rightHalf(long[] arr) {
        long middle = arr.length / 2;
        long size2 = arr.length - middle;
        long[] right = new long[(int)size2];
        for (long i = 0; i < size2; i++) {
            right[(int)i] = arr[(int) (i + middle)];
        }
        return right;
    }

    public static void merge(long[] result, long [] result2, long[] leftc, long[] left, long[]  rightc, long[] right) {
        long il = 0;
        long ir = 0;

        for (long i = 0; i < result.length; i++) {
            if (ir >= rightc.length || (il < leftc.length && leftc[(int)il] <= rightc[(int)ir])) {
                result[(int)i] = leftc[(int)il];
                result2[(int)i] = left[(int)il];
                il++;
            } else {
                result[(int)i] = rightc[(int)ir];
                result2[(int)i] = right[(int)ir];
                ir++;
            }
        }
    }
}