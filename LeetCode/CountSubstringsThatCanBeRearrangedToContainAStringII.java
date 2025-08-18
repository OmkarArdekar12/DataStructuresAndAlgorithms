// Count Substrings That Can Be Rearranged to Contain a String II

public class CountSubstringsThatCanBeRearrangedToContainAStringII {
    public static long validSubstringCount(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(int i=0; i<m; ++i) {
            ++freq2[word2.charAt(i) - 'a'];
        }

        long res = 0;
        int left = 0, right = 0;
        int window = 0;
        while(right < n) {
            char rightChar = word1.charAt(right);

            while(left <= right && window == m) {
                res += (n - right + 1);
                char leftChar = word1.charAt(left);
                --freq1[leftChar - 'a'];
                if(freq2[leftChar - 'a'] > 0 && freq1[leftChar - 'a'] < freq2[leftChar - 'a']) {
                    --window;
                }
                ++left;
            }

            if(freq2[rightChar - 'a'] > 0 && freq1[rightChar - 'a'] < freq2[rightChar - 'a']) {
                ++window;
            }
            ++freq1[rightChar - 'a'];

            ++right;
        }

        while(left <= right && window == m) {
            res += (n - right + 1);
            char leftChar = word1.charAt(left);
            --freq1[leftChar - 'a'];
            if(freq2[leftChar - 'a'] > 0 && freq1[leftChar - 'a'] < freq2[leftChar - 'a']) {
                --window;
            }
            ++left;
        }

        return res;
    }

    public static void main(String[] args) {
        String word1 = "bcca", word2 = "abc";
        System.out.println(validSubstringCount(word1, word2));
    }
}