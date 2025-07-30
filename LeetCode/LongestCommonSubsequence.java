// Longest Common Subsequence

public class LongestCommonSubsequence {
    //Dynamic Programming: Bottom-up approach (Tabulation)
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        if(n == 0 || m == 0) {
            return 0;
        }

        int dp[][] = new int[n + 1][m + 1];
        for(int i=1; i<=n; ++i) {
            for(int j=1; j<=m; ++j) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];
    }
    
    //Dynamic Programming: Top-down approach (Memoization)
    // public static int lcs(int m, int n, String a, String b, int dp[][]) {
    //     if(m == 0 || n == 0) {
    //         return 0;
    //     }
    //     if(dp[m][n] != -1) {
    //         return dp[m][n];
    //     }
    //     if(a.charAt(m - 1) == b.charAt(n - 1)) {
    //         dp[m][n] = 1 + lcs(m - 1, n - 1, a, b, dp);
    //     } else {
    //         dp[m][n] = Math.max(lcs(m, n - 1, a, b, dp), lcs(m - 1, n, a, b, dp));
    //     }
    //     return dp[m][n];
    // }
    // public static int longestCommonSubsequence(String text1, String text2) {
    //     int m = text1.length(), n = text2.length(); 
    //     int dp[][] = new int[m + 1][n + 1];
    //     for(int i=0; i<=m; ++i) {
    //         for(int j=0; j<=n; ++j) {
    //             dp[i][j] = -1;
    //         }
    //     }
    //     return lcs(m, n, text1, text2, dp);
    // }

    public static void main(String[] args) {
        String a = "abcde", b = "ace";
        System.out.println(longestCommonSubsequence(a, b));
    }
}