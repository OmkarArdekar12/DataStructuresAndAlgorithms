// Sum of Subarray Minimums

public class SumOfSubarrayMinimums {
    static final int MOD = 1000000007;
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int res = 0;
        int dp[] = new int[n]; //store the sum of minimums of subarray ending at index i
        java.util.Stack<int[]> s = new java.util.Stack<>();
        for(int i=0; i<n; ++i) {
            while(!s.isEmpty() && s.peek()[1] >= arr[i]) {
                s.pop();
            }
            int j = s.isEmpty() ? -1 : s.peek()[0];
            //if there is no previousMinimum than the currentMinimum(arr[i]) element then, the currentMinimum will be
            //the minimum of all i+1 subarray that is subarray ending at ith idx that is arr[i] * (i + 1).
            //if there is previousMinimum than the currentMinimum(arr[i]) element then, the currentMinimum will be the 
            //the minimum of all subarray starting at previousMinimumIdx and ending at the currentIdx that is arr[i] * (i - j)
            //and plus adding the previousMinimumSum also. So that dp[i] will store the sum of all minimuns of all subarray ending at index i
            dp[i] = s.isEmpty() ? arr[i] * (i + 1) : dp[j] + arr[i] * (i - j);
            res = (res + dp[i]) % MOD;
            s.push(new int[]{i, arr[i]});            
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }
}
