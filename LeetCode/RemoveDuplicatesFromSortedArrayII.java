// Remove Duplicates from Sorted Array II
// Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. 
// The relative order of the elements should be kept the same.

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;

        int k = 0;
        for(int i=0; i<n; ++i) {
            if(k < 2 || nums[k - 2] < nums[i]) {
                nums[k] = nums[i];
                ++k;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,1,2,3,3};
        int k = removeDuplicates(nums);
        int arr[] = Arrays.copyOf(nums, k);
        System.out.println(k + ", nums = " + Arrays.toString(arr));
    }
}
