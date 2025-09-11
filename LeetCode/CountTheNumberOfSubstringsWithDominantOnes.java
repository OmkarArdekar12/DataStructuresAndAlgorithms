// Count the Number of Substrings With Dominant Ones

public class CountTheNumberOfSubstringsWithDominantOnes {
    public static int numberOfSubstrings(String s) {
        int n = s.length();

        int prefix[] = new int[n + 1];
        for(int i=0; i<n; ++i) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '0' ? 0 : 1);
        }

        int res = 0;
        for(int i=0; i<n; ++i) {
            for(int j=i; j<n; ++j) {
                int onesCount = prefix[j + 1] - prefix[i];
                int zerosCount = (j - i + 1) - onesCount;
                int zerosCountSq = zerosCount * zerosCount;

                if(zerosCountSq > onesCount) {
                    j += (zerosCountSq - onesCount - 1);
                } else if(zerosCountSq == onesCount) {
                    ++res;
                } else { //zerosCountSq < onesCount
                    ++res;
                    int diff = (int)(Math.sqrt(onesCount)) - zerosCount;
                    res += j + diff >= n ? (n - j - 1) : diff;
                    j += diff;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "00011";
        System.out.println(numberOfSubstrings(s));
    }
}
