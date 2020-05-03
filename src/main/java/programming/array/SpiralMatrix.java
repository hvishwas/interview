package programming.array;

import java.util.Arrays;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSpiralMatrix(new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        })));
    }

    private static int[] findSpiralMatrix(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int[] result = new int[matrix.length * matrix[0].length];
        int count = 0;
        while (count < result.length) {
            for (int i = left; i <= right && count < result.length; i++) {
                result[count++] = matrix[top][i];
            }
            top++;
            for (int i = top; i <= bottom && count < result.length; i++) {
                result[count++] = matrix[i][right];
            }
            right--;
            for (int i = right; i >= left && count < result.length; i--) {
                result[count++] = matrix[bottom][i];
            }
            bottom--;
            for (int i = bottom; i >= top && count < result.length; i--) {
                result[count++] = matrix[i][left];
            }
            left++;
        }
        return result;
    }
}
