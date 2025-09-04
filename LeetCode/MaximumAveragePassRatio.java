// Maximum Average Pass Ratio

import java.util.*;

public class MaximumAveragePassRatio {
    // static class Info {
    //     int pass;
    //     int total;
    //     double gain;

    //     public Info(int p, int t, double g) {
    //         this.pass = p;
    //         this.total = t;
    //         this.gain = g;
    //     }
    // }
    
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[2], a[2]));
        for(int i=0; i<n; ++i) {
            double pass = classes[i][0];
            double total = classes[i][1];
            double gain = ((pass + 1) / (total + 1)) - (pass / total);

            pq.add(new double[]{pass, total, gain});
        }

        for(int i=0; i<extraStudents; ++i) {
            double curr[] = pq.remove();
            double pass = curr[0], total = curr[1];

            double newPass = pass + 1, newTotal = total + 1;
            double newGain = ((newPass + 1) / (newTotal + 1)) - (newPass / newTotal);

            curr[0] = newPass;
            curr[1] = newTotal;
            curr[2] = newGain;

            pq.add(curr);
        }

        double res = 0;
        while(!pq.isEmpty()) {
            double curr[] = pq.remove();
            double pass = curr[0];
            double total = curr[1];
            res += (pass / total);
        }
        res /= n;

        return res;

        // int n = classes.length;
        // PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> Double.compare(b.gain, a.gain));
        // for(int i=0; i<n; ++i) {
        //     int pass = classes[i][0];
        //     int total = classes[i][1];
        //     double gain = ((pass + 1) / ((double)total + 1)) - (pass / (double)total);
        //     pq.add(new Info(pass, total, gain));
        // }
        // for(int i=0; i<extraStudents; ++i) {
        //     Info curr = pq.remove();
        //     int pass = curr.pass + 1;
        //     int total = curr.total + 1;
        //     double gain = ((pass + 1) / ((double)total + 1)) - (pass / (double)total);
        //     curr.pass = pass;
        //     curr.total = total;
        //     curr.gain = gain;
        //     pq.add(curr);
        // }
        // double res = 0;
        // while(!pq.isEmpty()) {
        //     Info curr = pq.remove();
        //     int pass = curr.pass;
        //     int total = curr.total;
        //     res += pass / (double)total;
        // }
        // res /= n;
        // return res;
    }
}