// Ransom Note

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int n = magazine.length(), m = ransomNote.length();

        int freq[] = new int[26];
        for(int i=0; i<n; ++i) {
            char ch = magazine.charAt(i);
            ++freq[ch - 'a'];
        }

        for(int i=0; i<m; ++i) {
            char ch = ransomNote.charAt(i);
            if(freq[ch - 'a'] == 0) {
                return false;
            }
            --freq[ch - 'a'];
        }

        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}