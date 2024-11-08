package grind_75.bit_manipulation;

///[Counting Bits](https://leetcode.com/problems/counting-bits/description/)
public class CountingBits {

    ///This is also a Dynamic Programming Problem
    public int[] countBits(int n) {

        int[] result = new int[n + 1];
        int offset = 1;

        result[0] = 0;
        for (int i = 1; i <= n; i++) {

            if (offset * 2 == i) {
                offset = i;
            }

            result[i] = 1 + result[i - offset];
        }

        return result;
    }

}
