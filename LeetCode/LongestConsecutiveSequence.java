// Longest Consecutive Sequence

import java.util.*;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        // int n = nums.length;
        // Set<Integer> set = new HashSet<>();
        // for(int i=0; i<n; ++i) {
        //     set.add(nums[i]);
        // }
        // int maxLen = 0;
        // for(int i=0; i<n; ++i) {
        //     int curr = nums[i];
        //     int count = 1;
        //     if(!set.contains(curr - 1)) {
        //         while(set.contains(++curr)) {
        //             ++count;
        //             set.remove(curr);
        //         }
        //         maxLen = Math.max(maxLen, count);
        //     }
        // }
        // return maxLen;

        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; ++i) {
            set.add(nums[i]);
        }

        int res = 0;
        for(int i=0; i<n; ++i) {
            int curr = nums[i];
            int count = 1;

            set.remove(curr);
            while(set.contains(--curr)) {
                ++count;
                set.remove(curr);
            }

            curr = nums[i];
            while(set.contains(++curr)) {
                ++count;
                set.remove(curr);
            }
            
            res = Math.max(res, count);
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
