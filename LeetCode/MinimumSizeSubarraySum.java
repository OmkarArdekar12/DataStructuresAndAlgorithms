// Minimum Size Subarray Sum

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        // int res = Integer.MAX_VALUE;
        int res = n + 1;
        int sum = 0;
        for(int i=0, j=0; j<n; ++j) {
            sum += nums[j];
            while(i <= j && sum >= target) {
                sum -= nums[i];
                res = Math.min(res, j - i + 1);
                ++i;
            }
        }
        // return res != Integer.MAX_VALUE ? res : 0;
        return res % (n + 1);
    }

    public static void main(String[] args) {
        int target = 7;
        int nums[] = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }
}