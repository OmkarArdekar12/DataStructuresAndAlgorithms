// Longest Increasing Subsequence
// Given an integer array nums, return the length of the longest strictly increasing subsequence.

import java.util.*;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        // int n = nums.length;
        // int dp[] = new int[n];
        // for(int i=0; i<n; ++i) {
        //     dp[i] = 1;
        // }
        // int res = 1;
        // for(int i=1; i<n; ++i) {
        //     for(int j=0; j<i; ++j) {
        //         if(nums[i] > nums[j]) {
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //     }
        //     res = Math.max(res, dp[i]);
        // }
        // return res;

        int n = nums.length;
        List<Integer> subsequence = new ArrayList<>();
        for(int i=0; i<n; ++i) {
            int curr = nums[i];
            if(subsequence.isEmpty() || subsequence.get(subsequence.size() - 1) < curr) {
                subsequence.add(curr);
            } else {
                int si = 0, ei = subsequence.size() - 1;
                while(si <= ei) {
                    int mid = si + (ei - si) / 2;
                    if(subsequence.get(mid) < curr) {
                        si = mid + 1;
                    } else {
                        ei = mid - 1;
                    }
                }
                subsequence.set(si, curr);
            }
        }
        int res = subsequence.size();

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}