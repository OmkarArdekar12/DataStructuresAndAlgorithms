// Maximum Score From Removing Substrings
// You are given a string s and two integers x and y. You can perform two types of operations any number of times.
// Remove substring "ab" and gain x points.
// For example, when removing "ab" from "cabxbae" it becomes "cxbae".
// Remove substring "ba" and gain y points.
// For example, when removing "ba" from "cabxbae" it becomes "cabxe".
// Return the maximum points you can gain after applying the above operations on s..

public class MaximumScoreFromRemovingSubstrings {
    public static int maximumGain(String s, int x, int y) {
        int n = s.length();
        if(n < 2) {//base case
            return 0;
        }

        if(x < y) { //Ensure that x is highPrioirty and first finding the "ab" pair and remove them to get maxPoints
            int temp = x;
            x = y;
            y = temp;
            s = new StringBuilder(s).reverse().toString();
        }

        int aCount = 0, bCount = 0, maxScore = 0;
        for(int i=0; i<n; ++i) {
            char curr = s.charAt(i);
            if(curr == 'a') {//counting 'a'
                ++aCount;
            } else if(curr == 'b') {
                if(aCount > 0) { //forming 'ab' pair and removing them, and getting x points
                    --aCount;
                    maxScore += x;
                } else { //counting 'b'
                    ++bCount;
                }
            } else { //checking for 'ba' pairs, and resetting the count of a & b to 0
                //forming maximum amount of 'ba' pairs and removing them and getting y points
                maxScore += Math.min(aCount, bCount) * y; 
                aCount = bCount = 0;
            }
        }
        maxScore += Math.min(aCount, bCount) * y;

        return maxScore;
    }

    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x = 4, y = 5;
        System.out.println(maximumGain(s, x, y));
    }
}