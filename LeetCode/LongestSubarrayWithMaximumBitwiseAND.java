// Longest Subarray With Maximum Bitwise AND
// You are given an integer array nums of size n.
// Consider a non-empty subarray from nums that has the maximum possible bitwise AND.
// In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
// Return the length of the longest such subarray.
// The bitwise AND of an array is the bitwise AND of all the numbers in it.
// A subarray is a contiguous sequence of elements within an array.

public class LongestSubarrayWithMaximumBitwiseAND {
    //The Bitwise AND of two different numbers will always be strictly less than the maximum of those two numbers
    public static int longestSubarray(int[] nums) {
        // int n = nums.length;
        // int longestSubarrayLength = 0; //longest subarray lengthe with maximum bitwise AND
        // int maxVal = Integer.MIN_VALUE, currSubarrayLength = 0;
        // for(int i=0; i<n; ++i) {
        //     int curr = nums[i];
        //     if(curr > maxVal) {
        //         maxVal = curr;
        //         currSubarrayLength = 1;
        //         longestSubarrayLength = 0;
        //     } else if(curr == maxVal) {
        //         ++currSubarrayLength;
        //     } else {
        //         currSubarrayLength = 0;
        //     }
        //     longestSubarrayLength = Math.max(longestSubarrayLength, currSubarrayLength);
        // }
        // return longestSubarrayLength;
        
        int n = nums.length;
        int maxBitwiseAnd = 0;
        for(int i=0; i<n; ++i) {
            maxBitwiseAnd = Math.max(maxBitwiseAnd, nums[i]);
        } 

        int res = 0, curr = 0;
        for(int i=0; i<n; ++i) {
            if(nums[i] == maxBitwiseAnd) {
                ++curr;
            } else {
                curr = 0;
            }
            res = Math.max(res, curr);
        }       

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 3, 2, 2};
        System.out.println(longestSubarray(nums));
    }
}