// Diagonal Traverse

import java.util.Arrays;

public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        int size = n * m;
        int res[] = new int[size];
        int row = 0, col = 0;
        int idx = 0;
        boolean up = true;
        while(idx < size) {
            res[idx] = mat[row][col];
            if(up) {
                if(col == m - 1) {
                    ++row;
                    up = false;
                } else if(row == 0) {
                    ++col;
                    up = false;
                } else {
                    --row;
                    ++col;
                }
            } else {
                if(row == n - 1) {
                    ++col;
                    up = true;
                } else if(col == 0) {
                    ++row;
                    up = true;
                } else {
                    ++row;
                    --col;
                }
            }
            ++idx;
        }
        
        return res;

        // int n = mat.length, m = mat[0].length;
        // Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        // int diagonals = (n - 1) + (m - 1);
        // for(int i=0; i<=diagonals; ++i) {
        //     map.put(i, new ArrayList<>());
        // }
        // for(int i=0; i<n; ++i) {
        //     for(int j=0; j<m; ++j) {
        //         map.get(i + j).add(mat[i][j]);
        //     }
        // }
        // int res[] = new int[n * m];
        // int x = 0; 
        // for(int i=0; i<=diagonals; ++i) {
        //     int size = map.get(i).size();
        //     if(i % 2 != 0) {
        //         for(int j=0; j<size; ++j) {
        //             res[x++] = map.get(i).get(j);
        //         }
        //     } else {
        //         for(int j=size-1; j>=0; --j) {
        //             res[x++] = map.get(i).get(j);
        //         }
        //     }
        // }
        // return res;

        // int n = mat.length, m = mat[0].length;
        // Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        // int diagonals = (n - 1) + (m - 1);
        // for(int i=0; i<=diagonals; ++i) {
        //     map.put(i, new ArrayList<>());
        // }
        // for(int i=0; i<n; ++i) {
        //     for(int j=0; j<m; ++j) {
        //         if((i + j) % 2 != 0) {
        //             map.get(i + j).add(mat[i][j]);
        //         } else {
        //             map.get(i + j).add(0, mat[i][j]);
        //         }
        //     }
        // }
        // int res[] = new int[n * m];
        // int x = 0; 
        // for(int i=0; i<=diagonals; ++i) {
        //     int size = map.get(i).size();
        //     for(int j=0; j<size; ++j) {
        //         res[x++] = map.get(i).get(j);
        //     }
        // }
        // return res;
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }
}