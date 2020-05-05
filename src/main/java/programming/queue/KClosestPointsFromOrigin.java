package programming.queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
class KClosestPointsFromOrigin {
    public static void main(String[] args) {
        int k = 2;
//        int[][] points = new int[][] {{1, 3}, {-2, 2}};
        int[][] points = new int[][] {{3, 3}, {-2, 4}, {5, -1}};
//        int[][] points = new int[][] {{3, 3}, {2, 2}, {1, 1}};
        System.out.println(Arrays.deepToString(findKClosestPointsFromOrigin(points, k)));
    }

    private static int[][] findKClosestPointsFromOrigin(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int i = 0; i < points.length; i++) {
            queue.add(points[i]);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        int[][] result = new int[queue.size()][];
        for (int i = 0; !queue.isEmpty(); i++) {
            result[i] = queue.remove();
        }
        return result;
    }
}