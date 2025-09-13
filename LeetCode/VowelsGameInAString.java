// Vowels Game in a String

public class VowelsGameInAString {
    public static boolean doesAliceWin(String s) {
        int n = s.length();
        for(int i=0; i<n; ++i) {
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "code";
        System.out.println(doesAliceWin(s));
    }
}