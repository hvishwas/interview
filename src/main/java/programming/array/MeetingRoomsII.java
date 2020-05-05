package programming.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * <p>
 * Example1
 * <p>
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: 2
 * Explanation:
 * We need two meeting rooms
 * room1: (0,30)
 * room2: (5,10),(15,20)
 * Example2
 * <p>
 * Input: intervals = [(2,7)]
 * Output: 1
 * Explanation:
 * Only need one meeting room
 */
class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {0, 30},
                {5, 40},
                {15, 20},
                {30, 45},
                {30, 45},
                {35, 40},
                {45, 50}
        };
        System.out.println(findNumberOfConferenceRooms(intervals));
    }

    private static int findNumberOfConferenceRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] earliest = queue.remove();
            if(current[0] >= earliest[1]) {
                earliest[1] = current[1];
            } else {
                queue.add(current);
            }
            queue.add(earliest);
        }
        return queue.size();
    }
}
