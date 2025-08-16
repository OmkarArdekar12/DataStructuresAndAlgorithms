// Max Value of Equation

import java.util.*;

public class MaxValueOfEquation {
    static class Pair<K, V> {
        K key;
        V val;

        public Pair(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.val;
        }

        @Override
        public String toString() {
            return "(" + this.key + ", " + this.val + ")";
        }
    }

    public static int findMaxValueOfEquation(int[][] points, int k) {
        //Logic
        //to find the maxPair such that -> Yi + Yj + |Xi - Xj|
        //points are sorted in the x coordinates -> Xi < Xj, 0 <= i < j <= points.length
        //So, Yi + Yj + Xj - Xi
        //So, Yi - Xi + Xj + Yj
        //So, we can maintain the priorityqueue of Pair, and key can be Yi - Xi and value Xi
        //Key Yi - Xi, required to sort priorityqueue pairs according to it
        //Value Xi needs to check constraint of |Xi - Xj| <= k
        // int n = points.length;
        // int res = Integer.MIN_VALUE;
        // PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getKey() != b.getKey() ? b.getKey() - a.getKey() : a.getValue() - b.getValue()));
        // for(int i=0; i<n; ++i) {
        //     int x = points[i][0], y = points[i][1];
        //     while(!pq.isEmpty() && x - pq.peek().getValue() > k) {
        //         pq.remove();
        //     }
        //     if(!pq.isEmpty()) {
        //         res = Math.max(res, pq.peek().getKey() + x + y);
        //     }
        //     pq.add(new Pair<>(y - x, x));
        // }
        // return res;       
         
        // int n = points.length;
        // int res = Integer.MIN_VALUE;
        // Deque<Pair<Integer, Integer>> dq = new ArrayDeque<>();
        // for(int i=0; i<n; ++i) {
        //     int x = points[i][0], y = points[i][1];
        //     while(!dq.isEmpty() && x - dq.peekFirst().getValue() > k) {
        //         dq.removeFirst();
        //     }
        //     if(!dq.isEmpty()) {
        //         res = Math.max(res, dq.peekFirst().getKey() + x + y);
        //     }
        //     while(!dq.isEmpty() && (y - x) > dq.peekLast().getKey()) {
        //         dq.removeLast();
        //     }
        //     dq.addLast(new Pair<>(y - x, x));
        // }
        // return res;    

        int n = points.length;
        int res = Integer.MIN_VALUE;
        Deque<AbstractMap.SimpleEntry<Integer, Integer>> dq = new ArrayDeque<>();
        for(int i=0; i<n; ++i) {
            int x = points[i][0], y = points[i][1];
            while(!dq.isEmpty() && x - dq.peekFirst().getValue() > k) {
                dq.removeFirst();
            }
            if(!dq.isEmpty()) {
                res = Math.max(res, dq.peekFirst().getKey() + x + y);
            }
            while(!dq.isEmpty() && (y - x) > dq.peekLast().getKey()) {
                dq.removeLast();
            }
            dq.addLast(new AbstractMap.SimpleEntry<>(y - x, x));
        }
        return res;        
    }

    public static void main(String[] args) {
        int points[][] = {{1,3},{2,0},{5,10},{6,-10}}, k = 1;
        System.out.println(findMaxValueOfEquation(points, k));
    }
}