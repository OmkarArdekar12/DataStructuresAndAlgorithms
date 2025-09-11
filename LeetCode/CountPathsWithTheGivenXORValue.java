// Count Paths With the Given XOR Value

public class CountPathsWithTheGivenXORValue {
    static final int mod = 1000000007;
    static Integer dp[][][];
    static int n, m;
    public static int dfs(int grid[][], int i, int j, int xor, int k) {
        if(i < 0 || j < 0 || i >= n || j >= m) {
            return 0;
        }

        xor ^= grid[i][j];

        if(i == n - 1 && j == m - 1) {
            return xor == k ? 1 : 0;
        }

        if(dp[i][j][xor] != null) {
            return dp[i][j][xor];
        }

        int right = dfs(grid, i, j+1, xor, k);
        int down = dfs(grid, i+1, j, xor, k);
        dp[i][j][xor] = (right + down) % mod;

        return dp[i][j][xor];
    }
    
    public static int countPathsWithXorValue(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n + 1][m + 1][16];
        int res = dfs(grid, 0, 0, 0, k);
        return res;
    }

    public static void main(String[] args) {
        int grid[][] = {{2, 1, 5}, {7, 10, 0}, {12, 6, 4}}, k = 11;
        System.out.println(countPathsWithXorValue(grid, k));
    }
}