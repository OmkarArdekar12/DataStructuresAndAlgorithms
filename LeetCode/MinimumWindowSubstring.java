// Minimum Window Substring

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(m < n) {
            return "";
        }    

        int freq[] = new int[128];
        for(int i=0; i<n; ++i) {
            ++freq[t.charAt(i)];
        }

        int minStart = 0, minLength = Integer.MAX_VALUE;
        int count = 0;
        for(int left=0, right=0; right<m; ++right) {
            char ch = s.charAt(right);
            if(freq[ch] > 0) {
                ++count;
            }
            --freq[ch];
            while(count == n) {
                int currLength = right - left + 1;
                if(currLength < minLength) {
                    minLength = currLength;
                    minStart = left;
                }
                char c = s.charAt(left);
                ++freq[c];
                if(freq[c] > 0) {
                    --count;
                }
                ++left;
            }
        }
        String res = minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
        
        return res;

        // int n = s.length(), m = t.length();
        // if(n < m) {
        //     return "";
        // }    
        // Map<Character, Integer> map = new HashMap<>();
        // for(int i=0; i<m; ++i) {
        //     char ch = t.charAt(i);
        //     map.put(ch, map.getOrDefault(ch, 0) + 1);
        // }
        // int minStart = 0, minLength = Integer.MAX_VALUE;
        // int count = m;
        // int i = 0, j = 0;
        // while(j < n) {
        //     char ch = s.charAt(j);
        //     if(map.getOrDefault(ch, 0) > 0) {
        //         --count;
        //     }
        //     map.put(ch, map.getOrDefault(ch, 0) - 1);
        //     while(count == 0) {
        //         if(j - i + 1 < minLength) {
        //             minLength = j - i + 1;
        //             minStart = i;
        //         }
        //         ch = s.charAt(i);
        //         map.put(ch, map.getOrDefault(ch, 0) + 1);
        //         if(map.get(ch) > 0) {
        //             ++count;
        //         }
        //         ++i;
        //     }
        //     ++j;
        // }
        // return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}