// Vowel Spellchecker

import java.util.*;

public class VowelSpellchecker {
    static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
    static String skipVowels(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<n; ++i) {
            char ch = s.charAt(i);
            sb.append(isVowel(ch) ? "*" : ch);
        }
        return sb.toString();
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = wordlist.length;
        int m = queries.length;

        HashSet<String> set = new HashSet<>();
        HashMap<String, String> lowerCaseToCapital = new HashMap<>();
        HashMap<String, String> lowerCaseVowelToOriginal = new HashMap<>();
        for(int i=0; i<n; ++i) {
            String str = wordlist[i];
            String lowerCaseStr = str.toLowerCase();
            String lowerCaseVowelStr = skipVowels(lowerCaseStr);

            set.add(str);
            lowerCaseToCapital.putIfAbsent(lowerCaseStr, str);
            lowerCaseVowelToOriginal.putIfAbsent(lowerCaseVowelStr, str);
        }

        String res[] = new String[m];
        for(int i=0; i<m; ++i) {
            String query = queries[i];
            String lowerCaseQuery = query.toLowerCase();
            String lowerCaseVowelQuery = skipVowels(lowerCaseQuery);

            if(set.contains(query)) {
                res[i] = query;
            } else if(lowerCaseToCapital.containsKey(lowerCaseQuery)) {
                res[i] = lowerCaseToCapital.get(lowerCaseQuery);
            } else if(lowerCaseVowelToOriginal.containsKey(lowerCaseVowelQuery)) {
                res[i] = lowerCaseVowelToOriginal.get(lowerCaseVowelQuery);
            } else {
                res[i] = "";
            }
        }

        return res;        
    }
}