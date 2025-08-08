// Fruit Into Baskets

import java.util.*;

public class FruitIntoBaskets {
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0, j=0; j<n; ++j) {
            int curr = fruits[j];
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            while(map.size() > 2) {
                curr = fruits[i];
                map.put(curr, map.get(curr) - 1);
                if(map.get(curr) == 0) {
                    map.remove(curr);
                }
                ++i;
            }
            res = Math.max(res, j - i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int fruits[] = {1, 2, 3, 2, 2};
        System.out.println(totalFruit(fruits));
    }
}
