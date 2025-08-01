// Final Array State After K Multiplication Operations II

import java.util.*;

public class FindArrayStateArrayAfterKMultiplicationOperationsII {
    //You will see that, after sometime we reach the iterating point, where the order repeats after
    //every n iteration.
    //Optimization takes place here:
    //1. We reach the iterating point, when the minVal surpass/pass the maxValue in the array if multiplied by multiplier
    //2. After that point the values repeats, so, we have to just multiply each values in 
    //the nums array by ((remaining k) / n) times
    //3. Here we are trying to minimized the calculation process/operations/steps
    static final int mod = 1000000007;
    public static long fastExpo(long a, long b) {
        long res = 1;
        while(b > 0) {
            if((b & 1) != 0) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        if(multiplier == 1) {
            return nums;
        }

        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]));
        int maxVal = 0;
        for(int i=0; i<n; ++i) {
            pq.add(new int[]{i, nums[i]});
            maxVal = Math.max(maxVal, nums[i]);
        }

        while(k > 0 && (maxVal / pq.peek()[1]) >= multiplier) {
            int curr[] = pq.remove();
            curr[1] *= multiplier;
            pq.add(curr);
            --k;
        }

        int times = k / n;
        int remainingK = k % n;
        long first = fastExpo(multiplier, times);
        long second = fastExpo(multiplier, times + 1);

        int res[] = new int[n];
        while(!pq.isEmpty()) {
            int curr[] = pq.remove();
            int idx = curr[0], val = curr[1];
            long m = remainingK > 0 ? second : first;
            long currVal = (m * val) % mod;
            res[idx] = (int)currVal;
            --remainingK;
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {2,1,3,5,6};
        int k = 5, multiplier = 2;
        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }
}