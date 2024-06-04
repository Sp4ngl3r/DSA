package blind_75;

public class SlidingWindow {

    public int maxProfit(int[] prices) {

        int left = 0;
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
