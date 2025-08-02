// Minimum Pair Removal to Sort Array II

import java.util.*;

public class MinimumPairRemovalToSortArrayII {
    static class Pair {
        long sum;
        int index;
        Pair(long sum, int index) {
            this.sum = sum;
            this.index = index;
        }
        
        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair)o;
            return sum == pair.sum && index == pair.index;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(sum, index);
        }
    }
    public static int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        for(int i=0; i<n; ++i) {
            arr[i] = nums[i];
        } 
        
        TreeSet<Pair> pairsSet = new TreeSet<>(Comparator.comparingLong((Pair prevPairIdx) -> prevPairIdx.sum).thenComparingInt(prevPairIdx -> prevPairIdx.index));

        //storing the next and previous index of the current index
        int[] next = new int[n];
        int[] prev = new int[n];
        for(int i=0; i<n; ++i) {
            next[i] = i + 1;
            prev[i] = i - 1;
        }

        int count = 0; //decreasing pairs count
        for(int i=0; i<n-1; ++i) {
            if(arr[i] > arr[i + 1]) {
                ++count;
            }
            pairsSet.add(new Pair(arr[i] + arr[i + 1], i));
        }
        
        int res = 0;
        while(count > 0) {
            Pair currPair = pairsSet.pollFirst();
            int currIdx = currPair.index;
            int nextIdx = next[currIdx];
            int prevPairIdx = prev[currIdx];
            int nextPairIdx = next[nextIdx];
            long pairSum = currPair.sum;

            if(arr[currIdx] > arr[nextIdx]) { //undoing decreasing pair count
                --count;
            }

            if(prevPairIdx >= 0) { //if previousPairIndex is in bound
                if(arr[prevPairIdx] > arr[currIdx] && arr[prevPairIdx] <= pairSum) {
                    //by replacing the pair with pairSum array becomes non-decreasing
                    --count;
                } else if(arr[prevPairIdx] <= arr[currIdx] && arr[prevPairIdx] > pairSum) {
                    //by replacing the pair with pairSum array becomes decreasing
                    ++count;
                }
            }
            if(nextPairIdx < n) { //if nextPairIndex is in bound
                if(arr[nextIdx] > arr[nextPairIdx] && pairSum <= arr[nextPairIdx]) {
                    //by replacing the pair with pairSum array becomes non-decreasing
                    --count;
                } else if(arr[nextIdx] <= arr[nextPairIdx] && pairSum > arr[nextPairIdx]) {
                    //by replacing the pair with pairSum array becomes decreasing
                    ++count;
                }
            }

            //updating the pairs in the pairsSet and updating the previous and next index
            if(prevPairIdx >= 0) {
                pairsSet.remove(new Pair(arr[prevPairIdx] + arr[currIdx], prevPairIdx));
                pairsSet.add(new Pair(arr[prevPairIdx] + arr[currIdx] + arr[nextIdx], prevPairIdx));
            }
            if(nextPairIdx < n) {
                pairsSet.remove(new Pair(arr[nextIdx] + arr[nextPairIdx], nextIdx));
                pairsSet.add(new Pair(arr[currIdx] + arr[nextIdx] + arr[nextPairIdx], currIdx));
            }
            arr[currIdx] = pairSum;
            if(nextPairIdx < n) {
                prev[nextPairIdx] = currIdx;
            }
            next[currIdx] = nextPairIdx;

            res++; //increment the operations count
        }
        
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{5, 2, 3, 1}));
    }
}