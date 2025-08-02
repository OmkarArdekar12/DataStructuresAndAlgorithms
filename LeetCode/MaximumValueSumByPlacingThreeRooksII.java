// Maximum Value Sum by Placing Three Rooks II

import java.util.*;

public class MaximumValueSumByPlacingThreeRooksII {
    static long maxValSum;
    static List<int[]> valuesList;
    static int size;
    static boolean rows[], cols[];
    public static void backtrackUtil(int idx, long currValSum, int rooksCount) {
        if(rooksCount == 3) {
            maxValSum = Math.max(maxValSum, currValSum);
            return;
        }
        if(idx >= size) {
            return;
        }

        long currVal = valuesList.get(idx)[0];
        int currRow = valuesList.get(idx)[1], currCol = valuesList.get(idx)[2];
        if(currValSum + (currVal * (3 - rooksCount)) < maxValSum) { //checking if it is possible to get newMaxValSum from here
            return;
        }

        backtrackUtil(idx + 1, currValSum, rooksCount); //taking the choice to not place the rook
        if(rows[currRow] || cols[currCol]) { //if rook is already placed at currRow or currCol, we can't placed the new rook there
            return;
        }
        rows[currRow] = cols[currCol] = true; //placing the currRook at currRow and currCol
        backtrackUtil(idx + 1, currValSum + currVal, rooksCount + 1); //taking the choice to placed the rook
        rows[currRow] = cols[currCol] = false; //unplacing/removing the currRook at currRow and currCol, Backtrack
        return;
    }
    public static long backtrack(List<int[]> values, int n, int m) {
        maxValSum = Long.MIN_VALUE;
        valuesList = values;
        size = values.size();
        Collections.sort(valuesList, (a, b) -> (b[0] - a[0])); //sorting the values in the decreasing order

        //visited rows and cols
        rows = new boolean[n]; //to track in which row is unsafe, mean in that row already a rook is placed
        cols = new boolean[m]; //to track in which col is unsafe, mean in that col already a rook is placed

        backtrackUtil(0, 0, 0);

        return maxValSum;
    }
    public static long maximumValueSum(int[][] board) {
        int n = board.length, m = board[0].length;

        //storing the top three(3 because we have to place the 3 Rooks) maxValues for each rows
        List<int[]> values = new ArrayList<>(); //stores in the 3 maxValues of each rows, values.get(i) = [val, rowIndex, colIndex]
        for(int i=0; i<n; ++i) { //traversing each row a finding the top3 maxValues for each row
            List<int[]> currRow = new ArrayList<>();
            int max1 = -1, max2 = -1, max3 = -1;
            for(int j=0; j<m; ++j) { //finding 3 maxValues in a row
                int curr[] = new int[3];
                curr[0] = board[i][j]; //val
                curr[1] = i; //row index
                curr[2] = j; //col index
                currRow.add(curr); //store the current value at index j
                if(max1 == -1 || curr[0] >= currRow.get(max1)[0]) {
                    max3 = max2;
                    max2 = max1;
                    max1 = j;
                } else if(max2 == -1 || curr[0] >= currRow.get(max2)[0]) {
                    max3 = max2;
                    max2 = j;
                } else if(max3 == -1 || curr[0] >= currRow.get(max3)[0]) {
                    max3 = j;
                }
            }
            values.add(currRow.get(max1));
            values.add(currRow.get(max2));
            values.add(currRow.get(max3));
        }

        long res = backtrack(values, n, m);

        return res;
    }

    public static void main(String[] args) {
        int[][] board = {{-3,1,1,1},{-3,1,-3,1},{-3,2,1,1}};
        System.out.println(maximumValueSum(board));
    }
}