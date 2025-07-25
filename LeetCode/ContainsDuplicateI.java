// Contains Duplicate
// Given an integer array nums, return true if any value appears at least twice in the array, 
// and return false if every element is distinct.

import java.util.*;

public class ContainsDuplicateI {
    public static boolean containsDuplicate(int[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; ++i) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}