// Candy
// There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
// You are giving candies to these children subjected to the following requirements:
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// Return the minimum number of candies you need to have to distribute the candies to the children.

public class Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int candy = n;
        int i = 1;
        while(i < n) {
            if(ratings[i] == ratings[i - 1]) {
                ++i;
                continue;
            }
            int a = 0; //left to right traverse
            while(i < n && ratings[i] > ratings[i - 1]) {
                ++a;
                candy += a;
                ++i;
            }
            int b = 0; //right to left traverse
            while(i < n && ratings[i] < ratings[i - 1]) {
                ++b;
                candy += b;
                ++i;
            }
            //Added candy from leftToRight and rightToLeft also, but answer will be max of them so, subtract minimum answer
            candy -= Math.min(a, b);
        }

        return candy;

        // int n = ratings.length;
        // int candies[] = new int[n];
        // for(int i=1; i<n; ++i) {
        //     if(ratings[i] > ratings[i-1]) {
        //         candies[i] = candies[i-1] + 1;
        //     }
        // }
        // for(int i=n-2; i>=0; --i) {
        //     if(ratings[i] > ratings[i+1]) {
        //         candies[i] = Math.max(candies[i], candies[i+1] + 1);
        //     }
        // }
        // int res = n + Arrays.stream(candies).sum();
        // return res;
    }

    public static void main(String[] args) {
        int ratings[] = {1, 0, 2};
        System.out.println(candy(ratings));
    }
}