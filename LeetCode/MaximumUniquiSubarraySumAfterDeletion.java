// Maximum Unique Subarray Sum After Deletion
// You are given an integer array nums.
// You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:
// All elements in the subarray are unique.
// The sum of the elements in the subarray is maximized.
// Return the maximum sum of such a subarray.

import java.util.*;

public class MaximumUniquiSubarraySumAfterDeletion {
    public static int maxSum(int[] nums) {
        //Kadane's Algorithm - Just handling the negative number and unique number case
        int sum = 0, max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            max = Math.max(max, i);
            if(i <= 0 || set.contains(i)) {
                continue;
            }
            sum += i;
            set.add(i);
        }

        return set.isEmpty() ? max : sum;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        System.out.println(maxSum(nums));
    }
}