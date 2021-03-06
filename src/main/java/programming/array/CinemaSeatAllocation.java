package programming.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <img src="../../../resources/cinema_seats_1.png">
 * A cinema has n rows of seats, numbered from 1 to n and there are ten seats in each row, labelled from 1 to 10 as shown in the figure above.
 * <p>
 * Given the array reservedSeats containing the numbers of seats already reserved, for example, reservedSeats[i] = [3,8] means the seat located in row 3 and labelled with 8 is
 * already reserved.
 * <p>
 * Return the maximum number of four-person groups you can assign on the cinema seats. A four-person group occupies four adjacent seats in one single row. Seats across an aisle
 * (such as [3,3] and [3,4]) are not considered to be adjacent, but there is an exceptional case on which an aisle split a four-person group, in that case, the aisle split a
 * four-person group in the middle, which means to have two people on each side.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <img src="../../../resources/cinema_seats_2.png">
 * <p>
 * Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
 * <p>
 * Output: 4
 * <p>
 * Explanation: The figure above shows the optimal allocation for four groups, where seats mark with blue are already reserved and contiguous seats mark with orange are for one
 * group.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
 * <p>
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
 * <p>
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^9
 * 1 <= reservedSeats.length <= min(10*n, 10^4)
 * reservedSeats[i].length == 2
 * 1 <= reservedSeats[i][0] <= n
 * 1 <= reservedSeats[i][1] <= 10
 * All reservedSeats[i] are distinct.
 */
public class CinemaSeatAllocation {

    public static void main(String[] args) {
        System.out.println(findPossibleSeatAllocation(3, new int[][] {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}}));
        System.out.println(findPossibleSeatAllocation(2, new int[][] {{2, 1}, {1, 8}, {2, 6}}));
        System.out.println(findPossibleSeatAllocation(4, new int[][] {{4, 3}, {1, 4}, {4, 6}, {1, 7}}));
    }

    private static int findPossibleSeatAllocation(int n, int[][] reserved) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] seat : reserved) {
            map.computeIfAbsent(seat[0], k -> new HashSet<>()).add(seat[1]);
        }

        //multiple n by 2 to get the max possible 4 seats reservation is 2 from 2 to 5 and 6 to 9
        // map would only have rows that have reserved seats, so calculate the below count where the map does have rows without any reservations.
        int count = 2 * n - 2 * map.size();
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            boolean flag = false;
            Set<Integer> set = entry.getValue();
            if (!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5)) {
                count++;
                flag = true;
            }
            if (!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)) {
                count++;
                flag = true;
            }
            if (!flag && !set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7)) {
                count++;
            }
        }
        return count;

    }
}
