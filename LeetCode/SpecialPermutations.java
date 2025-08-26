// Special Permutations

public class SpecialPermutations {
    // static final int MOD = 1000000007;
    // static Integer memo[][];
    // static int arr[], n;
    // static int backtrack(int prevIdx, int bitMask) {
    //     if(bitMask == ((1 << n) - 1)) {
    //         return 1;
    //     }
    //     if(memo[prevIdx][bitMask] != null) {
    //         return memo[prevIdx][bitMask];
    //     }
    //     int count = 0;
    //     for(int i=0; i<n; ++i) {
    //         if(((bitMask & (1 << i)) == 0) && (bitMask == 0 || arr[prevIdx] % arr[i] == 0 || arr[i] % arr[prevIdx] == 0)) {
    //             count = (count + backtrack(i, bitMask | (1 << i))) % MOD;
    //         }
    //     }
    //     return memo[prevIdx][bitMask] = count;
    // }
    static final int mod = 1000000007;
    static Integer dp[][];
    static int arr[], n;
    static int getSpecialPermutations(int prevIdx, int currIdx, int mask) {
        if(currIdx == n) {
            return 1;
        }

        if(dp[prevIdx + 1][mask] != null) {
            return dp[prevIdx + 1][mask];
        }
        int count = 0;
        for(int i=0; i<n; ++i) {
            if((mask & (1 << i)) != 0) {
                continue;
            }

            if(prevIdx == -1 || arr[i] % arr[prevIdx] == 0 || arr[prevIdx] % arr[i] == 0) {
                count += getSpecialPermutations(i, currIdx + 1, mask | (1 << i));
                count %= mod;
            }
        }
        dp[prevIdx + 1][mask] = count;

        return count;
    }

    //TC = O((N^2) * (2^N))
    public static int specialPerm(int[] nums) {
        n = nums.length;
        arr = nums;
        dp = new Integer[n + 1][1 << n];
        // int res = backtrack(0, 0);
        int res = getSpecialPermutations(-1, 0, 0);

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 6};
        System.out.println(specialPerm(nums));
    }
}