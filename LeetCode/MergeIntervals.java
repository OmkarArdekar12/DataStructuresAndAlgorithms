// Merge Intervals

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;

        int maxStartTime = 0;
        for(int i=0; i<n; ++i) {
            maxStartTime = Math.max(maxStartTime, intervals[i][0]);
        }

        int map[] = new int[maxStartTime + 1]; //map startTime to endTime
        for(int i=0; i<n; ++i) {
            int start = intervals[i][0], end = intervals[i][1];
            map[start] = Math.max(map[start], end + 1);
        }

        int overlap = 0;
        int intervalStartTime = -1, intervalEndTime = -1;
        for(int currTime=0; currTime<=maxStartTime; ++currTime) {
            if(map[currTime] != 0) {
                if(intervalStartTime == -1) {
                    intervalStartTime = currTime;
                }
                intervalEndTime = Math.max(intervalEndTime, map[currTime] - 1);
            }
            if(intervalEndTime == currTime) {
                intervals[overlap][0] = intervalStartTime;
                intervals[overlap][1] = intervalEndTime;
                ++overlap;
                intervalStartTime = intervalEndTime = -1;
            }
        }
        if(intervalStartTime != -1) {
            intervals[overlap][0] = intervalStartTime;
            intervals[overlap][1] = intervalEndTime;
            ++overlap;
            intervalStartTime = intervalEndTime = -1;
        }

        int res[][] = new int[overlap][2];
        for(int i=0; i<overlap; ++i) {
            res[i][0] = intervals[i][0];
            res[i][1] = intervals[i][1];
        }

        return res;

        // int n = intervals.length;
        // Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        // List<int[]> res = new ArrayList<>();
        // for(int i=0; i<n; ++i) {
        //     int currStart = intervals[i][0], currEnd = intervals[i][1];
        //     if(res.isEmpty()) {
        //         res.add(new int[]{currStart, currEnd});
        //     } else {
        //         int prev[] = res.get(res.size() - 1);
        //         int prevStart = prev[0], prevEnd = prev[1];
        //         if(currStart <= prevEnd) {
        //             prev[0] = prevStart;
        //             prev[1] = Math.max(prevEnd, currEnd);
        //         } else {
        //             res.add(new int[]{currStart, currEnd});
        //         }
        //     }
        // }
        // int m = res.size();
        // int result[][] = new int[m][2];
        // for(int i=0; i<m; ++i) {
        //     result[i] = res.get(i);
        // }
        // return result;

        // int n = intervals.length;
        // Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        // List<int[]> res = new ArrayList<>();
        // int prevStart = 0,  prevEnd = 0;
        // for(int i=0; i<n; ++i) {
        //     int currStart = intervals[i][0], currEnd = intervals[i][1];
        //     if(i == 0) {
        //         prevStart = currStart;
        //         prevEnd = currEnd;
        //         continue;
        //     }
        //     if(currStart <= prevEnd) {
        //         prevEnd = Math.max(prevEnd, currEnd);
        //     } else {
        //         res.add(new int[]{prevStart, prevEnd});
        //         prevStart = currStart;
        //         prevEnd = currEnd;
        //     }
        // }
        // if(res.size() == 0 || res.get(res.size() - 1)[1] != prevEnd) {
        //     res.add(new int[]{prevStart, prevEnd});
        // }
        // int m = res.size();
        // int result[][] = new int[m][2];
        // for(int i=0; i<m; ++i) {
        //     result[i] = res.get(i);
        // }
        // return result;

        // int n = intervals.length;
        // if(n < 2) {
        //     return intervals;
        // }
        // Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        // int min = intervals[0][0];
        // int max = intervals[0][1];
        // List<int[]> res = new ArrayList<>();
        // int i = 1;
        // while(i <= n) {
        //     if(i < n && min <= intervals[i][0] && max >= intervals[i][0]) {
        //         min = Math.min(min, intervals[i][0]);
        //         max = Math.max(max, intervals[i][1]);
        //     } else {
        //         int arr[] = {min, max};
        //         res.add(arr);
        //         if(i >= n) {
        //             break;
        //         }
        //         min = intervals[i][0];
        //         max = intervals[i][1];
        //     }
        //     ++i;
        // }
        // int result[][] = new int[res.size()][2];
        // i = 0;
        // for(int arr[] : res) {
        //     result[i][0] = arr[0];
        //     result[i][1] = arr[1];
        //     ++i;
        // }
        // return result;
    }

    public static void main(String[] args) {
        int intervals[][] = {{1,3}, {2,6}, {8,10}, {15,18}};
        int res[][] = merge(intervals);
        for(int i[] : res) {
            System.out.println(Arrays.toString(i));
        }
    }
}