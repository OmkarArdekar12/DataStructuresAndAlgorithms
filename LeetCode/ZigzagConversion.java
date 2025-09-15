// Zigzag Conversion
// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
// (you may want to display this pattern in a fixed font for better legibility)
// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) { //base/edge/corner case
            return s;
        }

        int n = s.length();
        int k = (numRows - 1) * 2; //increment k steps
        StringBuilder result = new StringBuilder("");
        for(int i=0; i<numRows; ++i) {
            for(int j=i; j<n; j+=k) {
                result.append(s.charAt(j));
                if((i > 0) && (i < numRows-1) && ((j + (k - 2 * i)) < n)) { //adding the characters between the current scope of zigzag
                    result.append(s.charAt(j + (k - 2*i)));
                }                
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion obj = new ZigzagConversion();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(obj.convert(s, numRows));
    }
}