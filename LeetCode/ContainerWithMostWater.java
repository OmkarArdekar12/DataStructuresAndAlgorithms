// Container With Most Water

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int n = height.length;

        int maxWater = 0;
        int left = 0, right = n - 1;
        while(left < right) {
            int currWt = right - left;
            int currHt = Math.min(height[left], height[right]);
            int currWater = currWt * currHt;
            maxWater = Math.max(maxWater, currWater);

            while(left < right && height[left] <= currHt) {
                ++left;
            }
            while(left < right && height[right] <= currHt) {
                --right;
            }
        }
        
        return maxWater;

        // int n = height.length;
        // int maxWater = 0;
        // int i = 0, j = n - 1;
        // while(i < j) {
        //     int wt = j - i;
        //     int ht = Math.min(height[i], height[j]);
        //     int currWater = wt * ht;
        //     maxWater = Math.max(maxWater, currWater);
        //     if(height[i] < height[j]) {
        //         ++i;
        //     } else {
        //         --j;
        //     }
        // }
        // return maxWater;
    }

    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}