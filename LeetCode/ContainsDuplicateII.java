// Contains Duplicate II
// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array 
// such that nums[i] == nums[j] and abs(i - j) <= k.

import java.util.*;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> lastSeenIdx = new HashMap<>();
        for(int i=0; i<n; ++i) {
            int curr = nums[i];
            if(lastSeenIdx.containsKey(curr) && i - lastSeenIdx.get(curr) <= k) {
                return true;
            }
            lastSeenIdx.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1}, k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}