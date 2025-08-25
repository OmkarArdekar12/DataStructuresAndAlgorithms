// Maximum Subarray Sum with One Deletion

public class MaximumSubarraySumWithOneDeletion {
    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int prefixSum[] = new int[n + 1];
        for(int i=0; i<n; ++i) {
            prefixSum[i + 1] = Math.max(prefixSum[i] + arr[i], arr[i]);
            maxSum = Math.max(maxSum, prefixSum[i + 1]);
        }
        int suffixSum[] = new int[n + 1];
        for(int i=n-1; i>=0; --i) {
            suffixSum[i] = Math.max(arr[i] + suffixSum[i + 1], arr[i]);
            maxSum = Math.max(maxSum, suffixSum[i]);
        }
        for(int i=1; i<n-1; ++i) {
            maxSum = Math.max(maxSum, prefixSum[i] + suffixSum[i + 1]);
        }
        return maxSum;

        // int n = arr.length;
        // if(n == 1) {
        //     return arr[0];
        // }
        // int maxSum = Integer.MIN_VALUE;
        // int prefixSum[] = new int[n];
        // prefixSum[0] = arr[0];
        // for(int i=1; i<n; ++i) {
        //     prefixSum[i] = Math.max(prefixSum[i - 1] + arr[i], arr[i]);
        //     maxSum = Math.max(maxSum, prefixSum[i]);
        // }
        // int suffixSum[] = new int[n];
        // suffixSum[n-1] = arr[n-1];
        // for(int i=n-2; i>=0; --i) {
        //     suffixSum[i] = Math.max(arr[i] + suffixSum[i + 1], arr[i]);
        //     maxSum = Math.max(maxSum, suffixSum[i]);
        // }
        // for(int i=1; i<n-1; ++i) {
        //     maxSum = Math.max(maxSum, prefixSum[i - 1] + suffixSum[i + 1]);
        // }
        // return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, -2, 5, -6, 7, 8};
        System.out.println(maximumSum(arr));
    }
}
