// Maximum Fruits Harvested After at Most K Steps

public class MaximumFruitsHarvestedAfterAtMostKSteps {
    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int res = 0, sum = 0;
        for(int i=0, j=0; j<n; ++j) {
            int currAmount = fruits[j][1];
            sum += currAmount;
            int leftPos = fruits[i][0];
            int rightPos = fruits[j][0];
            int step = (Math.min(Math.abs(startPos - rightPos), Math.abs(startPos - leftPos))) + (rightPos - leftPos);
            while(i <= j && step > k) {
                sum -= fruits[i][1];
                ++i;
                if(i <= j) {
                    leftPos = fruits[i][0];
                    rightPos = fruits[j][0];
                    step = (Math.min(Math.abs(startPos - rightPos), Math.abs(startPos - leftPos))) + (rightPos - leftPos);
                }
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int fruits[][] = {{2,8}, {6,3}, {8,6}};
        int startPos = 5, k = 4;
        System.out.println(maxTotalFruits(fruits, startPos, k));
    }
}