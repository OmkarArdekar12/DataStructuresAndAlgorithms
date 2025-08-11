// Range Product Queries of Powers

import java.util.*;

public class RangeProductQueriesOfPowers {
    static final int mod = 1000000007;
    public static int[] productQueries(int n, int[][] queries) {
        // TC = O(q * log(n))
        // int m = queries.length;
        // List<Integer> powers = new ArrayList<>();
        // int x = n, powerOf2 = 1;
        // while(x > 0) {
        //     int bit = x % 2;
        //     if(bit == 1) {
        //         powers.add(powerOf2);
        //     }
        //     powerOf2 *= 2;
        //     x /= 2;
        // }
        // int res[] = new int[m];
        // for(int i=0; i<m; ++i) {
        //     int left = queries[i][0], right = queries[i][1];
        //     long currRes = 1;
        //     for(int j=left; j<=right; ++j) {
        //         currRes = (currRes * powers.get(j)) % mod;
        //     }
        //     res[i] = (int)currRes;
        // }
        // return res;

        //TC = O(log^2(n) + q)
        // int m = queries.length;
        // List<Integer> powers = new ArrayList<>();
        // int x = n, powerOf2 = 1;
        // while(x > 0) {
        //     int bit = x % 2;
        //     if(bit == 1) {
        //         powers.add(powerOf2);
        //     }
        //     powerOf2 *= 2;
        //     x /= 2;
        // }

        // int p = powers.size();
        // int prefix[][] = new int[p][p];
        // for(int i=0; i<p; ++i) {
        //     long curr = 1;
        //     for(int j=i; j<p; ++j) {
        //         curr = (curr * powers.get(j)) % mod;
        //         prefix[i][j] = (int)(curr);
        //     }
        // }

        // int res[] = new int[m];
        // for(int i=0; i<m; ++i) {
        //     int left = queries[i][0], right = queries[i][1];
        //     res[i] = prefix[left][right];
        // }
        // return res;

        //TC = O(log^2(n) + q)
        int m = queries.length;
        int p = Integer.bitCount(n);
        int powers[] = new int[p];
        int x = n, powerOf2 = 1, idx = 0;
        while(x > 0) {
            int bit = x % 2;
            if(bit == 1) {
                powers[idx] = powerOf2;
                ++idx;
            }
            powerOf2 *= 2;
            x /= 2;
        }

        int prefix[][] = new int[p][p];
        for(int i=0; i<p; ++i) {
            long curr = 1;
            for(int j=i; j<p; ++j) {
                curr = (curr * powers[j]) % mod;
                prefix[i][j] = (int)(curr);
            }
        }

        int res[] = new int[m];
        for(int i=0; i<m; ++i) {
            int left = queries[i][0], right = queries[i][1];
            res[i] = prefix[left][right];
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 15, queries[][] = {{0,1}, {2,2}, {3,3}};
        System.out.println(Arrays.toString(productQueries(n, queries)));
    }
}