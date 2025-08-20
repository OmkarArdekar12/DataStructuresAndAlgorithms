// Count Almost Equal Pairs I

public class CountAlmostEqualPairsI {
    static boolean isAlmostEqual(int a, int b) {
        int diffCount = 0;
        int mismatch1 = -1, mismatch2 = -1;
        while(a > 0 || b > 0) {
            int lastDigitA = a % 10;
            int lastDigitB = b % 10;
            if(lastDigitA != lastDigitB) {
                if(diffCount >= 2) {
                    return false;
                } else if(diffCount == 1) {
                    boolean isEqual = lastDigitA == mismatch2 && lastDigitB == mismatch1;
                    if(!isEqual) {
                        return false;
                    }
                    ++diffCount;
                } else {
                    ++diffCount;
                    mismatch1 = lastDigitA;
                    mismatch2 = lastDigitB;
                }
            }
            a /= 10;
            b /= 10;
        }

        return diffCount == 0 || diffCount == 2;

        // String s1 = Integer.toString(a);
        // String s2 = Integer.toString(b);
        // //padding the shorter string with leading zeros
        // if(s1.length() < s2.length()) {
        //     s1 = "0".repeat(s2.length() - s1.length()) + s1;
        // }
        // if(s2.length() < s1.length()) {
        //     s2 = "0".repeat(s1.length() - s2.length()) + s2;
        // }
        // int m = s1.length();
        // int diffCount = 0;
        // int firstMismatchIdx = -1, secondMismatchIdx = -1;
        // for(int i=0; i<m; ++i) {
        //     if(s1.charAt(i) != s2.charAt(i)) {
        //         ++diffCount;
        //         if(diffCount == 1) {
        //             firstMismatchIdx = i;
        //         } else if(diffCount == 2) {
        //             secondMismatchIdx = i;
        //         } else {
        //             return false;
        //         }
        //     }
        // }
        // if(diffCount != 2) {
        //     return false;
        // }
        // char s1Array[] = s1.toCharArray();
        // char temp = s1Array[firstMismatchIdx];
        // s1Array[firstMismatchIdx] = s1Array[secondMismatchIdx];
        // s1Array[secondMismatchIdx] = temp;
        // s1 = new String(s1Array);
        // return s1.equals(s2);
    }
    public static int countPairs(int[] nums) { 
        //TC = O(N^3) - using string & array logic in isAlmostEqual helper method
        //TC = O((N^2)*log10(max(nums))) - using math logic in isAlmostEqual helper method
        int n = nums.length;

        int res = 0;
        for(int i=0; i<n; ++i) {
            for(int j=i+1; j<n; ++j) {
                if((nums[i] == nums[j]) || isAlmostEqual(nums[i], nums[j])) {
                    ++res;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {3, 12, 21, 30};
        System.out.println(countPairs(nums));
    }
}