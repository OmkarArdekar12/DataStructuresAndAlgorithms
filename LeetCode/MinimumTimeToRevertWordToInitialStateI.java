// Minimum Time to Revert Word to Initial State I

public class MinimumTimeToRevertWordToInitialStateI {
    public static int[] getLPS(String s) {
        int n = s.length();

        int lps[] = new int[n];
        int prevLps = 0, i = 1;
        lps[0] = 0;
        while(i < n) {
            if(s.charAt(prevLps) == s.charAt(i)) {
                ++prevLps;
                lps[i] = prevLps;
                ++i;
            } else if(prevLps == 0) {
                lps[i] = prevLps;
                ++i;
            } else {
                prevLps = lps[prevLps - 1];
            }
        }

        return lps;
    }
    public static int minimumTimeToInitialState(String word, int k) {
        int n = word.length();

        int lps[] = getLPS(word);
        int longestPrefixSuffix = lps[n - 1];
        while(longestPrefixSuffix > 0 && (n - longestPrefixSuffix) % k != 0) {
            longestPrefixSuffix = lps[longestPrefixSuffix - 1];
        }

        if((n - longestPrefixSuffix) % k == 0) {
            return (n - longestPrefixSuffix) / k;
        }

        return (n + k - 1) / k;
        

        // int n = word.length();
        // int res = 1;
        // for(int i=k; i<n; i+=k) {
        //     boolean isLongestPrefixSuffix = true;
        //     for(int j=i; j<n; ++j) {
        //         if(word.charAt(j - i) != word.charAt(j)) {
        //             isLongestPrefixSuffix = false;
        //             break;
        //         }
        //     }
        //     if(isLongestPrefixSuffix) {
        //         break;
        //     }
        //     ++res;
        // }
        // return res;

        // int n = word.length();
        // int res = 1;
        // for(int i=k; i<n; i+=k) {
        //     if(word.substring(0, n-i).equals(word.substring(i))) {
        //         break;
        //     }
        //     ++res;
        // }
        // return res;
    }

    public static void main(String[] args) {
        String word = "abcxyzabc"; int k = 3;
        System.out.println(minimumTimeToInitialState(word, k));
    }
}