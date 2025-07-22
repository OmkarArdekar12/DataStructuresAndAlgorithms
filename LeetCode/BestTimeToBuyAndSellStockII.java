// Best Time to Buy and Sell Stock II
// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the 
// stock at any time. However, you can buy it then immediately sell it on the same day.
// Find and return the maximum profit you can achieve.

public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int buyingPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0; i<n; ++i) {
            int currPrice = prices[i];
            if(currPrice < buyingPrice) {
                buyingPrice = currPrice;
            } else {
                int currProfit = currPrice - buyingPrice;
                profit += currProfit;
                buyingPrice = currPrice;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.err.println(maxProfit(prices));
    }
}
