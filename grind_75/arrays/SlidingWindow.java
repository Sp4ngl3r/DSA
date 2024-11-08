package grind_75.arrays;

///[Best time to buy and sell stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)
public class SlidingWindow {

    public int maxProfit(int[] prices) {

        ///Left Pointer tries to hold the lowest price of the stock.
        int left = 0;

        ///Right Pointer tries to hold the highest price of the stock.
        int right = 1;

        int maximumProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                maximumProfit = Math.max(maximumProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }

        return maximumProfit;
    }
}
