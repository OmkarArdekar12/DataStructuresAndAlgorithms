// Jump Game II
// You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
// Each element nums[i] represents the maximum length of a forward jump from index i. In other words, 
// if you are at nums[i], you can jump to any nums[i + j] where:
// 0 <= j <= nums[i] and i + j < n
// Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

public class JumpGameII {
    public static int jump(int[] nums) {
        int n = nums.length;
        
        int minJumps = 0;
        int maxReachableIdx = 0;
        for(int left=0, right=0; right<n-1; ++right) {
            maxReachableIdx = Math.max(maxReachableIdx, right + nums[right]);
            if(left == right) { //taking jumps to maxReachableIdx to leftIdx
                left = maxReachableIdx;
                ++minJumps;
            }
        }
    
        return minJumps;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}