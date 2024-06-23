package blind_75.bit_manipulation;

///https://leetcode.com/problems/reverse-bits/description/
public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            ///Store the bit value of each of the unsigned value
            int bit = (n >> i) & 1;
            // Save it in the reverse order, from bit positions in left
            result = result | (bit << (31 - i));
        }

        return result;
    }

}
