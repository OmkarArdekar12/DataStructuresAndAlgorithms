// Spiral Matrix

import java.util.*;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        List<Integer> res = new ArrayList<>();
        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = m - 1;
        while(startRow <= endRow && startCol <= endCol) {
            for(int j=startCol; j<=endCol; ++j) { //upper boundary
                res.add(matrix[startRow][j]);
            }
            for(int i=startRow+1; i<=endRow; ++i) { //right boundary
                res.add(matrix[i][endCol]);
            }
            for(int j=endCol-1; j>=startCol; --j) { //bottom boundary
                if(startRow == endRow) { //if upper boundary and bottom boundary are same
                    break;
                }
                res.add(matrix[endRow][j]);
            }
            for(int i=endRow-1; i>=startRow+1; --i) { //left boundary
                if(startCol == endCol) { //if left boundary and right boundary are same
                    break;
                }
                res.add(matrix[i][startCol]);
            }
            ++startRow;
            --endRow;
            ++startCol;
            --endCol;
        }

        return res;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
