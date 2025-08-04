// Smallest Subarrays With Maximum Bitwise OR
// You are given a 0-indexed array nums of length n, consisting of non-negative integers. 
// For each index i from 0 to n - 1, you must determine the size of the minimum sized non-empty subarray of nums starting at i (inclusive) that has the maximum possible bitwise OR.
// In other words, let Bij be the bitwise OR of the subarray nums[i...j]. You need to find the smallest subarray starting at i, such that bitwise OR of this subarray is equal to max(Bik) where i <= k <= n - 1.
// The bitwise OR of an array is the bitwise OR of all the numbers in it.
// Return an integer array answer of size n where answer[i] is the length of the minimum sized subarray starting at i with maximum bitwise OR.
// A subarray is a contiguous non-empty sequence of elements within an array.

import java.util.*;

public class SmallestSubarraysWithMaximumBitwiseOR {
    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int positionBits[] = new int[31];
        Arrays.fill(positionBits, -1);
        int res[] = new int[n]; //to find the maximum bitwiseOr subarray length starting from ith index(inclusive)
        for(int i=n-1, j=0; i>=0; --i) { //traversing the array in reverse order for optimal approach
            j = i;
            for(int currBit=0; currBit<31; ++currBit) {
                //if the current bit is zero, then it don't contribute in the bitwiseOr by the current value at index i.
                if((nums[i] & (1 << currBit)) == 0) { 
                    //if the current bit is already set, then it contribute in the bitwiseOr by some forward index number 
                    //then ith index(currentIndex), So, increasing the window size that is increasing the subarray size window
                    if(positionBits[currBit] != -1) { 
                        j = Math.max(j, positionBits[currBit]);
                    }
                } else { //if the current bit is one, then the currBit of the currVal contribute in the bitwiseOr 
                    positionBits[currBit] = i;
                }
            }
            res[i] = j - i + 1; //calculating the total numbers(length of the subarray/window) in the current window/subarray.
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,1,3};
        System.out.println(Arrays.toString(smallestSubarrays(nums)));
    }
}