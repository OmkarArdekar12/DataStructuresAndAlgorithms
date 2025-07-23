// Maximum Erasure Value
// You are given an array of positive integers nums and want to erase a subarray containing unique elements. 
// The score you get by erasing the subarray is equal to the sum of its elements.
// Return the maximum score you can get by erasing exactly one subarray.

public class MaximumErasureValue {
    public static int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        
        int prefixSum[] = new int[n + 1];
        int lastSeenIdx[] = new int[10001]; //can use the HashMap also
        int maxScore = 0;
        for(int i=0, j=0; j<n; ++j) {
            prefixSum[j + 1] = prefixSum[j] + nums[j];
            int curr = nums[j];
    
            if(lastSeenIdx[curr] != 0) {
                i = Math.max(i, lastSeenIdx[curr]);
            }
    
            int score = prefixSum[j + 1] - prefixSum[i];
            maxScore = Math.max(maxScore, score);
    
            lastSeenIdx[curr] = j + 1;
        }
    
        return maxScore;
    }

    public static void main(String[] args) {
        int nums[] = {4, 2, 4, 5, 6};
        System.out.println(maximumUniqueSubarray(nums));
    }
}
