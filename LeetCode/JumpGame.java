// Jump Game
// You are given an integer array nums. You are initially positioned at the array's first index, 
// and each element in the array represents your maximum jump length at that position.
// Return true if you can reach the last index, or false otherwise.

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;

        int reachableIdx = 0;
        for(int i=0; i<n; ++i) {
            if(reachableIdx < i) { //can reach to currendIdx to impossible to reach lastIdx
                return false;
            }
            
            reachableIdx = Math.max(i + nums[i], reachableIdx);
    
            if(reachableIdx >= n - 1) { //can direct reach to the lastIdx
                return true;
            }
        }
    
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}