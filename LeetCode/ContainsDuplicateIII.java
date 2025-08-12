// Contains Duplicate III
// You are given an integer array nums and two integers indexDiff and valueDiff.
// Find a pair of indices (i, j) such that:
// i != j,
// abs(i - j) <= indexDiff.
// abs(nums[i] - nums[j]) <= valueDiff, and
// Return true if such pair exists or false otherwise.

import java.util.*;

public class ContainsDuplicateIII {
    //Logic
    //We will maintain the sliding window of the size k, here k is indexDiff. So, indexDiff condition is automatically
    //satisfy, because we are maintain the consecutive k element so, there differenece will less than equal to k only, more specifically
    //there difference will be in range of 1 to k-1 only. So, we have just check the condition of the valueDiff, if valueDifference
    //condition is satisfy we will return true else false.
    //We can implement this approach using HashMap or TreeSet.
    // public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
    //     int n = nums.length;
    //     TreeSet<Integer> set = new TreeSet<>();
    //     //We can Long also instead of Integer
    //     //to remove Long we have to set.remove(1L * (nums[i - indexDiff]))
    //     for(int i=0; i<n; ++i) {
    //         int curr = nums[i];
    //         Integer floorVal = set.floor(curr);
    //         Integer ceilVal = set.ceiling(curr);
    //         if(floorVal != null && Math.abs(curr - floorVal) <= valueDiff) {
    //             return true;
    //         }
    //         if(ceilVal != null && Math.abs(curr - ceilVal) <= valueDiff) {
    //             return true;
    //         }
    //         set.add(curr);
    //         if(set.size() > indexDiff) {
    //             set.remove(nums[i - indexDiff]);
    //         }
    //     }
    //     return false;
    // }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;

        Map<Long, Long> buckets = new HashMap<>();
        long bucketSize = (long)valueDiff + 1;
        for(int i=0; i<n; ++i) {
            if(i > indexDiff) {
                long lastBucket = ((long)nums[i - indexDiff - 1] - Integer.MIN_VALUE) / bucketSize;
                buckets.remove(lastBucket);
            }

            long remappedVal = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = remappedVal / bucketSize;

            if(buckets.containsKey(bucket)) {
                return true;
            }

            if(buckets.containsKey(bucket - 1) && remappedVal - buckets.get(bucket - 1) <= valueDiff) {
                return true;
            }
            if(buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) - remappedVal <= valueDiff) {
                return true;
            }

            buckets.put(bucket, remappedVal);
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1}, indexDiff = 3, valueDiff = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
    }
}