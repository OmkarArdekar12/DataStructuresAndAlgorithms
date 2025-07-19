// Merge Sorted Array
// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and 
// two integers m and n, representing the number of elements in nums1 and nums2 respectively.
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
// The final sorted array should not be returned by the function, but instead be stored 
// inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m 
// elements denote the elements that should be merged, and the last n elements are set to 0 and 
// should be ignored. nums2 has a length of n.

import java.util.*;

public class MergeSortedArray {
    public static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, x = m + n - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[x] = nums1[i];
                --i;
            } else {
                nums1[x] = nums2[j];
                --j;
            }
            --x;
        }

        while(i >= 0) {
            nums1[x] = nums1[i];
            --i;
            --x;
        }

        while(j >= 0) {
            nums1[x] = nums2[j];
            --j;
            --x;
        }
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        int m = nums1.length - nums2.length;
        int n = nums2.length;
        mergeSortedArray(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1)); //output: [1,2,2,3,5,6]
    }
}