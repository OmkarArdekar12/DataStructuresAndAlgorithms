// Replace Non-Coprime Numbers in Array
// You are given an array of integers nums. Perform the following steps:
// Find any two adjacent numbers in nums that are non-coprime.
// If no such numbers are found, stop the process.
// Otherwise, delete the two numbers and replace them with their LCM (Least Common Multiple).
// Repeat this process as long as you keep finding two adjacent non-coprime numbers.
// Return the final modified array. It can be shown that replacing adjacent non-coprime numbers in any arbitrary order will lead to the same result.
// The test cases are generated such that the values in the final array are less than or equal to 108.
// Two values x and y are non-coprime if GCD(x, y) > 1 where GCD(x, y) is the Greatest Common Divisor of x and y.

import java.util.*;

public class ReplaceNonCoprimeNumbersinArray {
    static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    public static List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        Stack<Integer> res = new Stack<>();
        for(int i=0; i<n; ++i) {
            int curr = nums[i];
            while(true) {
                int last = res.isEmpty() ? 1 : res.peek();
                int gcdVal = gcd(last, curr);
                if(gcdVal == 1) { //the numbers are co-prime, so, stop the process
                    break;
                }
                curr *= res.pop() / gcdVal; //number are non-coprime, so replace them with there lcm
            }
            res.push(curr);
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {6, 4, 3, 2, 7, 6, 2};
        System.out.println(replaceNonCoprimes(nums));
    }
}
