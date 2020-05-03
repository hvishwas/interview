package programming.array;

import java.util.Arrays;

/**
 * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of
 * each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array
 * elements.
 * <p>
 * Output:
 * For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else
 * print -1.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * 1 <= Ai <= 1010
 * <p>
 * Example:
 * Input:
 * 2
 * 5 12
 * 1 2 3 7 5
 * 10 15
 * 1 2 3 4 5 6 7 8 9 10
 * Output:
 * 2 4
 * 1 5
 * <p>
 * Explanation :
 * Testcase1: sum of elements from 2nd position to 4th position is 12
 * Testcase2: sum of elements from 1st position to 5th position is 15
 */
public class ContinuousSubArrayMatchingTheSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findContinuousSubArrayMatchingTheSum(new int[] {1, 2, 3, 7, 5}, 12)));
        System.out.println(Arrays.toString(findContinuousSubArrayMatchingTheSum(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15)));
    }

    private static int[] findContinuousSubArrayMatchingTheSum(int[] input, int k) {
        if (input == null || input.length == 0) {
            return new int[0];
        }
        int prev = 0;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            while (sum > k) {
                sum -= input[prev];
                prev++;
            }
            if (sum == k) {
                return new int[] {prev + 1, i + 1};
            }
        }
        return new int[0];
    }
}
