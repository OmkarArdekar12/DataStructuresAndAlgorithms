// Insert Interval

import java.util.*;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]) { //non-overlapping intervals
            res.add(intervals[i]);
            ++i;
        }
        while(i < n && intervals[i][0] <= newInterval[1]) { //overlapping intervals
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            ++i;
        }
        res.add(newInterval); //adding merge interval
        while(i < n) { //non-overlapping intervals
            res.add(intervals[i]);
            ++i;
        }
        // return res.toArray(new int[res.size()][2]);
        int m = res.size();
        int result[][] = new int[m][2];
        for(i=0; i<m; ++i) {
            result[i] = res.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int intervals[][] = {{1,3}, {6,9}}, newInterval[] = {2,5};
        int res[][] = insert(intervals, newInterval);
        for(int i[] : res) {
            System.out.println(Arrays.toString(i));
        }
    }
}