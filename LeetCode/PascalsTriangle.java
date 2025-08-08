// Pascal's Triangle

import java.util.*;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int i=0; i<n; ++i) {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; ++j) {
                if(j == 0 || j == i) {
                    row.add(1);
                    continue;
                }
                row.add(pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));
            }
            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
