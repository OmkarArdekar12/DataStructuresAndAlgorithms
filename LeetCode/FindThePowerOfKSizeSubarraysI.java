// Find the Power of K-Size Subarrays I

import java.util.Arrays;

public class FindThePowerOfKSizeSubarraysI {
    public static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n - k + 1];
        
        int i = 0;
        int consecutive = 1;
        int x = 0;
        for(int j=0; j<n; ++j) {
            if(j > 0 && nums[j-1] + 1 == nums[j]) {
                ++consecutive;
            }

            if(j - i + 1 > k) {
                consecutive += nums[i] + 1 == nums[i + 1] ? -1 : 0;
                ++i;
            }

            if(j - i + 1 == k) {
                res[x++] = consecutive == k ? nums[j] : -1;
            }
        }

        return res;

        // int n = nums.length;
        // int results[] = new int[n - k + 1];
        // int idx = 0;
        // boolean maxValue = true;
        // for(int i=0, j=k-1; j<n; ++i, ++j) {
        //     maxValue = true;
        //     for(int x=i; x<j; ++x) {
        //         if(nums[x]+1 != nums[x+1]) {
        //             maxValue = false;
        //             break;
        //         }
        //     }
        //     results[idx++] = maxValue ? nums[j] : -1;
        // }
        // return results;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 0, 4, 10}, k = 2;
        System.out.println(Arrays.toString(resultsArray(nums, k)));
    }
}