// Longest Increasing Path in a Matrix

import java.util.*;

public class LongestIncreasingPathInAMatrix {
    static final int dirs[] = {0, -1, 0, 1, 0};
    static List<Integer> graph[];
    static int inDegree[];
    static int size;
    static List<Integer> topologicalSortKahnAlgo() {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<size; ++i) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while(!q.isEmpty()) {
            int currNode = q.remove();
            order.add(currNode);
            for(int neighbor : graph[currNode]) {
                --inDegree[neighbor];
                if(inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return order;
    }
    @SuppressWarnings("unchecked")
    public static int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        size = n * m;
        graph = new ArrayList[size];
        for(int i=0; i<size; ++i) {
            graph[i] = new ArrayList<>();
        }
        inDegree = new int[size];
        for(int row=0; row<n; ++row) {
            for(int col=0; col<m; ++col) {
                for(int d=0; d<4; ++d) {
                    int nxtRow = row + dirs[d];
                    int nxtCol = col + dirs[d + 1];
                    if(nxtRow < 0 || nxtRow >= n || nxtCol < 0 || nxtCol >= m) {
                        continue;
                    }
                    if(matrix[row][col] < matrix[nxtRow][nxtCol]) {
                        graph[row * m + col].add(nxtRow * m + nxtCol);
                        ++inDegree[nxtRow * m + nxtCol];
                    }
                }
            }
        }

        List<Integer> order = topologicalSortKahnAlgo();
        int dp[] = new int[size];
        for(int node : order) {
            for(int neighbor : graph[node]) {
                dp[neighbor] = Math.max(dp[neighbor], dp[node] + 1);
            }
        }
        int res = Arrays.stream(dp).max().getAsInt() + 1;

        return res;
    }
    // static final int directions[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    // static List<Integer> graph[];
    // static int inDegree[];
    // static int size;
    // static List<Integer> topologicalSortKahnAlgo() {
    //     Queue<Integer> q = new LinkedList<>();
    //     for(int i=0; i<size; ++i) {
    //         if(inDegree[i] == 0) {
    //             q.add(i);
    //         }
    //     }
    
    //     List<Integer> order = new ArrayList<>();
    //     while(!q.isEmpty()) {
    //         int currNode = q.remove();
    //         order.add(currNode);
    //         for(int neighbor : graph[currNode]) {
    //             --inDegree[neighbor];
    //             if(inDegree[neighbor] == 0) {
    //                 q.add(neighbor);
    //             }
    //         }
    //     }
    
    //     return order;
    // }
    // public static int longestIncreasingPath(int[][] matrix) {
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     size = n * m;
    //     graph = new ArrayList[size];
    //     for(int i=0; i<size; ++i) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     inDegree = new int[size];
    //     for(int row=0; row<n; ++row) {
    //         for(int col=0; col<m; ++col) {
    //             for(int d[] : directions) {
    //                 int nxtRow = row + d[0];
    //                 int nxtCol = col + d[1];
    //                 if(nxtRow < 0 || nxtRow >= n || nxtCol < 0 || nxtCol >= m) {
    //                     continue;
    //                 }
    //                 if(matrix[row][col] < matrix[nxtRow][nxtCol]) {
    //                     graph[row * m + col].add(nxtRow * m + nxtCol);
    //                     ++inDegree[nxtRow * m + nxtCol];
    //                 }
    //             }
    //         }
    //     }
    
    //     List<Integer> order = topologicalSortKahnAlgo();
    //     int dp[] = new int[size];
    //     Arrays.fill(dp, 1);
    //     int res = 1;
    //     for(int node : order) {
    //         for(int neighbor : graph[node]) {
    //             dp[neighbor] = Math.max(dp[neighbor], dp[node] + 1);
    //             res = Math.max(res, dp[neighbor]);
    //         }
    //     }
    
    //     return res;
    // }

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(matrix));
    }
}