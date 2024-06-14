package blind_75.array;

///https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductOfArrayExceptItself {

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int prefixProduct = 1;

        ///Result array will store the product of all the elements
        // from the left most part of the array, except that element.
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int postFixProduct = 1;

        ///Now the Result array will be updated, by multiplying with the
        // products from right side of the array.
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postFixProduct;
            postFixProduct *= nums[i];
        }

        return result;
    }

    public int[] enhancedVersionOfProductExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int backwardProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= backwardProduct;
            backwardProduct *= nums[i];
        }

        return result;
    }

}
