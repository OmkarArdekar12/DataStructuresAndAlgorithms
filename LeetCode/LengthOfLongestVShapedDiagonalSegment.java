// Length of Longest V-Shaped Diagonal Segment

public class LengthOfLongestVShapedDiagonalSegment {
    static final int directions[][] = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    static int n, m, arr[][];
    static Integer dp[][][][];
    static int getMaxLenVDiagonal(int row, int col, int currDirection, int canTakeTurn, int target) {
        int nextRow = row + directions[currDirection][0];
        int nextCol = col + directions[currDirection][1];

        if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || arr[nextRow][nextCol] != target) {
            return 0;
        }

        if(dp[nextRow][nextCol][currDirection][canTakeTurn] != null) {
            return dp[nextRow][nextCol][currDirection][canTakeTurn];
        }

        int notTakeTurn = 1 + getMaxLenVDiagonal(nextRow, nextCol, currDirection, canTakeTurn, 2 - target);
        int takeTurn = canTakeTurn == 0 ? 1 + getMaxLenVDiagonal(nextRow, nextCol, (currDirection + 1) % 4, 1 - canTakeTurn, 2 - target) : 0;
        dp[nextRow][nextCol][currDirection][canTakeTurn] = Math.max(notTakeTurn, takeTurn);

        return dp[nextRow][nextCol][currDirection][canTakeTurn];
    }
    public int lenOfVDiagonal(int[][] grid) { //TC = O(n * m)
        arr = grid;
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n][m][4][2]; //rows=n, cols=m, directions=4, choices=2=takeTurn,notTakeTurn
        int res = 0;
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                if(grid[i][j] == 1) { 
                    //starting point: 1->2->0->2->0...
                    //can take almost 1 turn in clockwise direction, that is can take turn 0 or 1 time only
                    for(int dir=0; dir<4; ++dir) {
                        res = Math.max(res, 1 + getMaxLenVDiagonal(i, j, dir, 0, 2));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,2,1,2,2},{2,0,2,2,0},{2,0,1,1,0},{1,0,2,2,2},{2,0,0,2,2}};
        LengthOfLongestVShapedDiagonalSegment obj = new LengthOfLongestVShapedDiagonalSegment();
        System.out.println(obj.lenOfVDiagonal(grid));
    }

    // static final int directions[][] = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    // static Integer memo[][][][];
    // static int getMaxLenVDiagonal(int grid[][], int i, int j, int dir, boolean canTakeTurn, int target) {
    //     int nextI = i + directions[dir][0];
    //     int nextJ = j + directions[dir][1];

    //     if(nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length || grid[nextI][nextJ] != target) {
    //         return 0;
    //     }

    //     if(memo[nextI][nextJ][dir][canTakeTurn ? 0 : 1] != null) {
    //         return memo[nextI][nextJ][dir][canTakeTurn ? 0 : 1];
    //     }

    //     int notTakeTurn = 1 + getMaxLenVDiagonal(grid, nextI, nextJ, dir, canTakeTurn, 2 - target);
    //     int takeTurn = canTakeTurn ? 1 + getMaxLenVDiagonal(grid, nextI, nextJ, (dir + 1) % 4, !canTakeTurn, 2 - target) : 0;
    //     memo[nextI][nextJ][dir][canTakeTurn ? 0 : 1] = Math.max(notTakeTurn, takeTurn);

    //     return memo[nextI][nextJ][dir][canTakeTurn ? 0 : 1];
    // }
    // public int lenOfVDiagonal(int[][] grid) { //TC = O(n * m)
    //     int n = grid.length, m = grid[0].length;
    //     memo = new Integer[n][m][4][2]; //rows=n, cols=m, directions=4, choices=2=takeTurn,notTakeTurn
    //     int res = 0;
    //     for(int i=0; i<n; ++i) {
    //         for(int j=0; j<m; ++j) {
    //             if(grid[i][j] == 1) { 
    //                 //starting point: 1->2->0->2->0...
    //                 //can take almost 1 turn in clockwise direction, that is can take turn 0 or 1 time only
    //                 for(int dir=0; dir<4; ++dir) {
    //                     res = Math.max(res, 1 + getMaxLenVDiagonal(grid, i, j, dir, true, 2));
    //                 }
    //             }
    //         }
    //     }

    //     return res;
    // }
    
    // static final int directions[][] = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    // static int getMaxLenVDiagonal(int grid[][], int i, int j, int dir, boolean canTakeTurn, int target) {
    //     int nextI = i + directions[dir][0];
    //     int nextJ = j + directions[dir][1];

    //     if(nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length || grid[nextI][nextJ] != target) {
    //         return 0;
    //     }

    //     int notTakeTurn = 1 + getMaxLenVDiagonal(grid, nextI, nextJ, dir, canTakeTurn, 2 - target);
    //     int takeTurn = canTakeTurn ? 1 + getMaxLenVDiagonal(grid, nextI, nextJ, (dir + 1) % 4, !canTakeTurn, 2 - target) : 0;

    //     return Math.max(notTakeTurn, takeTurn);
    // }
    // public int lenOfVDiagonal(int[][] grid) {
    //     int n = grid.length, m = grid[0].length;
    //     //TC = O(n * m), because we can take turn almost one time, that 0 or 1 time only taking turn
    //     //So, each cell is traverse maximum at 2 time only, so, Time complexity is O(2*n*m), that is O(n*m)
    //     int res = 0;
    //     for(int i=0; i<n; ++i) {
    //         for(int j=0; j<m; ++j) {
    //             if(grid[i][j] == 1) { 
    //                 //starting point: 1->2->0->2->0...
    //                 //can take almost 1 turn, that is can take turn 0 or 1 time only
    //                 for(int dir=0; dir<4; ++dir) {
    //                     res = Math.max(res, 1 + getMaxLenVDiagonal(grid, i, j, dir, true, 2));
    //                 }
    //             }
    //         }
    //     }
    //     return res;
    // }
}
