// Sort Matrix by Diagonals

import java.util.*;

public class SortMatrixByDiagonals {
    public static int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<n; ++i) {
            for(int j=0; j<n; ++j) {
                if(!map.containsKey(i - j)) {
                    map.put(i-j, new ArrayList<>());
                }
                map.get(i-j).add(grid[i][j]);
            }
        }

        for(int key : map.keySet()) {
            if(key < 0) {
                Collections.sort(map.get(key));
            } else {
                Collections.sort(map.get(key), Comparator.reverseOrder());
            }
        }

        for(int i=0; i<n; ++i) {
            for(int j=0; j<n; ++j) {
                grid[i][j] = map.get(i - j).get(Math.min(i, j));
            }
        }

        return grid;
    }

    public static void main(String[] args) {
        int grid[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int res[][] = sortMatrix(grid);
        for(int r[] : res) {
            System.out.println(Arrays.toString(r));
        }
    }
}