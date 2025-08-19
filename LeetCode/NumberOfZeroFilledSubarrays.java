// Number of Zero-Filled Subarrays

public class NumberOfZeroFilledSubarrays {
    public static long zeroFilledSubarray(int[] nums) {
        // int n = nums.length;
        // long res = 0;
        // for(int i=0; i<n; ++i) {
        //     int start = i;
        //     while(i < n && nums[i] == 0) {
        //         ++i;
        //         res += i - start;
        //     }
        // }
        // return res;

        // int n = nums.length;
        // long res = 0;
        // int count = 0;
        // for(int i=0; i<n; ++i) {
        //     if(nums[i] == 0) {
        //         ++count;
        //         res += count;
        //     } else {
        //         count = 0;
        //     }
        // }
        // return res;

        // int n = nums.length;
        // long res = 0;
        // for(int left=0, right=0; right<n; ++right) {
        //     left = right;
        //     while(right < n && nums[right] == 0) {
        //         ++right;
        //         res += right - left;
        //     }
        // }
        // return res;
        
        int n = nums.length;
        long res = 0;
        for(int i=0, j=0; j<n; ++j) {
            if(nums[j] != 0) {
                i = j + 1;
            }
            res += j - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,0,0,2,0,0,4};
        System.out.println(zeroFilledSubarray(nums));
    }
}