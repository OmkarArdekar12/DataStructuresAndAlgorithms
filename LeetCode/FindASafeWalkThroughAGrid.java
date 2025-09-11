// Find a Safe Walk Through a Grid

import java.util.*;

public class FindASafeWalkThroughAGrid {
    static final int directions[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        Queue<int[]> q = new LinkedList<>();
        boolean vis[][][] = new boolean[n][m][health + 1];
        q.add(new int[]{0, 0, health - grid.get(0).get(0)});
        vis[0][0][health - grid.get(0).get(0)] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int curr[] = q.remove();
                int x = curr[0], y = curr[1];
                int h = curr[2];

                if(x == n - 1 && y == m - 1 && h > 0) {
                    return true;
                }

                for(int dir[] : directions) {
                    int nxtX = x + dir[0];
                    int nxtY = y + dir[1];

                    if(nxtX < 0 || nxtY < 0 || nxtX >= n || nxtY >= m) {
                        continue;
                    }

                    int nxtH = h - grid.get(nxtX).get(nxtY);
                    if(nxtH < 0 || vis[nxtX][nxtY][nxtH]) {
                        continue;
                    }

                    q.add(new int[]{nxtX, nxtY, nxtH});
                    vis[nxtX][nxtY][nxtH] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int g[][] = {{0,1,0,0,0},{0,1,0,1,0},{0,0,0,1,0}}, health = 1;
        List<List<Integer>> grid = Arrays.stream(g).map(row -> Arrays.stream(row).boxed().toList()).toList();
        System.out.println(findSafeWalk(grid, health));
    }
}