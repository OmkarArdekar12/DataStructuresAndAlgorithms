// Integer to Roman
// Seven different symbols represent Roman numerals with the following values:
// Symbol	Value
// I	1
// V	5
// X	10
// L	50
// C	100
// D	500
// M	1000

public class IntegerToRoman {
    static final int integerVal[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static final String romanVal[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static final int N = integerVal.length;
    public static String intToRoman(int num) {
        StringBuilder res = new StringBuilder("");
        int intNumber = num;
        for(int i=0; i<N; ++i) {
            int quotient = intNumber / integerVal[i];
            if(quotient > 0) {
                res.append(romanVal[i].repeat(quotient));
                intNumber %= integerVal[i];
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        int num = 12;
        System.out.println(intToRoman(num));
    }
}