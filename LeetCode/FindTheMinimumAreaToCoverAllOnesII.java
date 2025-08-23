// Find the Minimum Area to Cover All Ones II

public class FindTheMinimumAreaToCoverAllOnesII {
    static int calcMinimumSum(int grid[][], int a, int b, int c, int d) {
        int minI = grid.length, maxI = 0;
        int minJ = grid[0].length, maxJ = 0;
        for(int i=a; i<=b; ++i) {
            for(int j=c; j<=d; ++j) {
                if(grid[i][j] == 1) {
                    minI = Math.min(minI, i);
                    maxI = Math.max(maxI, i);
                    minJ = Math.min(minJ, j);
                    maxJ = Math.max(maxJ, j);
                }
            }
        }

        if(minI > maxI) {
            return Integer.MAX_VALUE / 3;
        }

        int length = maxJ - minJ + 1, breath = maxI - minI + 1;
        int maxArea = length * breath;
        return maxArea;
    }
    //total 6 choice: 3 (originalGrid) + 3 (counterClockwiseRotatedGrid)
    static int getMinimumSum(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;

        int res = n * m;
        for(int i=0; i+1<n; ++i) {
            for(int j=0; j+1<m; ++j) {
                //choice1:
                // ------
                // |||===
                int choice1 = calcMinimumSum(grid, 0, i, 0, m - 1) + 
                              calcMinimumSum(grid, i + 1, n - 1, 0, j) + 
                              calcMinimumSum(grid, i + 1, n - 1, j + 1, m - 1);
                //choice2:
                // ---|||
                // ------
                int choice2 = calcMinimumSum(grid, 0, i, 0, j) + 
                              calcMinimumSum(grid, 0, i, j + 1, m - 1) + 
                              calcMinimumSum(grid, i + 1, n - 1, 0, m - 1);
                
                res = Math.min(res, Math.min(choice1, choice2));
            }
        }
        for(int i=0; i+2<n; ++i) {
            for(int j=i+1; j+1<n; ++j) {
                //choice3:
                // ------
                // ||||||
                // ======
                int choice3 = calcMinimumSum(grid, 0, i, 0, m - 1) + 
                              calcMinimumSum(grid, i + 1, j, 0, m - 1) + 
                              calcMinimumSum(grid, j + 1, n - 1, 0, m - 1);
                res = Math.min(res, choice3);
            }
        }
        return res;
    }

    static int[][] rotate(int arr[][]) {
        int n = arr.length, m = arr[0].length;
        int rotated[][] = new int[m][n];
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                rotated[m - j - 1][i] = arr[i][j];
            }
        }
        return rotated;
    }

    public static int minimumSum(int[][] grid) {
        int rotateGrid[][] = rotate(grid); //rotate the grid by 90 degree in counter clockwise direction
        int res = Math.min(getMinimumSum(grid), getMinimumSum(rotateGrid));
        return res;
    }
    
    public static void main(String[] args) {
        int grid[][] = {{1, 0, 1}, {1, 1, 1}};
        System.out.println(minimumSum(grid));
    }
}
