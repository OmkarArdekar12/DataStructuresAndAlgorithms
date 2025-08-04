// Sliding Window Median

import java.util.*;

public class SlidingWindowMedian {
    static List<Integer> window;
    static int windowSize;
    static double findMedian() {
        if(windowSize % 2 == 0) {
            return ((double)window.get(windowSize / 2 - 1) + window.get(windowSize / 2)) / 2.0;
        }
        return (double)(window.get(windowSize / 2));
    }
    static int binarySearch(int target) {
        int si = 0, ei = window.size() - 1;
        while(si <= ei) {
            int mid = (si + (ei - si) / 2);
            int val = window.get(mid);
            if(val == target) {
                return mid;
            } else if(val < target) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return -(si + 1);
    }
    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        window = new ArrayList<>();
        windowSize = k;
        for(int i=0; i<k; ++i) {
            window.add(nums[i]);
        }
        Collections.sort(window);

        double res[] = new double[n - k + 1];
        res[0] = findMedian();
        for(int i=k; i<n; ++i) {
            int out = nums[i - k];
            int outIdx = binarySearch(out);
            window.remove(outIdx);
            int in = nums[i];
            int inIdx = binarySearch(in);
            inIdx = inIdx < 0 ? -(inIdx + 1) : inIdx;
            window.add(inIdx, in);
            res[i - k + 1] = findMedian();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
}