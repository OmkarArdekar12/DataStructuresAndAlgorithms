// 3Sum

import java.util.*;

public class ThreeSum {
    static List<List<Integer>> res;
    public static void twoSum(int nums[], int left, int right, int target) {
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                res.add(List.of(-target, nums[left], nums[right]));
                ++left;
                --right;
                while(left < right && nums[left] == nums[left - 1]) {
                    ++left;
                }
                while(left < right && nums[right] == nums[right + 1]) {
                    --right;
                }
            } else if(sum < target) {
                ++left;
            } else {
                --right;
            }
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        res = new ArrayList<>();
        for(int i=0; i<n; ++i) {
            if(i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int left = i + 1, right = n - 1;
            int target = -nums[i];
            twoSum(nums, left, right, target);
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}