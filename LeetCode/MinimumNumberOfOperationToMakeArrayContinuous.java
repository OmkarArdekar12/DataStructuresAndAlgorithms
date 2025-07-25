// Minimum Number of Operations to Make Array Continuous
// You are given an integer array nums. In one operation, you can replace any element in nums with any integer.
// nums is considered continuous if both of the following conditions are fulfilled:
// All elements in nums are unique.
// The difference between the maximum element and the minimum element in nums equals nums.length - 1.
// Return the minimum number of operations to make nums continuous.

import java.util.*;

public class MinimumNumberOfOperationToMakeArrayContinuous {
    public static int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>(); //find all unique elements
        for(int i=0; i<n; ++i) {
            set.add(nums[i]);
        }
        int m = set.size();
        int uniqueNums[] = new int[m]; //making an array of unique elements
        int idx = 0;
        for(int i : set) {
            uniqueNums[idx++] = i;
        }
        Arrays.sort(uniqueNums); //sorting the unique elments array

        //using sliding window approach
        int minOperations = Integer.MAX_VALUE; //maximum operation will be size of array n, So, we can keep it either Integer.MAX_VALUE or n;
        for(int i=0, j=0; i<m; ++i) {
            //considering the uniqueNums[i] as our current minimum element
            //So, the difference between min and max element should be equal to n(nums.length),
            //we will find the max element whose value is currMin + n that is uniqueNums[i] + n
            int currMin = uniqueNums[i]; 
            while(j < m && uniqueNums[j] < currMin + n) {
                ++j;
            }

            int count = j - i; //counting the elment in the window from i to j
            int operations = n - count; //counting the element outside the window, on which we have to do operation
            minOperations = Math.min(minOperations, operations);
        }

        return minOperations;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 5, 6};
        System.out.println(minOperations(nums));
    }
}