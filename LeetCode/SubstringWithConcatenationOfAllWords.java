// Substring with Concatenation of All Words

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int m = words.length, k = words[0].length();

        List<Integer> res = new ArrayList<>();

        if(n < (m * k)) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(int i=0; i<k; ++i) {
            Map<String, Integer> windowMap = new HashMap<>();
            int left = i, right = i;
            int count = 0;

            while(right + k <= n) {
                String rightWord = s.substring(right, right + k);
                right += k;
                if(map.containsKey(rightWord)) {
                    windowMap.put(rightWord, windowMap.getOrDefault(rightWord, 0) + 1);
                    ++count;
                    while(windowMap.get(rightWord) > map.get(rightWord)) {
                        String leftWord = s.substring(left, left + k);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += k;
                        --count;
                    }
                    if(count == m) {
                        res.add(left);
                    }
                } else {
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return res;

        // int n = s.length();
        // int x = words.length, y = words[0].length();
        // Map<String, Integer> map = new HashMap<>();
        // for(int i=0; i<x; ++i) {
        //     map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        // }
        // List<Integer> res = new ArrayList<>();
        // int size = n - x * y + 1;
        // for(int i=0; i<size; ++i) {
        //     Map<String, Integer> currMap = new HashMap<>();
        //     int j = 0;
        //     while(j < x) {
        //         String word = s.substring((i + j * y), (i + (j + 1) * y));
        //         if(map.containsKey(word)) {
        //             currMap.put(word, currMap.getOrDefault(word, 0) + 1);
        //             if(currMap.get(word) > map.getOrDefault(word, 0)) {
        //                 break;
        //             }
        //         } else {
        //             break;
        //         }
        //         ++j;
        //     }
        //     if(j == x) {
        //         res.add(i);
        //     }
        // }
        // return res;
    }
    
    public static void main(String[] args) {
        String s = "barfoothefoobarman", words[] = {"foo","bar"};
        System.out.println(findSubstring(s, words));
    }
}