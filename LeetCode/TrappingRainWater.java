// Trapping Rain Water
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

public class TrappingRainWater {
    public static int trap(int[] height) {
        // int n = height.length;
        // int rightMax[] = new int[n];
        // int leftMax[] = new int[n];
        // leftMax[0] = height[0];
        // for(int i = 1; i < n; ++i) {
        //     leftMax[i] = Math.max(leftMax[i-1], height[i]);
        // }
        // rightMax[n-1] = height[n-1];
        // for(int i = n-2; i >= 0; --i) {
        //     rightMax[i] = Math.max(rightMax[i+1], height[i]);
        // }
        // int trapRainwater = 0;
        // int currWaterLevel = 0, barHeight = 0, barWidth = 1;
        // for(int i = 0; i < n; i++) {
        //     barHeight = height[i];
        //     currWaterLevel = Math.min(leftMax[i], rightMax[i]);
        //     trapRainwater += (currWaterLevel - barHeight) * barWidth;
        // }
        // return trapRainwater;
        int n = height.length;

        int trapRainwater = 0;
        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        while(left < right) {
            if(leftMax < rightMax) {
                ++left;
                leftMax = Math.max(leftMax, height[left]);
                trapRainwater += leftMax - height[left];
            } else {
                --right;
                rightMax = Math.max(rightMax, height[right]);
                trapRainwater += rightMax - height[right];
            }
        }

        return trapRainwater;
    }

    public static void main(String[] args) {
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
