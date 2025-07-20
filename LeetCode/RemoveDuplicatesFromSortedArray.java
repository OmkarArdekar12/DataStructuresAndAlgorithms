// Remove Duplicates from Sorted Array
// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
// The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;

        int k = 0;
        for(int i=1; i<n; ++i) {
            if(nums[i] != nums[k]) {
                ++k;
                nums[k] = nums[i];
            }
        }

        return k + 1;
    }

    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(nums);
        int arr[] = Arrays.copyOf(nums, k);
        System.out.println(k + ", nums = " + Arrays.toString(arr));
    }
}
