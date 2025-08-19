// Minimum Number of K Consecutive Bit Flips

public class MinimumNumberOfKConsecutiveBitFlips {
    //even number of flips don't change the bit value, odd number of flips change the bit value
    public static int minKBitFlips(int[] nums, int k) {
        int n = nums.length;

        boolean flipped[] = new boolean[n];
        int validFlipFromPastWindow = 0;
        int flipCount = 0;
        for(int i=0; i<n; ++i) {
            if(i >= k) {
                if(flipped[i - k]) { //decrementing the valid flips from the past window
                    --validFlipFromPastWindow;
                }
            }

            if(validFlipFromPastWindow % 2 == nums[i]) { //checking if current bit needs to flip or not
                if(i + k > n) { //can't from the k flip window
                    return -1;
                }
                ++validFlipFromPastWindow;
                flipped[i] = true;
                ++flipCount;
            }
        }

        return flipCount;
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 0}, k = 1;
        System.out.println(minKBitFlips(nums, k));
    }
}