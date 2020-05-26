package programming.array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given n ropes of different lengths, we need to connect these ropes into one rope. We can connect only 2 ropes at a time. The cost required to connect 2 ropes is equal to sum
 * of their lengths. The length of this connected rope is also equal to the sum of their lengths. This process is repeated until n ropes are connected into a single rope. Find
 * the min possible cost required to connect all ropes.
 * <p>
 * Example 1:
 * <p>
 * Input: ropes = [8, 4, 6, 12]
 * Output: 58
 * Explanation: The optimal way to connect ropes is as follows
 * 1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
 * 2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
 * 3. Connect the ropes of length 18 and 12 (cost is 30).
 * Total cost to connect the ropes is 10 + 18 + 30 = 58
 * Example 2:
 * <p>
 * Input: ropes = [20, 4, 8, 2]
 * Output: 54
 * Example 3:
 * <p>
 * Input: ropes = [1, 2, 5, 10, 35, 89]
 * Output: 224
 * Example 4:
 * <p>
 * Input: ropes = [2, 2, 3, 3]
 * Output: 20
 */
public class MinCostConnectRopes {

    public static void main(String[] args) {
        System.out.println(findMinCost(new int[] {8, 4, 6, 12})); //58
        System.out.println(findMinCost(new int[] {8, 4, 6, 12, 1})); //66
    }

    private static int findMinCost(int[] input) {
        if (input == null || input.length == 1) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
        }
        int min = 0;
        while (queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            min += sum;
            queue.add(sum);
        }
        return min;
    }
}
