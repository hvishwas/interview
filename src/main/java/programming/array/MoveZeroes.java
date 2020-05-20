package programming.array;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    public static void main(String... args) {
        System.out.println(Arrays.toString(moveZeroes(new int[] {0, 1, 0, 3, 12})));
    }

    private static int[] moveZeroes(int[] input) {
        int i = 0;
        int j = 0;
        while (i < input.length) {
            if (input[i] != 0) {
                input[j] = input[i];
                j++;
            }
            i++;
        }
        while (j < input.length) {
            input[j++] = 0;
        }
        return input;
    }
}
