// Find the Power of K-Size Subarrays II

import java.util.*;

public class FindThePowerOfKSizeSubarraysII {
    public static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;

        int res[] = new int[n - k + 1];
        int consecutiveCount = 0;
        for(int i=0; i<n; ++i) {
            if(i > 0 && nums[i - 1] + 1 == nums[i]) {
                ++consecutiveCount;
            } else {
                consecutiveCount = 1;
            }

            if(i + 1 >= k) {
                res[i - k + 1] = consecutiveCount >= k ? nums[i] : -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 0, 4, 10}, k = 2;
        System.out.println(Arrays.toString(resultsArray(nums, k)));
    }
}