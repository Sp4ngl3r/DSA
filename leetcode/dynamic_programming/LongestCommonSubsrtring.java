package dynamic_programming;

class LongestCommonSubstring {

    private static int lcs(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        // Create 2D array to store LCS length.
        int[][] dp = new int[m + 1][n + 1];
        int result = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // If the characters at the current indices are the same,
                // extend the LCS.
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int val = 1 + dp[i - 1][j - 1];
                    dp[i][j] = val;
                    result = Math.max(result, val);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(lcs("horse", "rose"));
    }
}
