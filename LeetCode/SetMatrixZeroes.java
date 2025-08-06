// Set Matrix Zeroes

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] zeroRows = new boolean[m];
        boolean[] zeroCols = new boolean[n];
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(matrix[i][j] == 0) {
                    zeroRows[i] = zeroCols[j] = true;
                }
            }
        }
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,1,1}, {1,0,1}, {1,1,1}};
        for(int r[] : matrix) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println();
        setZeroes(matrix);
        for(int r[] : matrix) {
            System.out.println(Arrays.toString(r));
        }
    }
}
