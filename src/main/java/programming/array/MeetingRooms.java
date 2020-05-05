package programming.array;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... ,
 * determine if a person could attend all meetings.
 * <p>
 * For example,
 * Given [ [0, 30], [5, 10], [15, 20] ],
 * return false.
 */
class MeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {0, 30},
                {5, 10},
                {15, 20}
        };

        System.out.println(canAttendAll(intervals));
    }

    private static boolean canAttendAll(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return false;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
