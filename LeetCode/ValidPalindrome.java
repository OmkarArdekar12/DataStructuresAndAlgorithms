// Valid Palindrome

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while(i < j) {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if(!(Character.isLetterOrDigit(start))) {
                i++;
                continue;
            }
            if(!(Character.isLetterOrDigit(end))) {
                j--;
                continue;
            }

            if(Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}