// Smallest Palindromic Rearrangement II

public class SmallestPalindromicRearrangmentII {
    static long maxK = 1000001;
    public static long factorial(int total, int currCount) {
        if(currCount > total) {
            return 0;
        }
        if(currCount > total - currCount) {
            currCount = total - currCount;
        }
        long res = 1;
        for(int i=1; i<=currCount; ++i) {
            res = res * (total - i + 1) / i;
            if(res >= maxK) {
                return maxK;
            }
        }
        return res;
    }
    public static long permutations(int count[]) {
        int total = 0;
        for(int i : count) {
            total += i;
        }

        long res = 1;
        for(int i=0; i<26; ++i) {
            int currCount = count[i];
            res = res * factorial(total, currCount);
            if(res >= maxK) {
                return maxK;
            }
            total -= currCount;
        }

        return res;
    }
    public static String smallestPalindrome(String s, int k) {
        int n = s.length();
        int freq[] = new int[26];
        for(int i=0; i<n; ++i) {
            ++freq[s.charAt(i) - 'a'];
        }

        int oddFreqCount = 0;
        char midChar = ' ';
        for(int i=0; i<26; ++i) {
            if(freq[i] % 2 != 0) {
                ++oddFreqCount;
                midChar = (char)(i + 'a');
            }
        }

        if(oddFreqCount > 1) { //cannot possible to created palindrome
            return "";
        }

        int halfFreq[] = new int[26];
        int halfLength = 0;
        for(int i=0; i<26; ++i) {
            halfFreq[i] = freq[i] / 2;
            halfLength += halfFreq[i];
        }

        long totalPermutations = permutations(halfFreq);
        if(k > totalPermutations) { //totalPermuatations are less than the k permutations, can't get the kth permutation
            return "";
        }

        StringBuilder firstHalf = new StringBuilder("");
        for(int i=0; i<halfLength; ++i) {
            for(int ch=0; ch<26; ++ch) {
                if(halfFreq[ch] > 0) {
                    --halfFreq[ch];
                    long currPermutations = permutations(halfFreq);
                    if(currPermutations >= k) {
                        firstHalf.append((char)(ch + 'a'));
                        break;
                    } else {
                        k -= currPermutations;
                        ++halfFreq[ch];
                    }
                }
            }
        }
        String first = firstHalf.toString();
        String mid = midChar == ' ' ? "" : String.valueOf(midChar);
        String last = firstHalf.reverse().toString();
        String res = first + mid + last;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(smallestPalindrome("abba", 2));
    }
}