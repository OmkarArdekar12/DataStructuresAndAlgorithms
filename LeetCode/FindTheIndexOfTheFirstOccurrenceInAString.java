// Find the Index of the First Occurrence in a String
// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, 
// or -1 if needle is not part of haystack.

public class FindTheIndexOfTheFirstOccurrenceInAString {
    static int[] computeLPS(String s) {
        int n = s.length();
        int lps[] = new int[n]; //lps = longest prefix suffix -> longest prefix and suffix that are equal
        lps[0] = 0;
        int i = 1;
        int len = 0;
        while(i < n) {
            if(s.charAt(i) == s.charAt(len)) {
                ++len;
                lps[i] = len;
                ++i;
            } else {
                if(len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    ++i;
                }
            }
        }
        return lps;
    }
    public static int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();

        int lps[] = computeLPS(needle);

        int i = 0; //for haystack that is for text/target string
        int j = 0; //for needle that is for pattern string
        int idx = -1;
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

            if(j == n) { //first occurrence found
                idx = i - j;
                break;                
            }
        }

        return idx;
        
        //KMP Algorithm
        // int m = haystack.length(), n = needle.length();
        // //lps = longest prefix suffix -> longest prefix and suffix that are equal
        // int lps[] = new int[n]; //hold the longest prefix suffix values
        // lps[0] = 0;
        // int prevLps = 0, i = 1, j = 0; //prevLps = previous longest prefix sufix
        // while(i < n) {
        //     if(needle.charAt(i) == needle.charAt(prevLps)) {
        //         lps[i] = prevLps + 1;
        //         ++prevLps;
        //         ++i;
        //     } else if(prevLps == 0) {
        //         lps[i] = prevLps; //that is 0
        //         ++i;
        //     } else { //if prevLps != 0
        //         prevLps = lps[prevLps - 1];
        //     }
        // }
        // i = 0; //for haystack that is for text string / target string
        // j = 0; //for needle that is for pattern string
        // while(i < m) {
        //     if(haystack.charAt(i) == needle.charAt(j)) {
        //         ++i;
        //         ++j;
        //     } else {
        //         if(j == 0) {
        //             ++i;
        //         } else {
        //             j = lps[j - 1];
        //         }
        //     }
        //     if(j == n) {
        //         return i - j; //index
        //     }
        // }
        // return -1;

        // int n = needle.length();
        // for(int i = 0, j = n-1; j < haystack.length(); i++, j++) {
        //     if((haystack.substring(i, j+1)).equals(needle)) {
        //         return i;
        //     }
        // }
        // return -1;        

    }
    // public static int strStr(String haystack, String needle) {
    //     int m = haystack.length(), n = needle.length();

    //     int lps[] = new int[n]; //hold the longest prefix suffix values
    //     lps[0] = 0;
    //     int prevLps = 0, i = 1, j = 0; //prevLps = previous longest prefix sufix
    //     while(i < n) {
    //         if(needle.charAt(i) == needle.charAt(prevLps)) {
    //             lps[i] = prevLps + 1;
    //             ++prevLps;
    //             ++i;
    //         } else if(prevLps == 0) {
    //             lps[i] = prevLps; //that is 0
    //             ++i;
    //         } else { //if prevLps != 0
    //             prevLps = lps[prevLps - 1];
    //         }
    //     }

    //     i = 0; //for haystack that is for text string / target string
    //     j = 0; //for needle that is for pattern string
    //     while(i < m) {
    //         if(haystack.charAt(i) == needle.charAt(j)) {
    //             ++i;
    //             ++j;
    //         } else {
    //             if(j == 0) {
    //                 ++i;
    //             } else {
    //                 j = lps[j - 1];
    //             }
    //         }

    //         if(j == n) {
    //             return i - j; //index
    //         }
    //     }

    //     return -1;
    // }
    public static void main(String[] args) {
        String haystack = "leetcode", needle = "code";
        System.out.println(strStr(haystack, needle));
    }
}