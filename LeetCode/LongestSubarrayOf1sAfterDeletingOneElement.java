// Longest Subarray of 1's After Deleting One Element

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static int longestSubarray(int[] nums) {
        int n = nums.length;

        int res = 0;
        boolean isDeleted = false; int deletedPosition = -1;
        for(int i=0, j=0; j<n; ++j) {
            if(nums[j] == 0) {
                if(isDeleted) {
                    i = deletedPosition + 1;
                    isDeleted = false;
                    deletedPosition = -1;
                }

                isDeleted = true;
                deletedPosition = j;
            }

            res =  Math.max(res, j - i);
        }

        return res;

        // int n = nums.length;
        // int res = 0;
        // int i = 0, j = 0;
        // boolean isDeleted = false; int deletedPosition = -1;
        // while(j < n) {
        //     if(nums[j] == 1) {
        //         ++j;
        //     } else {
        //         if(isDeleted) {
        //             i = deletedPosition + 1;
        //         }
        //         isDeleted = true;
        //         deletedPosition = j;
        //         ++j;
        //     }
        //     res = Math.max(res, j - i - 1);
        // }
        // return res;

        // int n = nums.length;
        // int res = 0;
        // int i = 0, j = 0;
        // int currOnes = 0;
        // int deletedPosition = -1;
        // boolean isDelete = false;
        // while(j < n) {
        //     if(nums[j] == 1) {
        //         ++j;
        //         ++currOnes;
        //     } else if(nums[j] == 0 && !isDelete) {
        //         ++j;
        //         ++currOnes;
        //         isDelete = !isDelete;
        //         deletedPosition = j;
        //     } else {
        //         currOnes -= (deletedPosition - i);
        //         i = deletedPosition;
        //         isDelete = !isDelete;
        //     }
        //     res = Math.max(res, currOnes - 1);
        // }
        // return res;

        // int n = nums.length;
        // int res = 0;
        // int i = 0, j = 0;
        // int currOnes = 0;
        // boolean isDelete = false;
        // while(j < n) {
        //     if(nums[j] == 1) {
        //         ++j;
        //         ++currOnes;
        //     } else if(nums[j] == 0 && !isDelete) {
        //         ++j;
        //         ++currOnes;
        //         isDelete = !isDelete;
        //     } else {
        //         if(nums[i] != 1) {
        //             isDelete = !isDelete;
        //         }
        //         ++i;
        //         --currOnes;
        //     }
        //     res = Math.max(res, currOnes - 1);
        // }
        // return res;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,0,1};
        System.out.println(longestSubarray(nums));
    }
}