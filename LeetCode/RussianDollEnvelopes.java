// Russian Doll Envelopes

import java.util.*;

public class RussianDollEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));
        int dp[] = new int[n];
        int res = 0;
        for(int i=0; i<n; ++i) {
            int ht = envelopes[i][1];
            int idx = Arrays.binarySearch(dp, 0, res, ht);
            idx = idx < 0 ? -(idx + 1) : idx;
            if(idx == res) {
                ++res;
            }
            dp[idx] = ht;
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }
}