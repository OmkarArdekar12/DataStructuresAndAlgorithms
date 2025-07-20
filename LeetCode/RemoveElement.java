// Remove Element
// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
// The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;

        int k = 0;
        for(int i=0; i<n; ++i) {
            if(nums[i] != val) {
                nums[k] = nums[i];
                ++k;
            }
        }
        
        return k;
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 2, 3};
        int k = removeElement(nums, 3);
        int arr[] = Arrays.copyOf(nums, k);
        System.out.println(k + ", nums = " + Arrays.toString(arr));
    }
}