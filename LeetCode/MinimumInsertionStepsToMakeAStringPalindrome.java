// Minimum Insertion Steps to Make a String Palindrome

public class MinimumInsertionStepsToMakeAStringPalindrome {
    //divide/split the string s into two equal parts/halfs
    //and try to make them symmetrical by adding letter to make the string s a palindrome
    //And find minimum insertion/addition of letter will take to make the string s a palindrome
    //So, more common symmetrical subsequence the two equal parts of string s have the less letters we need to insert/add
    //So, This problem is dynamic programming problem of to find the length of longest common sequence(lcs)
    public static int minInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[n + 1][n + 1];
        for(int i=0; i<n; ++i) {
            for(int j=0; j<n; ++j) {
                char a = s.charAt(i), b = s.charAt(n - 1 - j);
                dp[i + 1][j + 1] = a == b ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        int minInsertion = n - dp[n][n];
        return minInsertion;        
    }

    public static void main(String[] args) {
        String s = "mbadm";
        System.out.println(minInsertions(s));
    }
}