// Majority Element
// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. 
// You may assume that the majority element always exists in the array.

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int res = 0, count = 0;
        for(int i=0; i<n; ++i) {
            int curr = nums[i];
            if(count == 0) {
                res = curr;
            }
            count += (res == curr) ? 1 : -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}