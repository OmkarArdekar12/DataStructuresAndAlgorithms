// Find the Minimum Area to Cover All Ones I

public class FindTheMinimumAreaToCoverAllOnesI {
    public static int minimumArea(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int minI = n, maxI = 0;
        int minJ = m, maxJ = 0;
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                if(grid[i][j] == 1) {
                    minI = Math.min(minI, i);
                    maxI = Math.max(maxI, i);
                    minJ = Math.min(minJ, j);
                    maxJ = Math.max(maxJ, j);
                }
            }
        }
        int length = (maxJ - minJ + 1);
        int breath = (maxI - minI + 1);
        int minArea = length * breath;

        return minArea;
    }

    public static void main(String[] args) {
        int grid[][] = {{0,1,0}, {1,0,1}};
        System.out.println(minimumArea(grid));
    }
}
