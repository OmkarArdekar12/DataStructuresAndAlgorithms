// Minimum Cost to Make Arrays Identical

import java.util.*;

public class MinimumCostToMakeArraysIdentical {
    public static long minCost(int[] arr, int[] brr, long k) {
        int n = arr.length;

        long noRearrange = 0;
        for(int i=0; i<n; ++i) {
            noRearrange += Math.abs(arr[i] - brr[i]); //adding cost of x of add/substract operation
        }

        long rearrange = 0;
        Arrays.sort(arr);
        Arrays.sort(brr);
        for(int i=0; i<n; ++i) {
            rearrange += Math.abs(arr[i] - brr[i]); //adding cost of x of add/subtract operation
        }
        rearrange += k; //add fixed cost of k of rearranging operation

        long res = Math.min(noRearrange, rearrange);

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {-7,9,5}, brr[] = {7,-2,-5}; long k = 2;
        System.out.println(minCost(arr, brr, k));
    }
}