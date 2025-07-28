// Length of Last Word
// Given a string s consisting of words and spaces, return the length of the last word in the string.
// A word is a maximal substring consisting of non-space characters only.

public class LengthOfLastWord {    
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();
        int spaceIdx = s.lastIndexOf(' ') + 1;
        int res = n - spaceIdx;

        return res;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }
}