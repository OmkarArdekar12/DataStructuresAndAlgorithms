// Two Sum II - Input Array Is Sorted

import java.util.*;

public class TwoSumIIInputArrayIsSorted {
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        int i = 0, j = n - 1;
        int res[] = new int[2];
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            } else if(sum < target) {
                ++i;
            } else {
                --j;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int numbers[] = {2,7,11,15}, target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}