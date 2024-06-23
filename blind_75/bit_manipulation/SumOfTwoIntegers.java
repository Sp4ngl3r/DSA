package blind_75.bit_manipulation;

public class SumOfTwoIntegers {

    public int sum(int a, int b) {

        while (b != 0) {
            ///If there is an addition of two 1s, then we
            // need carry to the next bit. Hence, we check if
            // both the bits are 1 (by using AND operator)
            // and shift these bits to right place by one.
            int carry = (a & b) << 1;

            ///XOR operator will have 0 for different bits,
            // and 1 for same bits
            a = a ^ b;
            b = carry;
        }

        return a;
    }

}
