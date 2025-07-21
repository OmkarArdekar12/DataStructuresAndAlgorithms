// Rotate Array
// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

import java.util.Arrays;

public class RotateArray {
    static int arr[];
    public static void reverse(int i, int j) {
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i;
            --j;
        }
        return;
    }
    
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        arr = nums;
        reverse(0, n - 1);
        reverse(0, k - 1);
        reverse(k, n - 1);
        return;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
