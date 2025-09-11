// Find Minimum Cost to Remove Array Elements

import java.util.*;

public class FindMinimumCostToRemoveArrayElements {
    static int findMinCost(int prevIdx, int currIdx, int nums[], int dp[][]) {
        if(currIdx > nums.length) {
            return 0;
        }

        if(currIdx == nums.length) { //single element remaining
            return nums[prevIdx];
        }
        if(currIdx == nums.length - 1) { //two element remaining
            return Math.max(nums[prevIdx], nums[currIdx]);
        }

        if(dp[currIdx][prevIdx] != -1) {
            return dp[currIdx][prevIdx];
        }

        //currIdx = currIdx/secondElementIdxOfCurrentOperation, prevIdx = idxOfElementLeftFromPreviousOperation/firstElementIdxOfCurrentOperation
        int firstWay = Math.max(nums[prevIdx], nums[currIdx]) + findMinCost(currIdx + 1, currIdx + 2, nums, dp); //choosing 1st & 2nd
        int secondWay = Math.max(nums[prevIdx], nums[currIdx + 1]) + findMinCost(currIdx, currIdx + 2, nums, dp); //choosing 1st & 3rd
        int thirdWay = Math.max(nums[currIdx], nums[currIdx + 1]) + findMinCost(prevIdx, currIdx + 2, nums, dp); //choosing 2nd & 3rd

        dp[currIdx][prevIdx] = Math.min(firstWay, Math.min(secondWay, thirdWay));

        return dp[currIdx][prevIdx];
    }
    public static int minCost(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int res = findMinCost(0, 1, nums, dp);

        return res;        
    }

    public static void main(String[] args) {
        int nums[] = {6,2,8,4};
        System.out.println(minCost(nums));
    }
}