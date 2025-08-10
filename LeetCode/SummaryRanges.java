// Summary Ranges

import java.util.*;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        int n = nums.length;

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<n; ++i) {
            int left = i, right = i;
            while(right+1 < n && nums[right] + 1 == nums[right + 1]) {
                ++right;
            }
            i = right;

            int rangeMin = nums[left], rangeMax = nums[right];
            if(rangeMin != rangeMax) {
                sb.append(rangeMin).append("->").append(rangeMax);
            } else {
                sb.append(rangeMin);
            }

            res.add(sb.toString());
            sb.setLength(0);
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}