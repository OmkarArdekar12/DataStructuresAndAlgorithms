// Double Modular Exponentiation

import java.util.*;
// import java.math.BigInteger;
public class DoubleModularExponentiation {
    // static long modularExponentiation(long x, long y, long mod) {
    //     long res = 1;
    //     while(y > 0) {
    //         if((y & 1) != 0) {
    //             res = (res * x) % mod;
    //         }

    //         x = (x * x) % mod;
    //         y >>= 1;
    //     }
    //     return res;
    // }
    static long modularExponentiation(long base, long exponent, long mod) {
        long res = 1;
        base %= mod;
        while(exponent > 0) {
            if((exponent & 1) != 0) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return res;
    }
    public static List<Integer> getGoodIndices(int[][] variables, int target) {
        int n = variables.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; ++i) {
            long a = variables[i][0];
            long b = variables[i][1];
            long c = variables[i][2];
            long m = variables[i][3];

            long first = modularExponentiation(a, b, 10);
            long second = modularExponentiation(first, c, m);
            int curr = (int)(second);

            if(curr == target) {
                res.add(i);
            }
        }
        return res;

        // int n = variables.length;
        // List<Integer> res = new ArrayList<>();
        // BigInteger t = BigInteger.valueOf(target);
        // for(int i=0; i<n; ++i) {
        //     BigInteger a = BigInteger.valueOf(variables[i][0]);
        //     int b = variables[i][1], c = variables[i][2];
        //     BigInteger m = BigInteger.valueOf(variables[i][3]);
        //     if(a.pow(b).mod(BigInteger.TEN).pow(c).mod(m).equals(t)) {
        //         res.add(i);
        //     }
        // }
        // return res;
    }

    public static void main(String args[]) {
        int variables[][] = {{2,3,3,10}, {3,3,3,1}, {6,1,1,4}}, target = 2;
        System.out.println(getGoodIndices(variables, target));
    }

}