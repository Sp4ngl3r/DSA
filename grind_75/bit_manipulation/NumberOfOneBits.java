package grind_75.bit_manipulation;

///[Number of one bits](https://leetcode.com/problems/number-of-1-bits/description/)
public class NumberOfOneBits {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n % 2;
            n = n >> 1;
        }

        return count;
    }

    public int enhancedVersionOfHammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            ///This tries to remove the last set 1-bit in the binary number.
            n &= (n - 1);
            count++;
        }

        return count;
    }
}
