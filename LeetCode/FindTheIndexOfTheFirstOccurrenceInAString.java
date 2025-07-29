// Find the Index of the First Occurrence in a String
// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, 
// or -1 if needle is not part of haystack.

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();

        int lps[] = new int[n]; //hold the longest prefix suffix values
        lps[0] = 0;
        int prevLps = 0, i = 1, j = 0; //prevLps = previous longest prefix sufix
        while(i < n) {
            if(needle.charAt(i) == needle.charAt(prevLps)) {
                lps[i] = prevLps + 1;
                ++prevLps;
                ++i;
            } else if(prevLps == 0) {
                lps[i] = prevLps; //that is 0
                ++i;
            } else { //if prevLps != 0
                prevLps = lps[prevLps - 1];
            }
        }

        i = 0; //for haystack that is for text string / target string
        j = 0; //for needle that is for pattern string
        while(i < m) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                if(j == 0) {
                    ++i;
                } else {
                    j = lps[j - 1];
                }
            }

            if(j == n) {
                return i - j; //index
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "leetcode", needle = "code";
        System.out.println(strStr(haystack, needle));
    }
}