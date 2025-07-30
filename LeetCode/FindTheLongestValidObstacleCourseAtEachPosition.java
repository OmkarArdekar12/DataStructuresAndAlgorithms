// Find the Longest Valid Obstacle Course at Each Position
// You want to build some obstacle courses. You are given a 0-indexed integer array obstacles of length n, where obstacles[i] describes the height of the ith obstacle.
// For every index i between 0 and n - 1 (inclusive), find the length of the longest obstacle course in obstacles such that:
// You choose any number of obstacles between 0 and i inclusive.
// You must include the ith obstacle in the course.
// You must put the chosen obstacles in the same order as they appear in obstacles.
// Every obstacle (except the first) is taller than or the same height as the obstacle immediately before it.
// Return an array ans of length n, where ans[i] is the length of the longest obstacle course for index i as described above.

import java.util.*;

public class FindTheLongestValidObstacleCourseAtEachPosition {
    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int res[] = new int[n];
        ArrayList<Integer> subsequence = new ArrayList<>(); //increasing subsequence
        for(int i=0; i<n; ++i) {
            int curr = obstacles[i];
            int currRes = 0;
            if(subsequence.isEmpty() || subsequence.get(subsequence.size() - 1) <= curr) {
                subsequence.add(curr);
                currRes = subsequence.size();
            } else {
                int si = 0, ei = subsequence.size() - 1;
                while(si <= ei) {
                    int mid = (si + (ei - si) / 2);
                    if(subsequence.get(mid) <= curr) {
                        si = mid + 1;
                    } else {
                        ei = mid - 1;
                    }
                }
                subsequence.set(si, curr);
                currRes = si + 1;
            }
            res[i] = currRes;
        }
        return res;
        // int n = obstacles.length;
        // int res[] = new int[n];
        // int monoIncreasingStack[] = new int[n];
        // int currLength = 0;
        // for(int i=0; i<n; ++i) {
        //     int si = 0, ei = currLength;
        //     while(si < ei) {
        //         int mid = si + (ei - si) / 2;
        //         if(monoIncreasingStack[mid] <= obstacles[i]) {
        //             si = mid + 1;
        //         } else {
        //             ei = mid;
        //         }
        //     }
        //     res[i] = si + 1;
        //     if(currLength == si) {
        //         ++currLength;
        //     }
        //     monoIncreasingStack[si] = obstacles[i];
        // }
        // return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(longestObstacleCourseAtEachPosition(new int[]{1, 2, 3, 2})));
    }
}