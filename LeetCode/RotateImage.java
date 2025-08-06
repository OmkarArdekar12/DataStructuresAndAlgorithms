// Rotate Image

import java.util.*;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        // int n = matrix.length;
        // for(int i=0; i<n; ++i) {
        //     for(int j=0; j<i; ++j) {
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[j][i];
        //         matrix[j][i] = temp;
        //     }
        // }
        // int k = 0;
        // while(k < n/2) {
        //     for(int i=0; i<n; ++i) {
        //         int temp = matrix[i][k];
        //         matrix[i][k] = matrix[i][n-1-k];
        //         matrix[i][n-1-k] = temp;
        //     }
        //     k++;
        // }
        // return;
        int n = matrix.length;
        for(int i=0; i<n; ++i) {
            for(int j=i; j<n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<n; ++i) {
            for(int j=0; j<n/2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        for(int r[] : matrix) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println();
        rotate(matrix);
        for(int r[] : matrix) {
            System.out.println(Arrays.toString(r));
        }
    }
}