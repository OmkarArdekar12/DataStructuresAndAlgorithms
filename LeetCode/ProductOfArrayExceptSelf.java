// Product of Array Except Self
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.

import java.util.*;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int res[] = new int[n];
        int prefixProduct = 1, suffixProduct = 1;
        for(int i=0; i<n; ++i) {
            res[i] = prefixProduct;
            prefixProduct *= nums[i];
        }
        for(int i=n-1; i>=0; --i) {
            res[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}