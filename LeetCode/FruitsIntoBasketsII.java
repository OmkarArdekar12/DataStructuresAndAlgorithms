// Fruits Into Baskets II

public class FruitsIntoBasketsII {
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        int unplacedCount = 0;
        boolean usedBaskets[] = new boolean[n];
        for(int i=0; i<n; ++i) {
            int currFruit = fruits[i];
            boolean isPlace = false;
            for(int j=0; j<n; ++j) {
                if(!usedBaskets[j] && (baskets[j] >= currFruit)) {
                    usedBaskets[j] = true;
                    isPlace = true;
                    break;
                }
            }
            if(!isPlace) {
                ++unplacedCount;
            }
        }

        return unplacedCount;
    }

    public static void main(String[] args) {
        int fruits[] = {4, 2, 5};
        int baskets[] = {3, 5, 4};
        System.out.println(numOfUnplacedFruits(fruits, baskets));
    }
}
