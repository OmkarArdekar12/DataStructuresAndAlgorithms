// Longest Substring Without Repeating Characters

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        // int n = s.length();
        // int res = 0;
        // Map<Character, Integer> map = new HashMap<>();
        // for(int i=0, j=0; j<n; ++j) {
        //     char ch = s.charAt(j);
        //     i = Math.max(i, map.getOrDefault(ch, -1) + 1);
        //     res = Math.max(res, j - i + 1);
        //     map.put(ch, j);
        // }
        // return res;
        int n = s.length();
        int res = 0;
        int asciiLastSeenIdx[] = new int[128];
        for(int i=0, j=0; j<n; ++j) {
            char ch = s.charAt(j);
            i = Math.max(i, asciiLastSeenIdx[ch]);
            res = Math.max(res, j - i + 1);
            asciiLastSeenIdx[ch] = j + 1;
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}