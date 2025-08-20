// Count Square Submatrices with All Ones

public class CountSquareSubmatricesWithAllOnes {
    public static int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int res = 0;
        int dp[][] = new int[n+1][m+1];
        for(int i=1; i<=n; ++i) {
            for(int j=1; j<=m; ++j) {
                if(matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                res += dp[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int matrix[][] = {{0, 1, 1, 1}, {0, 1, 1, 1}, {0, 1, 1, 1}, {0, 0, 0, 0}};
        System.out.println(countSquares(matrix));
    }
}