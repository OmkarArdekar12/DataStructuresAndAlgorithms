// Maximum Good Subarray Sum

import java.util.*;

public class MaximumGoodSubarrySum {
    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long prefix[] = new long[n + 1]; //prefix sum
        Map<Integer, Integer> map = new HashMap<>(); //HashMap/Map->(val, idx)
        long res = Long.MIN_VALUE;
        for(int i=0; i<n; ++i) {
            int curr = nums[i];
            prefix[i + 1] = prefix[i] + curr; //prefixSum

            int prev = curr - k;
            int next = curr + k;
            long sum1 = map.containsKey(prev) ? prefix[i + 1] - prefix[map.get(prev)] : Long.MIN_VALUE;
            long sum2 = map.containsKey(next) ? prefix[i + 1] - prefix[map.get(next)] : Long.MIN_VALUE;
            long currSum = Math.max(sum1, sum2);
            
            res = Math.max(res, currSum);

            //previousSum = prefix[i] - prefix[map.get(curr)]
            //if previousSum does not increase the sum don't add it
            if(!map.containsKey(curr) || prefix[i] - prefix[map.get(curr)] <= 0) { //kadane algorithm
                map.put(curr, i);
            }
        }

        return res == Long.MIN_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5}, k = 4;
        System.out.println(maximumSubarraySum(nums, k));
    }
}