// Minimum Pair Removal to Sort Array I

public class MinimumPairRemovalToSortArrayI {
    public static int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        
        int res = 0;
        int currLength = n - 1; //size of current array
        while(currLength > 0) {
            boolean nonDecreasing = true;
            int minPairSum = Integer.MAX_VALUE, minPairSumIdx = -1;
            for(int i=0; i<currLength; ++i) {
                if(nums[i] > nums[i + 1]) {
                    nonDecreasing = false;
                }
                if(nums[i] + nums[i + 1] < minPairSum) { //finding the minimum sum adjacent pair
                    minPairSum = nums[i] + nums[i + 1];
                    minPairSumIdx = i;
                }
            }
            if(nonDecreasing) { //array is now non-decreasing
                break;
            }
            nums[minPairSumIdx] = minPairSum; //replacing the pair with their sum
            for(int i=minPairSumIdx+1; i<currLength; ++i) { //reducing the size of the array by shifting the values in array
                nums[i] = nums[i + 1];
            }
            --currLength; //decrement the size of the array
            ++res; //increasing the operations count by performing operation
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{5, 2, 3, 1}));
    }
}