// Minimum Time to Revert Word to Initial State II

public class MinimumTimeToRevertWordToInitialStateII {
    // static int[] computeLPS(String s) {
    //     int n = s.length();
    //     int lps[] = new int[n];
    //     int prevLps = 0;
    //     int i = 1;
    //     lps[0] = 0;
    //     while(i < n) {
    //         if(s.charAt(prevLps) == s.charAt(i)) {
    //             ++prevLps;
    //             lps[i] = prevLps;
    //             ++i;
    //         } else {
    //             if(prevLps == 0) {
    //                 lps[i] = prevLps;
    //                 ++i;
    //             } else {
    //                 prevLps = lps[prevLps - 1];
    //             }
    //         }
    //     }
    //     return lps;
    // }
    public static int minimumTimeToInitialState(String word, int k) {
        int n = word.length();

        int lps = 0;
        int dp[] = new int[n];
        dp[0] = 0;
        for(int i=1; i<n; ++i) {
            while(lps > 0 && word.charAt(lps) != word.charAt(i)) {
                lps = dp[lps - 1];
            }
            // dp[i] = lps = lps + (word.charAt(lps) == word.charAt(i) ? 1 : 0);
            lps = lps + (word.charAt(lps) == word.charAt(i) ? 1 : 0);
            dp[i] = lps;
        }

        while(lps > 0 && (n - lps) % k > 0) {
            lps = dp[lps - 1];
        }

        int minTime = (n - lps + k - 1) / k;

        return minTime;

        // int n = word.length();
        // int lps[] = computeLPS(word);
        // int longestPrefixSuffix = lps[n - 1];
        // while(longestPrefixSuffix > 0 && ((n - longestPrefixSuffix) % k) != 0) {
        //     longestPrefixSuffix = lps[longestPrefixSuffix - 1];
        // }        
        // int minTime = (n - longestPrefixSuffix) % k == 0 ? (n - longestPrefixSuffix) / k : (n + k - 1) / k;
        // return minTime;

        // int n = word.length();
        // int lps[] = new int[n]; //KMP LPS
        // int prevLps = 0;
        // int i = 1;
        // lps[0] = 0;
        // while(i < n) {
        //     if(word.charAt(i) == word.charAt(prevLps)) {
        //         ++prevLps;
        //         lps[i] = prevLps;
        //         ++i;
        //     } else {
        //         if(prevLps == 0) {
        //             lps[i] = 0;
        //             ++i;
        //         } else {
        //             prevLps = lps[prevLps - 1];
        //         }
        //     }
        // }
        // int suffixLength = lps[n - 1];
        // while(suffixLength > 0 && (n - suffixLength) % k != 0) {
        //     suffixLength = lps[suffixLength - 1];
        // }
        // if((n - suffixLength) % k == 0) {
        //     return (n - suffixLength) / k;
        // }
        // // return (int)(Math.ceil(n / (double)k)); //(n + k - 1) / k;
        // return (n + k - 1) / k;
    }

    public static void main(String[] args) {
        String word = "abcxyzabc"; int k = 3;
        System.out.println(minimumTimeToInitialState(word, k));
    }
}