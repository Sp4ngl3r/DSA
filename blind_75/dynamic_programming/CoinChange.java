package blind_75.dynamic_programming;

import java.util.Arrays;

///https://leetcode.com/problems/coin-change/description/
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        ///Instantiate array with amount + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        ///Base case
        dp[0] = 0;

        ///Loop through amount
        for (int i = 1; i <= amount; i++) {
            ///Loop through coins
            for (int coin : coins) {
                ///Check whether the dp array element can hold the current coin
                ///or the combination of previous coins.
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
