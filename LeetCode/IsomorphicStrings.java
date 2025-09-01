// Isomorphic Strings

import java.util.*;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<n; ++i) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)) {
                if(map.get(a) != b) {
                    return false;
                }
            } else {
                if(map.containsValue(b)) {
                    return false;
                }
            }
            map.put(a, b);
        }
        return true;
        
        // int n = s.length();
        // Map<Character, Character> map1 = new HashMap<>();
        // Map<Character, Character> map2 = new HashMap<>();
        // for(int i=0; i<n; ++i) {
        //     char a = s.charAt(i);
        //     char b = t.charAt(i);
        //     if(map1.containsKey(a)) {
        //         if(map1.get(a) != b) {
        //             return false;
        //         }
        //     } else {
        //         if(map2.containsKey(b)) {
        //             return false;
        //         }
        //         map1.put(a, b);
        //         map2.put(b, a);
        //     }
        // }
        // return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }
}