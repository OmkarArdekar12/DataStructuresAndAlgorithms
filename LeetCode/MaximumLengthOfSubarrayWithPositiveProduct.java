// Maximum Length of Subarray With Positive Product

public class MaximumLengthOfSubarrayWithPositiveProduct {
    public static int getMaxLen(int[] nums) {
        int n = nums.length;

        int res = 0;
        int positiveCount = 0, negativeCount = 0;
        for(int i=0; i<n; ++i) {
            int curr = nums[i];
            if(curr == 0) { //zero
                positiveCount = 0;
                negativeCount = 0;
            } else if(curr > 0) { //positive
                ++positiveCount;
                negativeCount = negativeCount != 0 ? negativeCount + 1 : 0;
            } else { //negative
                int prevPositiveCount = positiveCount;
                positiveCount = negativeCount != 0 ? negativeCount + 1 : 0;
                negativeCount = prevPositiveCount + 1;
            }
            res = Math.max(res, positiveCount);
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 0, -5, 3, 21, 3};
        System.out.println(getMaxLen(nums));
    }
}