// Sort Vowels in a String

public class SortVowelsInAString {
    static boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
    public static String sortVowels(String s) {
        int n = s.length();

        int freq[] = new int[128];
        int vowelsCount = 0;
        for(int i=0; i<n; ++i) {
            char ch = s.charAt(i);
            if(isVowel(ch)) {
                ++freq[ch];
                ++vowelsCount;
            }
        }

        char vowels[] = new char[vowelsCount];
        for(int i=0, j=0; i<128; ++i) {
            while(freq[i] > 0) {
                vowels[j] = (char)(i);
                ++j;               
                --freq[i];
            }
        }

        StringBuilder res = new StringBuilder("");
        for(int i=0, j=0; i<n; ++i) {
            char ch = s.charAt(i);
            res.append(isVowel(ch) ? vowels[j++] : ch);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "lEetcOde";
        System.out.println(sortVowels(s));
    }
}