// Constrained Subsequence Sum

import java.util.*;

public class ConstrainedSubsequenceSum {
    public static int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;

        int res = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i=0; i<n; ++i) {
            if(pq.isEmpty()) {
                pq.add(new int[]{i, nums[i]});
                res = Math.max(res, nums[i]);
                continue;
            }

            while((i - pq.peek()[0]) > k) {
                pq.remove();
            }

            int curr = Math.max(0, pq.peek()[1]) + nums[i];
            res = Math.max(res, curr);
            pq.add(new int[]{i, curr});
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {10,2,-10,5,20}, k = 2;
        System.out.println(constrainedSubsetSum(nums, k));
    }
}