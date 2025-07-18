// Meeting Rooms II
// Give an 2D array intervals consists of n number intervals.
// intervals[i][0] = startTime and intervals[i][1] = endTime
// Return minimum number of rooms required to schedule all meeting without any overlaps.

public class MeetingRoomsII {
    public static int meetingRoomsII(int intervals[][]) {
        int n = intervals.length;
        int maxTime = 0;
        for(int i=0; i<n; ++i) {
            maxTime = Math.max(maxTime, intervals[i][1]);
        }

        int time[] = new int[maxTime + 1];
        for(int i=0; i<n; ++i) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            ++time[start];
            --time[end];
        }

        int res = 0, count = 0;
        for(int i=0; i<=maxTime; ++i) {
            count += time[i];
            res = Math.max(res, count);
        }

        return res;
    }

    public static void main(String[] args) {
        int input1[][] = {{0, 30}, {5, 10}, {15, 20}}; //output: 2
        int input2[][] = {{0, 10}, {12, 15}, {16, 25}}; //output: 1
        System.out.println(meetingRoomsII(input1));
        System.out.println(meetingRoomsII(input2));
    }
}