// Valid Anagram

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        if(n != m) {
            return false;
        }

        int freq[] = new int[26];
        for(int i=0; i<n; ++i) {
            ++freq[s.charAt(i) - 'a'];
            --freq[t.charAt(i) - 'a'];
        }
        for(int i=0; i<26; ++i) {
            if(freq[i] != 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s= "anagram", t = "nagram";
        System.out.println(isAnagram(s, t));
    }
}