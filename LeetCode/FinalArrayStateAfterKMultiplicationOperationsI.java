// Final Array State After K Multiplication Operations I

import java.util.Arrays;

public class FinalArrayStateAfterKMultiplicationOperationsI {
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        // int n = nums.length;
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]));
        // for(int i=0; i<n; ++i) {
        //     pq.add(new int[]{i, nums[i]});
        // }
        // while(!pq.isEmpty() && k > 0) {
        //     int curr[] = pq.remove();
        //     curr[1] *= multiplier;
        //     pq.add(curr);
        //     --k;
        // }
        // while(!pq.isEmpty()) {
        //     int curr[] = pq.remove();
        //     nums[curr[0]] = curr[1];
        // }
        // return nums;
        int n = nums.length;
        for(int i=0; i<k; ++i) {
            int minIdx = 0;
            for(int j=0; j<n; ++j) {
                if(nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            nums[minIdx] *= multiplier;
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = {2,1,3,5,6};
        int k = 5, multiplier = 2;
        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }
}