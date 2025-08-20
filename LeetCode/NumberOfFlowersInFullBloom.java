// Number of Flowers in Full Bloom
// You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] means the ith flower will be in full bloom from starti to endi (inclusive). 
// You are also given a 0-indexed integer array people of size n, where people[i] is the time that the ith person will arrive to see the flowers.

import java.util.*;

public class NumberOfFlowersInFullBloom {
    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        // int n = people.length;
        // int m = flowers.length;
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        // for(int i=0; i<n; ++i) {
        //     pq.add(new int[]{i, people[i]});
        // }

        // int res[] = new int[n];
        // Arrays.sort(flowers, (a, b) -> Arrays.compare(a, b));
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // int i = 0;
        // while(!pq.isEmpty()) {
        //     int curr[] = pq.remove();
        //     int idx = curr[0], personTime = curr[1];

        //     while(i < m && flowers[i][0] <= personTime) { //add flowers that are blooming
        //         minHeap.add(flowers[i][1]);
        //         ++i;
        //     }
        //     while(!minHeap.isEmpty() && minHeap.peek() < personTime) { //removing flowers that are not blooming
        //         minHeap.remove();
        //     }

        //     res[idx] = minHeap.size();
        // }

        // return res;

        int n = people.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for(int t[] : flowers) {
            map.put(t[0], map.getOrDefault(t[0], 0) + 1);
            map.put(t[1] + 1, map.getOrDefault(t[1] + 1, 0) - 1);
        }
        
        List<Integer> positions = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();
        int curr = 0;
        for(int key : map.keySet()) {
            positions.add(key);
            curr += map.get(key);
            prefix.add(curr);
        }
        
        int m = positions.size();
        int answer[] = new int[n];
        for(int i=0; i<n; ++i) {
            int left = 0, right = m;
            int target = people[i];
            while(left < right) {
                int mid = (left + (right - left) / 2);
                if(target < positions.get(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            answer[i] = prefix.get(left - 1);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int flowers[][] = {{1,6},{3,7},{9,12},{4,13}}, people[] = {2,3,7,11};
        System.out.println(Arrays.toString(fullBloomFlowers(flowers, people)));
    }
}
