package programming.array;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] input = new int[] {3, 4, 2, 9, 1, 0};
        mergeSort(input);
        System.out.println(Arrays.toString(input));
    }

    private static void mergeSort(int[] input) {
        if (input.length == 1) {
            return;
        }
        int mid = input.length / 2;
        int[] left = new int[mid];
        int[] right = new int[input.length - mid];

        for (int i = 0; i < input.length; i++) {
            if (i < mid) {
                left[i] = input[i];
            } else {
                right[i - mid] = input[i];
            }
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, input);
    }

    private static void merge(int[] left, int[] right, int[] input) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                input[k++] = left[i++];
            } else {
                input[k++] = right[j++];
            }
        }
        while (i < left.length) {
            input[k++] = left[i++];
        }
        while (j < right.length) {
            input[k++] = right[j++];
        }
    }
}
