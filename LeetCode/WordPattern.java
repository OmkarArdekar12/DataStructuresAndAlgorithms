// Word Pattern

import java.util.*;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String strs[] = s.split(" ");
        int n = pattern.length(), m = strs.length;
        if(n != m) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        for(int i=0; i<n; ++i) {
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch)) {
                if(reverseMap.containsKey(strs[i])) {
                    return false;
                }
                map.put(ch, strs[i]);
                reverseMap.put(strs[i], ch);
            } else {
                if(!map.get(ch).equals(strs[i])) {
                    return false;
                }
            }
        }
        return true;
        
        // String strs[] = s.split(" ");
        // int n = pattern.length(), m = strs.length;
        // if(n != m) {
        //     return false;
        // }
        // Map<Character, String> map = new HashMap<>();
        // for(int i=0; i<n; ++i) {
        //     char ch = pattern.charAt(i);
        //     if(!map.containsKey(ch)) {
        //         if(map.containsValue(strs[i])) {
        //             return false;
        //         }
        //         map.put(ch, strs[i]);
        //     } else {
        //         if(!map.get(ch).equals(strs[i])) {
        //             return false;
        //         }
        //     }
        // }
        // return true;
    }
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
}