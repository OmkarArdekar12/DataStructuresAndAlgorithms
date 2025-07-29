// Reverse Words in a String
// Given an input string s, reverse the order of the words.
// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
// Return a string of the words in reverse order concatenated by a single space.
// Note that s may contain leading or trailing spaces or multiple spaces between two words. 
// The returned string should only have a single space separating the words. Do not include any extra spaces.

public class ReverseWordsInAString {    
    public static String reverseWords(String s) {
        s = s.trim(); //removing extra spaces from start and end
        int n = s.length();
        StringBuilder res = new StringBuilder("");
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<n; ++i) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                res.insert(0, sb);
                res.insert(0, ' ');
                int j = i;
                while(j < n && ch == ' ') { //removing extra spaces from the middle/in-between
                    ++j;
                    ch = s.charAt(j);
                }
                i = j - 1;
                sb = new StringBuilder("");
            } else {
                sb.append(ch);
            }
        }
        res.insert(0, sb);
        return res.toString();
    }

    public static void main(String[] args) {
        String s = " a good   example   ";
        System.out.println(reverseWords(s));
    }
}