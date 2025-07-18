// Meeting Rooms III
// You are given an integer n. There are n rooms numbered from 0 to n - 1.
// You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held 
// during the half-closed time interval [starti, endi). All the values of starti are unique.
// Meetings are allocated to rooms in the following manner:
// Each meeting will take place in the unused room with the lowest number.
// If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting 
// should have the same duration as the original meeting.
// When a room becomes unused, meetings that have an earlier original start time should be given the room.
// Return the number of the room that held the most meetings. If there are multiple rooms, return the room 
// with the lowest number.
// A half-closed interval [a, b) is the interval between a and b including a and not including b.

import java.util.*;

public class MeetingRoomsIII {
    public static int meetingRoomsIII(int n, int[][] meetings) {
        int m = meetings.length;
        long roomAvailableTime[] = new long[n];
        int roomMeetingCount[] = new int[n];

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for(int i=0; i<m; ++i) {
            int start = meetings[i][0], end = meetings[i][1];

            boolean isFound = false;
            long minTime = Long.MAX_VALUE;
            int minTimeRoom = 0;

            for(int j=0; j<n; ++j) {
                if(roomAvailableTime[j] <= start) {
                    isFound = true;
                    ++roomMeetingCount[j];
                    roomAvailableTime[j] = end;
                    break;
                }

                if(minTime > roomAvailableTime[j]) {
                    minTime = roomAvailableTime[j];
                    minTimeRoom = j;
                }
            }

            if(!isFound) {
                roomAvailableTime[minTimeRoom] += end - start;
                ++roomMeetingCount[minTimeRoom];
            }
        }

        int maxMeeting = 0;
        int maxMeetingRoom = 0;
        for(int i=0; i<n; ++i) {
            if(maxMeeting < roomMeetingCount[i]) {
                maxMeeting = roomMeetingCount[i];
                maxMeetingRoom = i;
            }
        }

        return maxMeetingRoom;
    }

    public static void main(String[] args) {
        int input1[][] = {{0, 30}, {5, 10}, {15, 20}}; 
        int input2[][] = {{0, 10}, {12, 15}, {16, 25}}; 
        System.out.println(meetingRoomsIII(2, input1)); //output: 1
        System.out.println(meetingRoomsIII(5, input2));//output: 0
    }
}