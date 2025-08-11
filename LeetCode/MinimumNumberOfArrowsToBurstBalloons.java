// Minimum Number of Arrows to Burst Balloons

import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n <= 1) {
            return n;
        }

        //overlapping points will required the same arrow, and non-overlapping points will required extra arrows
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); //sorting the points according to Xend
        int arrows = 1; //AtLeast single arrow will be required according to the constraints(1 <= points.length <= 10^5)
        int prevXEnd = points[0][1]; 
        for(int i=1; i<n; ++i) {
            int currXStart = points[i][0], currXEnd = points[i][1];
            if(prevXEnd < currXStart) { //if previous Xend is less current Xstart than the points are non-overlapping.
                ++arrows;
                prevXEnd = currXEnd; //updating the previous End, as the points are sorted in increasing order of the Xend
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(findMinArrowShots(points));
    }
}