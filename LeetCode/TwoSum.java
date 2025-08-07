// Two Sum

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int res[] = new int[2];
        res[0] = res[1] = -1;
        for(int i=0; i<n; ++i) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                res[0] = map.get(complement);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }
}