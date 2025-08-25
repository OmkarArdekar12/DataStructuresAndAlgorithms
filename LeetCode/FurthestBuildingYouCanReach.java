// Furthest Building You Can Reach

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<n; ++i) {
            int diff = heights[i] - heights[i - 1];
            if(diff > 0) {
                pq.add(diff);
            }
            if(pq.size() > ladders) {
                bricks -= pq.poll();
            }
            if(bricks < 0) {
                break;
            }

            res = i;
        }

        return res;

        // int n = heights.length;
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int i=0; i<n-1; ++i) {
        //     int diff = heights[i + 1] - heights[i];
        //     if(diff > 0) {
        //         pq.add(diff);
        //     }
        //     if(pq.size() > ladders) {
        //         bricks -= pq.poll();
        //     }
        //     if(bricks < 0) {
        //         return i;
        //     }
        // }
        // return n - 1;
    }

    public static void main(String[] args) {
        int heights[] = {2, 1, 3, 4, 6}, bricks = 1, ladders = 1;
        System.out.println(furthestBuilding(heights, bricks, ladders));
    }
}