// Group Anagrams

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<n; ++i) {
            char curr[] = strs[i].toCharArray();
            Arrays.sort(curr);
            String str = new String(curr);
            if(map.containsKey(str)) {
                map.get(str).add(strs[i]);
            } else {
                map.put(str, new ArrayList<>());
                map.get(str).add(strs[i]);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(String key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
    }
}