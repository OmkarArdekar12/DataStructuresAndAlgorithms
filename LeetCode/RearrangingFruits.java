//Rearranging Fruits

import java.util.*;

public class RearrangingFruits {
    public static long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int minFruit = Integer.MAX_VALUE;
        for(int i=0; i<n; ++i) {
            int fruit1 = basket1[i], fruit2 = basket2[i];
            map.put(fruit1, map.getOrDefault(fruit1, 0) + 1);
            map.put(fruit2, map.getOrDefault(fruit2, 0) - 1);
            minFruit = Math.min(minFruit, Math.min(fruit1, fruit2));
        }

        List<Integer> merge = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if(count % 2 != 0) {
                return -1;
            }
            int size = Math.abs(count) / 2;
            for(int i=0; i<size; ++i) {
                merge.add(entry.getKey());
            }
        }

        Collections.sort(merge);
        int m = merge.size();
        long res = 0;
        for(int i=0; i<m/2; ++i) {
            res += Math.min(2 * minFruit, merge.get(i));
        }

        return res;
    }

    public static void main(String[] args) {
        int basket1[] = {4, 2, 2, 2}, basket2[] = {1, 4, 1, 2};
        System.out.println(minCost(basket1, basket2));
    }
}