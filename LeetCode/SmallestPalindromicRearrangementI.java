// Smallest Palindromic Rearrangement I

public class SmallestPalindromicRearrangementI {
    //Logic: Input string s is palindromic string.
    //So, s can be even palindrome or odd palindrome
    //Even Palindrome will have the each character for even number of time.
    //Odd Palindrome will have the every character even number of time and one character for odd number time.
    //Intuition: Store the character with their frequency in the array in the sorted order of the characters
    //and try to make the palindromic string by traversing that array.
    public static String smallestPalindrome(String s) {
        int n = s.length();

        int arr[] = new int[26];
        for(int i=0; i<n; ++i) {
            ++arr[s.charAt(i) - 'a'];
        }

        StringBuilder start = new StringBuilder("");
        char mid = ' ';
        StringBuilder end = new StringBuilder("");
        for(int i=0; i<26; ++i) {
            while(arr[i] > 0) {
                if(arr[i] == 1) {
                    mid = (char)(i + 'a');
                    --arr[i];
                } else {
                    start.append((char)(i + 'a'));
                    end.insert(0, (char)(i + 'a'));
                    arr[i] -= 2;
                }
            }
        }

        if(mid != ' ') {
            start.append(mid).append(end);
        } else {
            start.append(end);
        }

        return start.toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestPalindrome("babab"));
    }
}