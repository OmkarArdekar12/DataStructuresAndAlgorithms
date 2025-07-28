// Roman to Integer
// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000

public class RomanToInteger {
    public static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public static int romanToInt(String s) {
        int n = s.length();

        int intVal = 0, prev = 0, curr = 0;
        for(int i=n-1; i>=0; --i) {
            curr = getValue(s.charAt(i));
            if(prev > curr) {
                intVal -= curr;
            } else {
                intVal += curr;
            }  
            prev = curr;
        }        

        return intVal;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}