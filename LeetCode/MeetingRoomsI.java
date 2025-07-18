// Meeting Rooms I
// Give an 2D array intervals consists of n number intervals.
// intervals[i][0] = startTime and intervals[i][1] = endTime
// Determine whether all meetings can be schedule without any conflicts,
// if it is possible then, return true, else return false.

import java.util.*;

public class MeetingRoomsI {
    public static boolean meetingRoomsI(int intervals[][]) {
        int n = intervals.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<n; ++i) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        int count = 0;
        for(int key : map.keySet()) {
            count += map.get(key);
            if(count > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int input1[][] = {{0, 30}, {5, 10}, {15, 20}}; //output: false
        int input2[][] = {{0, 10}, {12, 15}, {16, 25}}; //output: true
        System.out.println(meetingRoomsI(input1));
        System.out.println(meetingRoomsI(input2));
    }
}